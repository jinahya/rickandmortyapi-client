package io.github.jinahya.rickandmortyapi.client.jre;

import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.ReactiveRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactiveRickAndMortyApiClientJre
        implements ReactiveRickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    public ReactiveRickAndMortyApiClientJre(final AsynchronousRickAndMortyApiClient client, final Executor executor) {
        super();
        this.client = Objects.requireNonNull(client, "client is null");
        this.executor = Objects.requireNonNull(executor, "executor is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public org.reactivestreams.Publisher<CharacterPage> getCharacterPagePublisher() throws IOException {
        return s -> {
            s.onSubscribe(new Subscription() {
                @Override
                public void request(final long n) {
                    if (canceled) {
                        return;
                    }
                    if (n < 1) {
                        cancel();
                        return;
                    }
                    for (int i = 0; i < n; i++) {
                        final var future = client.getAllCharacters(page.incrementAndGet()).whenCompleteAsync(
                                (v, t) -> {
                                    if (t != null) {
                                        s.onError(t);
                                        cancel();
                                        return;
                                    }
                                    if (v == null) {
                                        s.onComplete();
                                        cancel();
                                        return;
                                    }
                                    s.onNext(v);
                                },
                                executor
                        );
                        try {
                            final var value = future.get();
                            if (value == null) { // 404
                                s.onComplete();
                                cancel();
                                break;
                            }
                        } catch (final InterruptedException ie) {
                            Thread.currentThread().interrupt();
                            s.onError(ie);
                            cancel();
                            break;
                        } catch (final ExecutionException ee) {
                            s.onError(Optional.ofNullable(ee.getCause()).orElse(ee));
                            cancel();
                            break;
                        }
                    }
                }

                @Override
                public void cancel() {
                    this.canceled = true;
                }

                private AtomicInteger page = new AtomicInteger();

                private boolean canceled = false;
            });
        };
    }

    @Override
    public org.reactivestreams.Publisher<CharacterType> getCharacterTypePublisher() throws IOException {
        return s -> {
            s.onSubscribe(new Subscription() {
                @Override
                public void request(final long n) {
                    if (canceled) {
                        return;
                    }
                    if (n < 1) {
                        cancel();
                        return;
                    }
                    for (int p = 1; p <= n; p++) {
                    }
                }

                @Override
                public void cancel() {
                    this.canceled = true;
                }

                private boolean canceled = false;
            });
        };
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final AsynchronousRickAndMortyApiClient client;

    private final Executor executor;
}
