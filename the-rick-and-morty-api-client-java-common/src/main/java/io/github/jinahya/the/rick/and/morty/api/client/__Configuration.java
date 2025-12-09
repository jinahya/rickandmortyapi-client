package io.github.jinahya.the.rick.and.morty.api.client;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.time.Duration;

public interface __Configuration {

    @NotBlank
    default String getBaseUrl() {
        return TheRickAndMortyApiClientConstants.BASE_URL;

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
