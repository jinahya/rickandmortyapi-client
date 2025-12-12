package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public interface AsynchronousRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------ /character?page=
    @NotNull
    CompletableFuture<CharacterPage> getAllCharacters(@NotNull Executor executor, @Positive int page);

    default CompletableFuture<CharacterPage> getAllCharacters(@Positive final int page) {
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getAllCharacters(executor, page);
        }
    }

    @NotNull
    default CompletableFuture<List<CharacterType>> getAllCharacters(@NotNull Executor executor) {
        return AsynchronousRickAndMortyApiClientUtils.getAllCharacters(executor, this);
    }

    @NotNull
    default CompletableFuture<List<CharacterType>> getAllCharacters() {
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getAllCharacters(executor);
        }
    }

    // ------------------------------------------------------------------------------------------------ /character/1,2,3
    @NotNull
    CompletableFuture<List<CharacterType>> getCharacters(@NotNull Executor executor, @NotNull int... ids);

    default CompletableFuture<List<CharacterType>> getCharacters(@NotNull int... ids) {
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getCharacters(executor, ids);
        }
    }

    // ---------------------------------------------------------------------------------------------------- /character/1
    CompletableFuture<CharacterType> getCharacter(@NotNull Executor executor, @Positive int id);

    default CompletableFuture<CharacterType> getCharacter(@Positive int id) {
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getCharacter(executor, id);
        }
    }
}
