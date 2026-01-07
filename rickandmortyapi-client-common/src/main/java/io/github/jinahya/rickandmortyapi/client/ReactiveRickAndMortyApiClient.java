package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import org.reactivestreams.Publisher;

import java.io.IOException;

public interface ReactiveRickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character
    @NotNull
    Publisher<CharacterPage> getCharacterPagePublisher() throws IOException;

    @NotNull
    Publisher<CharacterType> getCharacterTypePublisher() throws IOException;
}
