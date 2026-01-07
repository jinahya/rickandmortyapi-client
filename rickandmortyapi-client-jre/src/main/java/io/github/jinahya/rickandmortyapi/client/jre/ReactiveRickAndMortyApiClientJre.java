package io.github.jinahya.rickandmortyapi.client.jre;

import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.ReactiveRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;

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
    public org.reactivestreams.Publisher<CharacterPage> getAllCharacters(final int page) throws IOException {
        return s -> client.getAllCharacters(page).whenCompleteAsync(
                (v, t) -> {
                    if (t != null) {
                        s.onError(t);
                    } else {
                        s.onNext(v);
                        s.onComplete();
                    }
                },
                executor
        );
    }

    @Override
    public org.reactivestreams.Publisher<CharacterType> getAllCharacters() {
        return s -> client.getAllCharacters().whenCompleteAsync(
                (v, t) -> {
                    if (t != null) {
                        s.onError(t);
                    } else {
                        v.forEach(s::onNext);
                        s.onComplete();
                    }
                },
                executor
        );
    }

    @Override
    public org.reactivestreams.Publisher<CharacterType> getCharacters(@NotNull final int... ids) {
        return null;
    }

    @Override
    public org.reactivestreams.Publisher<CharacterType> getCharacter(final int id) {
        return null;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final AsynchronousRickAndMortyApiClient client;

    private final Executor executor;
}
