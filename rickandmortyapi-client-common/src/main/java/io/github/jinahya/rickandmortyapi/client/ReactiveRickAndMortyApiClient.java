package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.reactivestreams.Publisher;

import java.io.IOException;

public interface ReactiveRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character
    @NotNull
    Publisher<CharacterPage> getAllCharacters(@Positive int page) throws IOException;

    @NotNull
    Publisher<CharacterType> getAllCharacters();

    @NotNull
    Publisher<CharacterType> getCharacters(@NotNull int... ids);

    @NotNull
    Publisher<CharacterType> getCharacter(@Positive int id);
}
