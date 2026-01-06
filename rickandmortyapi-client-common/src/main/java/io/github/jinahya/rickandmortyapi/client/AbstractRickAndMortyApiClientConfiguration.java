package io.github.jinahya.rickandmortyapi.client;

import jakarta.annotation.Nullable;

import java.time.Duration;
import java.util.Optional;

public abstract class AbstractRickAndMortyApiClientConfiguration
        implements RickAndMortyApiClientConfiguration {

    // -----------------------------------------------------------------------------------------------------------------
    protected AbstractRickAndMortyApiClientConfiguration() {
        super();
    }

    // --------------------------------------------------------------------------------------------------------- baseUrl
    @Override
    public String getBaseUrl() {
        return Optional.ofNullable(baseUrl)
                .orElseGet(RickAndMortyApiClientConfiguration.super::getBaseUrl);
    }

    public void setBaseUrl(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getConnectTimeout() {
        return Optional.ofNullable(connectTimeout)
                .orElseGet(RickAndMortyApiClientConfiguration.super::getConnectTimeout);
    }

    public void setConnectTimeout(final Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getWriteTimeout() {
        return Optional.ofNullable(writeTimeout)
                .orElseGet(RickAndMortyApiClientConfiguration.super::getWriteTimeout);
    }

    public void setWriteTimeout(final Duration writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getReadTimeout() {
        return Optional.ofNullable(readTimeout)
                .orElseGet(RickAndMortyApiClientConfiguration.super::getReadTimeout);
    }

    public void setReadTimeout(final Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getResponseTimeout() {
        return Optional.ofNullable(responseTimeout)
                .orElseGet(RickAndMortyApiClientConfiguration.super::getResponseTimeout);
    }

    public void setResponseTimeout(final Duration responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String baseUrl;

    // -----------------------------------------------------------------------------------------------------------------
    private Duration connectTimeout;

    private Duration writeTimeout;

    private Duration readTimeout;

    private Duration responseTimeout;
}
