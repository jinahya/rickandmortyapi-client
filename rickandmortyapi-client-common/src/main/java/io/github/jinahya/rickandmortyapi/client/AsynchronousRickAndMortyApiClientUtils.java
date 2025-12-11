package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

final class AsynchronousRickAndMortyApiClientUtils {

    // ------------------------------------------------------------------------------------------------------- character
    private static CompletableFuture<List<CharacterType>> getAllCharacters(
            final AsynchronousRickAndMortyApiClient client, final int page, final List<CharacterType> list) {
        return client.getAllCharacters(page).thenComposeAsync(r -> {
            if (r == null) {
                return CompletableFuture.completedFuture(list);
            }
            list.addAll(r.getResults());
            if (r.getInfo().getNext() == null) {
                return CompletableFuture.completedFuture(list);
            }
            return getAllCharacters(client, page + 1, list);
        });
    }

    static CompletableFuture<List<CharacterType>> getAllCharacters(final AsynchronousRickAndMortyApiClient client) {
        return getAllCharacters(client, 1, new ArrayList<>());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private AsynchronousRickAndMortyApiClientUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
