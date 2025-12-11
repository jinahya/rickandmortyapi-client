package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsynchronousRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character
    @NotNull
    CompletableFuture<CharacterPageResponse> getAllCharacters(@Positive int page);

    @NotNull
    default CompletableFuture<List<CharacterType>> getAllCharacters() {
        return AsynchronousRickAndMortyApiClientUtils.getAllCharacters(this);
    }

    @NotNull
    CompletableFuture<List<CharacterType>> getCharacters(@NotNull int... ids);

    CompletableFuture<CharacterType> getCharacter(int id);
}
