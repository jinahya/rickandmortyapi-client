package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

final class AsynchronousRickAndMortyApiClientUtils {

    static Executor requireNonNullExecutor(final Executor executor) {
        return Objects.requireNonNull(executor, "executor is null");
    }

    // ------------------------------------------------------------------------------------------------------- character
    private static CompletableFuture<List<CharacterType>> getAllCharacters(
            final Executor executor, final AsynchronousRickAndMortyApiClient client, final int page,
            final List<CharacterType> list) {
        Objects.requireNonNull(executor, "executor is null");
        return client.getAllCharacters(page, executor).thenComposeAsync(r -> {
            if (r == null) {
                return CompletableFuture.completedFuture(list);
            }
            list.addAll(r.getResults());
            if (r.getInfo().getNext() == null) {
                return CompletableFuture.completedFuture(list);
            }
            return getAllCharacters(executor, client, page + 1, list);
        });
    }

    static CompletableFuture<List<CharacterType>> getAllCharacters(final Executor executor,
                                                                   final AsynchronousRickAndMortyApiClient client) {
        return getAllCharacters(executor, client, 1, new ArrayList<>());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private AsynchronousRickAndMortyApiClientUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
