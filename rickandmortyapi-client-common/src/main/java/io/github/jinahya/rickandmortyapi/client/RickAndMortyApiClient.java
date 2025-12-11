package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePage;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPage;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public interface RickAndMortyApiClient {

    // ------------------------------------------------------------------------------------------------------- character

    /**
     * Reads characters on the specified page.
     *
     * @param page the page; must be positive.
     * @return an optional of the characters, on the {@code page}; {@link Optional#empty() empty} if the specified page
     * does not exist.
     * @throws IllegalArgumentException if {@code page} is not positive.
     * @throws IOException              if an I/O error occurs.
     * @see <a href="https://rickandmortyapi.com/documentation/#get-all-characters">Get all characters</a>
     */
    Optional<CharacterPage> getAllCharacters(int page) throws IOException;

    /**
     * Reads all characters.
     *
     * @return a list of all characters.
     */
    @NotEmpty
    default List<@Valid @NotNull CharacterType> getAllCharacters() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(p -> {
                    try {
                        return getAllCharacters(p);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to get characters on page " + p, ioe);
                    }
                })
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull CharacterType> getCharacters(@NotNull int... ids) throws IOException;

    @Valid
    @NotNull
    Optional<CharacterType> getCharacter(final int id) throws IOException;

    // --------------------------------------------------------------------------------------------------------- episode
    @Valid
    @NotNull
    Optional<EpisodePage> getAllEpisodes(@Positive int page) throws IOException;

    @NotNull
    default List<@Valid @NotNull EpisodeType> getAllEpisodes() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(p -> {
                    try {
                        return getAllEpisodes(p);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to get episodes on page " + p, ioe);
                    }
                })
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull EpisodeType> getEpisodes(@NotNull int... ids) throws IOException;

    @Valid
    @NotNull
    default Optional<EpisodeType> getEpisode(int id) throws IOException {
        return getEpisodes(id).stream().findFirst();
    }

    // -------------------------------------------------------------------------------------------------------- location
    @Valid
    @NotNull
    Optional<LocationPage> getAllLocations(@Positive int page) throws IOException;

    @NotNull
    default List<@Valid @NotNull LocationType> getAllLocations() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(p -> {
                    try {
                        return getAllLocations(p);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException("failed to get locations on page " + p, ioe);
                    }
                })
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull LocationType> getLocations(@NotNull int... ids) throws IOException;

    @Valid
    @NotNull
    default Optional<LocationType> getLocation(int id) throws IOException {
        return getLocations(id).stream().findFirst();
    }
}
