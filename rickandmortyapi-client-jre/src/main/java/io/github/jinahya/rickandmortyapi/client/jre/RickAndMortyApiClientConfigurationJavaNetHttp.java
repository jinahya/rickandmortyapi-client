package io.github.jinahya.rickandmortyapi.client.jre;

import java.net.http.HttpClient;
import java.util.Objects;
import java.util.Optional;

public class RickAndMortyApiClientConfigurationJavaNetHttp
        extends _RickAndMortyApiClientConfigurationJre {

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientConfigurationJavaNetHttp() {
        super();
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
