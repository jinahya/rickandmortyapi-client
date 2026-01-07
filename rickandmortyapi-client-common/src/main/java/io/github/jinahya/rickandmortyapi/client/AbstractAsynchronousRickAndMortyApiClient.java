package io.github.jinahya.rickandmortyapi.client;

import java.util.Objects;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class AbstractAsynchronousRickAndMortyApiClient<
        CONFIGURATION extends RickAndMortyApiClientConfiguration
        >
        implements AsynchronousRickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    protected AbstractAsynchronousRickAndMortyApiClient(final CONFIGURATION configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final CONFIGURATION configuration;
}
