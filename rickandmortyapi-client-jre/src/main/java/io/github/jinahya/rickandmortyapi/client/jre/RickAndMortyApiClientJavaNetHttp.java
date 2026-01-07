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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RickAndMortyApiClientJavaNetHttp implements RickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientJavaNetHttp(final RickAndMortyApiClientConfigurationJavaNetHttp configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
        httpClient = this.configuration.configure(HttpClient.newBuilder()).build();
    }

    RickAndMortyApiClientJavaNetHttp() {
        this(new RickAndMortyApiClientConfigurationJavaNetHttp());
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
            final T body = response.body();
            return Optional.ofNullable(body);
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
            return response.body();
        } catch (final InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted while reading " + path, ie);
        }
    }

    // ------------------------------------------------------------------------------------------------------ /character
    @Override
    public Optional<CharacterPage> getAllCharacters(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
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
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/character/" + RickAndMortyApiClientUtils.joinIds(ids),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<CharacterType> getCharacter(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return read(
                "/character/" + id,
                CharacterType.class
        );
    }

    // -------------------------------------------------------------------------------------------------------- /episode
    @Override
    public Optional<EpisodePage> getAllEpisodes(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return read(
                "/episode?page=" + page,
                EpisodePage.class
        );
    }

    @Override
    public List<EpisodeType> getAllEpisodes() {
        return RickAndMortyApiClient.super.getAllEpisodes();
    }

    @Override
    public List<EpisodeType> getEpisodes(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/episode/" + RickAndMortyApiClientUtils.joinIds(ids),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<EpisodeType> getEpisode(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return read(
                "/episode/" + id,
                EpisodeType.class
        );
    }

    // ------------------------------------------------------------------------------------------------------- /location
    @Override
    public Optional<LocationPage> getAllLocations(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return read(
                "/location?page=" + page,
                LocationPage.class
        );
    }

    @Override
    public List<LocationType> getAllLocations() {
        return RickAndMortyApiClient.super.getAllLocations();
    }

    @Override
    public List<LocationType> getLocations(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/location/" + RickAndMortyApiClientUtils.joinIds(ids),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<LocationType> getLocation(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return read(
                "/location/" + id,
                LocationType.class
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJavaNetHttp configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
