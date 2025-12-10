package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.BasePageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public interface AsynchronousRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character
    @NotNull
    CompletableFuture<CharacterPageResponse> getAllCharacters(@Positive int page) throws IOException;

    @NotNull
    default CompletableFuture<List<CharacterType>> getAllCharacters() throws IOException {
        final var page = new AtomicInteger(1);
        final List<CharacterType> list = new ArrayList<>();
        return getAllCharacters(page.getAndIncrement()).thenComposeAsync(r -> {
            final var results = r.getResults();
            list.addAll(results);
            final var info = r.getInfo();
            if (info.getNext() == null) {
                return CompletableFuture.completedFuture(list);
            }
            try {
                return getAllCharacters(page.getAndIncrement()).thenApply(BasePageResponse::getResults);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @NotNull
    CompletableFuture<List<CharacterType>> getCharacters(@NotNull int... ids);

    @NotNull
    default CompletableFuture<CharacterType> getCharacter(final int id) {
        return getCharacters(id)
                .thenApply(l -> l.stream().findFirst().orElse(null));
    }
}
