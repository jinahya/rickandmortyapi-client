package io.github.jinahya.rickandmortyapi.client.javanet;

import io.github.jinahya.rickandmortyapi.client.AbstractRickAndMortyApiClientConfiguration;

import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.Objects;
import java.util.Optional;

public class RickAndMortyApiClientJavaNetConfiguration extends AbstractRickAndMortyApiClientConfiguration {

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientJavaNetConfiguration() {
        super();
    }

    <T extends URLConnection> T configure(final T connection) {
        Objects.requireNonNull(connection, "connection is null");
        Optional.ofNullable(getConnectTimeout()).ifPresent(v -> {
            connection.setConnectTimeout(Math.toIntExact(v.toMillis()));
        });
        Optional.ofNullable(getWriteTimeout()).ifPresent(v -> {
        });
        Optional.ofNullable(getReadTimeout()).ifPresent(v -> {
            connection.setReadTimeout(Math.toIntExact(v.toMillis()));
        });
        Optional.ofNullable(getResponseTimeout()).ifPresent(v -> {
        });
        return connection;
    }

    HttpClient.Builder configure(final HttpClient.Builder builder) {
        Objects.requireNonNull(builder, "builder is null");
        Optional.ofNullable(getConnectTimeout()).ifPresent(v -> {
            builder.connectTimeout(v);
        });
        Optional.ofNullable(getWriteTimeout()).ifPresent(v -> {
        });
        Optional.ofNullable(getReadTimeout()).ifPresent(v -> {
        });
        Optional.ofNullable(getResponseTimeout()).ifPresent(v -> {
        });
        return builder;
    }
}
