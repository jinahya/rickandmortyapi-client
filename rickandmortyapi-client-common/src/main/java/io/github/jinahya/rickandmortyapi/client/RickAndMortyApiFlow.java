package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.util.concurrent.Flow;

public interface RickAndMortyApiFlow {

    // ------------------------------------------------------------------------------------------------------- character
    interface CharacterPagePublisher
            extends Flow.Publisher<CharacterPage> {

    }

    interface CharacterPublisher
            extends Flow.Publisher<CharacterType> {

    }
}
