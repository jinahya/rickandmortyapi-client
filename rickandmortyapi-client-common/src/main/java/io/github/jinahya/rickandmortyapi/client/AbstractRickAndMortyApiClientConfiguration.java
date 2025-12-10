package io.github.jinahya.rickandmortyapi.client;

import jakarta.annotation.Nullable;

import java.time.Duration;

public abstract class AbstractRickAndMortyApiClientConfiguration implements RickAndMortyApiClientConfiguration {

    // -----------------------------------------------------------------------------------------------------------------
    protected AbstractRickAndMortyApiClientConfiguration() {
        super();
    }

    // --------------------------------------------------------------------------------------------------------- baseUrl
    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(final Duration connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(final Duration writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(final Duration readTimeout) {
        this.readTimeout = readTimeout;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    @Override
    public Duration getResponseTimeout() {
        return responseTimeout;
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
