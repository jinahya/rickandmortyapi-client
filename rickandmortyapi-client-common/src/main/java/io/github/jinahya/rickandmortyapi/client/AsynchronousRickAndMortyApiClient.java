package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface AsynchronousRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character
    @NotNull
    CompletableFuture<CharacterPageResponse> getAllCharacters(@Positive int page) throws IOException;

    @NotNull
    CompletableFuture<CharacterType> getAllCharacters();

    @NotNull
    CompletableFuture<CharacterType> getCharacters(@NotNull int... ids);

    @NotNull
    CompletableFuture<CharacterType> getCharacter(int id);
}
