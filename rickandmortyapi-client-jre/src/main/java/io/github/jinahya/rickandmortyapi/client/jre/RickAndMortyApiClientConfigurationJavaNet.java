package io.github.jinahya.rickandmortyapi.client.jre;

import java.net.URLConnection;
import java.util.Objects;
import java.util.Optional;

public class RickAndMortyApiClientConfigurationJavaNet
        extends _RickAndMortyApiClientConfigurationJre {

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientConfigurationJavaNet() {
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
}
