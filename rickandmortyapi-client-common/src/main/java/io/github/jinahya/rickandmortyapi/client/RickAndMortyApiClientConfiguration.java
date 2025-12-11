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
        return Duration.ofSeconds(8L);
    }

    @Nullable
    default Duration getWriteTimeout() {
        return Duration.ofSeconds(8L);
    }

    @Nullable
    default Duration getReadTimeout() {
        return Duration.ofSeconds(8L);
    }

    @Nullable
    default Duration getResponseTimeout() {
        return Duration.ofSeconds(8L);
    }
}
