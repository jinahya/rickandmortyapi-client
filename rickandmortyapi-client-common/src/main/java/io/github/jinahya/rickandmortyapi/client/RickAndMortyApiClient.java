package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePageResponse;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;
import jakarta.validation.Valid;
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
     * Returns a character page of the specified page number.
     *
     * @param page the page number; must be positive.
     * @return a character page response.
     */
    @Valid
    @NotNull
    Optional<CharacterPageResponse> getAllCharacters(@Positive int page) throws IOException;

    @NotNull
    default List<@Valid @NotNull CharacterType> getAllCharacters() {
        return IntStream.iterate(1, v -> v + 1)
                .mapToObj(p -> {
                    try {
                        return getAllCharacters(p);
                    } catch (final IOException ioe) {
                        throw new UncheckedIOException(ioe);
                    }
                })
                .takeWhile(Optional::isPresent)
                .flatMap(v -> v.get().getResults().stream())
                .toList();
    }

    @NotNull
    List<@Valid @NotNull CharacterType> getCharacters(@NotNull int... ids);

    @Valid
    @NotNull
    default Optional<CharacterType> getCharacter(int id) {
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
