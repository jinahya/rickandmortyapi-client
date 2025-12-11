package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePage;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPage;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RickAndMortyApiClientJavaNetHttp implements RickAndMortyApiClient {

    private static <T> HttpResponse.BodyHandler<T> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                                      final Class<T> clazz) {
        return ri -> {
            {
                final var statusCode = ri.statusCode();
                if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                    @SuppressWarnings({"unchecked"}) final var unchecked =
                            (HttpResponse.BodySubscriber<T>) HttpResponse.BodySubscribers.discarding();
                    return unchecked;
                }
                if (statusCode != HttpURLConnection.HTTP_OK) {
                    throw new RuntimeException("unexpected status code: " + statusCode);
                }
                ri.headers().map().forEach((n, l) -> {
                });
            }
            return HttpResponse.BodySubscribers.mapping(
                    HttpResponse.BodySubscribers.ofInputStream(),
                    b -> {
                        try {
                            return objectMapper.readValue(b, clazz);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    });
        };
    }

    private static <T> HttpResponse.BodyHandler<T> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                                      final TypeReference<T> type) {
        return ri -> {
            {
                final var statusCode = ri.statusCode();
                ri.headers().map().forEach((n, l) -> {
                });
            }
            return HttpResponse.BodySubscribers.mapping(
                    HttpResponse.BodySubscribers.ofInputStream(),
                    b -> {
                        try {
                            return objectMapper.readValue(b, type);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    });
        };
    }

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientJavaNetHttp(final RickAndMortyApiClientConfigurationJre configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
        httpClient = this.configuration.configure(HttpClient.newBuilder()).build();
    }

    RickAndMortyApiClientJavaNetHttp() {
        this(new RickAndMortyApiClientConfigurationJre());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URI uri(final String path) {
        Objects.requireNonNull(path, "path is null");
        return URI.create(configuration.getBaseUrl() + path);
    }

    private <T> Optional<T> read(final String path, final Class<T> type) throws IOException {
        Objects.requireNonNull(type, "type is null");
        try {
            final var response = httpClient.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(uri(path))
                            .build(),
                    _JavaNetHttpUtils.newJsonBodyHandler(objectMapper, type)
            );
            final var statusCode = response.statusCode();
            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                return Optional.empty();
            }
            if (statusCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("unexpected response code: " + statusCode);
            }
            final T body = response.body().get();
            return Optional.of(body);
        } catch (final InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while reading " + path, ie);
        }
    }

    private <T> T read(final String path, final TypeReference<T> type) throws IOException {
        Objects.requireNonNull(type, "type is null");
        try {
            final var response = httpClient.send(
                    HttpRequest.newBuilder()
                            .GET()
                            .uri(uri(path))
                            .build(),
                    _JavaNetHttpUtils.newJsonBodyHandler(objectMapper, type)
            );
            final var statusCode = response.statusCode();
            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new IOException("not found; path: " + path);
            }
            if (statusCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("unexpected response code: " + statusCode);
            }
            return response.body().get();
        } catch (final InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while reading " + path, ie);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Optional<CharacterPage> getAllCharacters(final int page) throws IOException {
        RickAndMortyApiClientUtils.requirePositivePage(page);
        return read(
                "/character?page=" + page,
                CharacterPage.class
        );
    }

    @Override
    public List<CharacterType> getAllCharacters() {
        return RickAndMortyApiClient.super.getAllCharacters();
    }

    @Override
    public List<CharacterType> getCharacters(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireNonEmptyIds(ids);
        return read(
                "/character/" + RickAndMortyApiClientUtils.joinIds(ids),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<CharacterType> getCharacter(final int id) throws IOException {
        RickAndMortyApiClientUtils.requirePositiveId(id);
        return read(
                "/character/" + id,
                CharacterType.class
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Optional<EpisodePage> getAllEpisodes(final int page) throws IOException {
        return Optional.empty();
    }

    @Override
    public List<EpisodeType> getAllEpisodes() {
        return RickAndMortyApiClient.super.getAllEpisodes();
    }

    @Override
    public List<EpisodeType> getEpisodes(final int... ids) throws IOException {
        return List.of();
    }

    @Override
    public Optional<EpisodeType> getEpisode(final int id) throws IOException {
        return Optional.empty();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Optional<LocationPage> getAllLocations(final int page) throws IOException {
        return Optional.empty();
    }

    @Override
    public List<LocationType> getLocations(final int... ids) throws IOException {
        return List.of();
    }

    @Override
    public Optional<LocationType> getLocation(final int id) throws IOException {
        return Optional.empty();
    }

    @Override
    public List<LocationType> getAllLocations() {
        return RickAndMortyApiClient.super.getAllLocations();
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJre configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
