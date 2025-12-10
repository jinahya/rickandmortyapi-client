package io.github.jinahya.rickandmortyapi.client;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.time.Duration;

public interface RickAndMortyApiClientConfiguration {

    @NotBlank
    default String getBaseUrl() {
        return RickAndMortyApiClientConstants.BASE_URL;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    default Duration getConnectTimeout() {
        return null;
    }

    @Nullable
    default Duration getWriteTimeout() {
        return null;
    }

    @Nullable
    default Duration getReadTimeout() {
        return null;
    }

    @Nullable
    default Duration getResponseTimeout() {
        return null;
    }
}
