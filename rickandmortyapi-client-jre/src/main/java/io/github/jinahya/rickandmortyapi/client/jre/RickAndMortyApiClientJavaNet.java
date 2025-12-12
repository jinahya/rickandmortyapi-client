package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientConstants;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePage;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPage;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RickAndMortyApiClientJavaNet implements RickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    public RickAndMortyApiClientJavaNet(final RickAndMortyApiClientConfigurationJre configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
    }

    RickAndMortyApiClientJavaNet() {
        this(new RickAndMortyApiClientConfigurationJre());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private <R> R applyConnection(final String path, final Function<? super HttpURLConnection, ? extends R> function)
            throws IOException {
        Objects.requireNonNull(path, "path is null");
        Objects.requireNonNull(function, "function is null");
        final var uri = URI.create(configuration.getBaseUrl() + path);
        final var url = uri.toURL();
        final var connection = (HttpURLConnection) url.openConnection();
        configuration.configure(connection);
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

    private <R> R read(final String path, final Function<? super InputStream, ? extends R> mapper) throws IOException {
        Objects.requireNonNull(mapper, "mapper is null");
        return applyConnection(
                path,
                c -> {
                    try {
                        final var responseCode = c.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                            return null;
                        }
                        if (responseCode != HttpURLConnection.HTTP_OK) {
                            throw new IOException("unexpected response code: " + responseCode);
                        }
                        return mapper.apply(c.getInputStream());
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to read " + path, ioe);
                    }
                }
        );
    }

    private <T> T read(final String path, final Class<T> type) throws IOException {
        Objects.requireNonNull(type, "type is null");
        return read(
                path,
                b -> {
                    try {
                        return objectMapper.readValue(b, type);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to read " + path, ioe);
                    }
                }
        );
    }

    private <T> T read(final String path, final TypeReference<T> type) throws IOException {
        Objects.requireNonNull(type, "type is null");
        return read(
                path,
                b -> {
                    try {
                        return objectMapper.readValue(b, type);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to read " + path, ioe);
                    }
                }
        );
    }

    // ------------------------------------------------------------------------------------------------------ characters
    @Override
    public Optional<CharacterPage> getAllCharacters(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return Optional.ofNullable(read(
                "/character?" + RickAndMortyApiClientConstants.PARAM_PAGE + "=" + page,
                CharacterPage.class
        ));
    }

    @Override
    public List<CharacterType> getCharacters(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/character/" + IntStream.of(ids).distinct().mapToObj(String::valueOf).collect(Collectors.joining(",")),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<CharacterType> getCharacter(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return Optional.ofNullable(read(
                "/character/" + id,
                CharacterType.class
        ));
    }

    // -------------------------------------------------------------------------------------------------------- episodes
    @Override
    public Optional<EpisodePage> getAllEpisodes(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return Optional.ofNullable(read(
                "/episode?" + RickAndMortyApiClientConstants.PARAM_PAGE + "=" + page,
                EpisodePage.class
        ));
    }

    @Override
    public List<EpisodeType> getEpisodes(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/episode/" + IntStream.of(ids).distinct().mapToObj(String::valueOf).collect(Collectors.joining(",")),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<EpisodeType> getEpisode(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return Optional.ofNullable(read(
                "/episode/" + id,
                EpisodeType.class
        ));
    }

    // -------------------------------------------------------------------------------------------------------- locations
    @Override
    public Optional<LocationPage> getAllLocations(final int page) throws IOException {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return Optional.ofNullable(read(
                "/location?" + RickAndMortyApiClientConstants.PARAM_PAGE + "=" + page,
                LocationPage.class
        ));
    }

    @Override
    public List<LocationType> getLocations(final int... ids) throws IOException {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return read(
                "/location/" + IntStream.of(ids).distinct().mapToObj(String::valueOf).collect(Collectors.joining(",")),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public Optional<LocationType> getLocation(final int id) throws IOException {
        RickAndMortyApiClientUtils.requireValidId(id);
        return Optional.ofNullable(read(
                "/location/" + id,
                LocationType.class
        ));
    }

    // -----------------------------------------------------------------------------------------------------------------
    final RickAndMortyApiClientConfigurationJre configuration;

    final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
