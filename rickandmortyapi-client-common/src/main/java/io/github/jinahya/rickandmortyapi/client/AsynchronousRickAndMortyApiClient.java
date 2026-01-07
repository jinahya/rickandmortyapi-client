package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public interface AsynchronousRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------ /character?page=
    @NotNull
    CompletableFuture<Supplier<CharacterPage>> getAllCharactersDeferred(@Positive int page);

    @NotNull
    default CompletableFuture<CharacterPage> getAllCharacters(@Positive final int page,
                                                              @NotNull final Executor executor) {
        AsynchronousRickAndMortyApiClientUtils.requireNonNullExecutor(executor);
        return getAllCharactersDeferred(page)
                .thenApplyAsync(Supplier::get, executor);
    }

    default CompletableFuture<CharacterPage> getAllCharacters(@Positive final int page) {
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getAllCharacters(page, executor);
        }
    }

    @NotNull
    default CompletableFuture<List<CharacterType>> getAllCharacters(@NotNull final Executor executor) {
        AsynchronousRickAndMortyApiClientUtils.requireNonNullExecutor(executor);
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
    CompletableFuture<Supplier<List<CharacterType>>> getCharactersDeferred(@NotNull int... ids);

    @NotNull
    default CompletableFuture<List<CharacterType>> getCharacters(@NotNull final int[] ids,
                                                                 @NotNull final Executor executor) {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        AsynchronousRickAndMortyApiClientUtils.requireNonNullExecutor(executor);
        return getCharactersDeferred(ids)
                .thenApplyAsync(Supplier::get, executor);
    }

    default CompletableFuture<List<CharacterType>> getCharacters(@NotNull final int... ids) {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getCharacters(ids, executor);
        }
    }

    // ---------------------------------------------------------------------------------------------------- /character/1
    CompletableFuture<Supplier<CharacterType>> getCharacterDeferred(@Positive int id);

    default CompletableFuture<CharacterType> getCharacter(@Positive final int id, @NotNull final Executor executor) {
        RickAndMortyApiClientUtils.requireValidId(id);
        AsynchronousRickAndMortyApiClientUtils.requireNonNullExecutor(executor);
        return getCharacterDeferred(id)
                .thenApplyAsync(Supplier::get, executor);
    }

    default CompletableFuture<CharacterType> getCharacter(@Positive final int id) {
        RickAndMortyApiClientUtils.requireValidId(id);
        try (var executor = Executors.newSingleThreadExecutor()) {
            return getCharacter(id, executor);
        }
    }
}
