package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePageResponse;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPageResponse;
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
     * @return an optional of the characters, on the {@code page}; {@link Optional#empty()} if the specified page does
     * not exist.
     */
    @Valid
    @NotNull
    Optional<CharacterPageResponse> getAllCharacters(@Positive int page) throws IOException;

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
    default Optional<CharacterType> getCharacter(final int id) throws IOException {
        return getCharacters(id).stream().findFirst();
    }

    // --------------------------------------------------------------------------------------------------------- episode
    @Valid
    @NotNull
    Optional<EpisodePageResponse> getAllEpisodes(@Positive int page);

    @NotNull
    default List<@Valid @NotNull EpisodeType> getAllEpisodes() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(this::getAllEpisodes)
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull EpisodeType> getEpisodes(@NotNull int... ids);

    @Valid
    @NotNull
    default Optional<EpisodeType> getEpisode(int id) {
        return getEpisodes(id).stream().findFirst();
    }

    // -------------------------------------------------------------------------------------------------------- location
    @Valid
    @NotNull
    Optional<LocationPageResponse> getAllLocations(@Positive int page);

    @NotNull
    default List<@Valid @NotNull LocationType> getAllLocations() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(this::getAllLocations)
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull LocationType> getLocations(@NotNull int... ids);

    @Valid
    @NotNull
    default Optional<LocationType> getLocation(int id) {
        return getLocations(id).stream().findFirst();
    }
}
