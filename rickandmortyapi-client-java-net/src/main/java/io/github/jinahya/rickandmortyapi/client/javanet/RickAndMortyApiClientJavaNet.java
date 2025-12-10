package io.github.jinahya.rickandmortyapi.client.javanet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePageResponse;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class RickAndMortyApiClientJavaNet implements RickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    private static final class InstanceHolder {

        private static final RickAndMortyApiClientJavaNet INSTANCE = new RickAndMortyApiClientJavaNet();

        private InstanceHolder() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    public static RickAndMortyApiClientJavaNet getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientJavaNet() {
        super();
        configuration = RickAndMortyApiClientConfigurationJavaNet.getInstance();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private <R> R applyConnection(final String path, final Function<? super HttpURLConnection, ? extends R> function)
            throws IOException {
        Objects.requireNonNull(path, "path is null");
        Objects.requireNonNull(function, "function is null");
        final var uri = URI.create(configuration.getBaseUrl() + path);
        final var url = uri.toURL();
        final var connection = (HttpURLConnection) url.openConnection();
        Optional.ofNullable(configuration.getConnectTimeout())
                .ifPresent(v -> {
                    connection.setConnectTimeout(Math.toIntExact(v.toMillis()));
                });
        Optional.ofNullable(configuration.getWriteTimeout())
                .ifPresent(v -> {
                });
        Optional.ofNullable(configuration.getReadTimeout()).ifPresent(v -> {
            connection.setReadTimeout(Math.toIntExact(v.toMillis()));
        });
        Optional.ofNullable(configuration.getResponseTimeout()).ifPresent(v -> {
        });
        connection.setRequestMethod("GET");
        connection.setDoOutput(false);
        connection.setDoInput(true);
        try {
            connection.connect();
            return function.apply(connection);
        } finally {
            connection.disconnect();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public Optional<CharacterPageResponse> getAllCharacters(final int page) throws IOException {
        final var result = applyConnection("/character", c -> {
            try {
                final var responseCode = c.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw new IOException("unexpected response code: " + responseCode);
                }
                final var input = c.getInputStream();
                return objectMapper.readValue(input, CharacterPageResponse.class);
            } catch (final IOException ioe) {
                throw new UncheckedIOException(ioe);
            }
        });
        return Optional.empty();
    }

    @Override
    public List<@Valid @NotNull CharacterType> getCharacters(@NotNull int... ids) {
        return List.of();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public Optional<EpisodePageResponse> getAllEpisodes(int page) {
        return Optional.empty();
    }

    @Override
    public List<@Valid @NotNull EpisodeType> getEpisodes(@NotNull int... ids) {
        return List.of();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public Optional<LocationPageResponse> getAllLocations(int page) {
        return Optional.empty();
    }

    @Override
    public List<@Valid @NotNull LocationType> getLocations(@NotNull int... ids) {
        return List.of();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJavaNet configuration;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
