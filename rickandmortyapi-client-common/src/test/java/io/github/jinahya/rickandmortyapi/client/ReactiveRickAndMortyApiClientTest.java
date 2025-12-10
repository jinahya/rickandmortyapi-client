package io.github.jinahya.rickandmortyapi.client;

import java.util.Objects;

public abstract class ReactiveRickAndMortyApiClientTest<T extends ReactiveRickAndMortyApiClient> {

    protected ReactiveRickAndMortyApiClientTest(final Class<T> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
    }

    protected final Class<T> typeClass;
}
