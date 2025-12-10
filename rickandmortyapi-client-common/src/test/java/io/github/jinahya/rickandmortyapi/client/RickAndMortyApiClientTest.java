package io.github.jinahya.rickandmortyapi.client;

import java.util.Objects;

public abstract class RickAndMortyApiClientTest<T extends RickAndMortyApiClient> {

    protected RickAndMortyApiClientTest(final Class<T> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
    }

    protected final Class<T> typeClass;
}
