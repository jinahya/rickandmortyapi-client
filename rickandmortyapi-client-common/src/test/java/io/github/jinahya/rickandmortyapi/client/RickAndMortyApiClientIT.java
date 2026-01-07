package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.BasePageType;
import io.github.jinahya.rickandmortyapi.client.type.BaseSingularType;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import io.github.jinahya.rickandmortyapi.client.type.EpisodePage;
import io.github.jinahya.rickandmortyapi.client.type.EpisodeType;
import io.github.jinahya.rickandmortyapi.client.type.LocationPage;
import io.github.jinahya.rickandmortyapi.client.type.LocationType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class RickAndMortyApiClientIT<CLIENT extends RickAndMortyApiClient> {

    protected RickAndMortyApiClientIT(final Class<CLIENT> clientClass) {
        super();
        this.clientClass = Objects.requireNonNull(clientClass, "clientClass is null");
    }

    abstract class _IT<PAGE extends BasePageType<RESULT>, RESULT extends BaseSingularType> {

        _IT(final Function<? super CLIENT, ? extends IntFunction<? extends Optional<PAGE>>> pageInvoker,
            final Function<? super CLIENT, ? extends List<RESULT>> allInvoker,
            final Function<? super CLIENT, ? extends Function<? super int[], ? extends List<RESULT>>> multipleInvoker,
            final Function<? super CLIENT, ? extends IntFunction<? extends Optional<RESULT>>> singleInvoker,
            final int lastPage,
            final int lastId) {
            super();
            this.pageInvoker = Objects.requireNonNull(pageInvoker, "pageInvoker is null");
            this.allInvoker = Objects.requireNonNull(allInvoker, "allInvoker is null");
            this.multipleInvoker = Objects.requireNonNull(multipleInvoker, "multipleInvoker is null");
            this.singleInvoker = Objects.requireNonNull(singleInvoker, "singleInvoker is null");
            this.lastPage = lastPage;
            this.lastId = lastId;
        }

        // -------------------------------------------------------------------------------------------------------- page
        @DisplayName("getAll...(page)")
        abstract class _GetAllWithPage_IT {

            @Test
            void __firstPage() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                // ------------------------------------------------------------------------------------------------ when
                final var result = pageInvoker.apply(instance).apply(1);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).hasValueSatisfying(v -> {
                    assertThat(v.getInfo()).isNotNull();
                    assertThat(v.getResults()).isNotEmpty()
                            .isSortedAccordingTo(Comparator.comparingInt(BaseSingularType::getId));
                });
            }

            @Test
            void __lastPage() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                // ------------------------------------------------------------------------------------------------ when
                final var result = pageInvoker.apply(instance).apply(lastPage);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).hasValueSatisfying(v -> {
                    assertThat(v.getInfo()).isNotNull();
                    assertThat(v.getResults()).isNotEmpty()
                            .isSortedAccordingTo(Comparator.comparingInt(BaseSingularType::getId))
                            .satisfies(l -> {
                                assertThat(l.getLast().getId()).isEqualTo(lastId);
                            });
                });
            }

            @Test
            void _Empty_BeyondLastPage() {
                // -----------------------------------------------------------------------------------------------------
                final var instance = newClientInstance();
                final var page = lastPage + 1;
                // -----------------------------------------------------------------------------------------------------
                final var result = pageInvoker.apply(instance).apply(page);
                // -----------------------------------------------------------------------------------------------------
                assertThat(result).isEmpty();
            }
        }

        @DisplayName("getAll...()")
        abstract class _GetAll_IT {

            @Test
            void __() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                // ------------------------------------------------------------------------------------------------ when
                final var result = allInvoker.apply(instance);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result)
                        .isNotEmpty()
                        .isSortedAccordingTo(Comparator.comparingInt(BaseSingularType::getId));
                __(result);
            }

            void __(final List<RESULT> result) {
                // empty
            }
        }

        @DisplayName("get...(ids)")
        abstract class _GetWithIds_IT {

            @Test
            void __123() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                final var ids = new int[]{1, 2, 3};
                // ------------------------------------------------------------------------------------------------ when
                final var result = multipleInvoker.apply(instance).apply(ids);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).hasSizeLessThanOrEqualTo(ids.length).satisfies(l -> {
                });
            }
        }

        @DisplayName("get...(id)")
        abstract class _GetWithId_IT {

            @Test
            void __firstId() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                final var id = 1;
                // ------------------------------------------------------------------------------------------------ when
                final var result = singleInvoker.apply(instance).apply(id);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).hasValueSatisfying(v -> {
                });
            }

            @Test
            void __lastId() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                final var id = lastId;
                // ------------------------------------------------------------------------------------------------ when
                final var result = singleInvoker.apply(instance).apply(id);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).hasValueSatisfying(v -> {
                });
            }

            @Test
            void __BeyondLastId() {
                // ----------------------------------------------------------------------------------------------- given
                final var instance = newClientInstance();
                final var id = lastId + 1;
                // ------------------------------------------------------------------------------------------------ when
                final var result = singleInvoker.apply(instance).apply(id);
                // ------------------------------------------------------------------------------------------------ then
                assertThat(result).isEmpty();
            }
        }

        private final Function<? super CLIENT, ? extends IntFunction<? extends Optional<PAGE>>> pageInvoker;

        private final Function<? super CLIENT, ? extends List<RESULT>> allInvoker;

        private final Function<
                ? super CLIENT,
                ? extends Function<
                        ? super int[],
                        ? extends List<RESULT>
                        >
                >
                multipleInvoker;

        private final Function<? super CLIENT, ? extends IntFunction<? extends Optional<RESULT>>> singleInvoker;

        private final int lastPage;

        private final int lastId;
    }

    @DisplayName("/character")
    @Nested
    class Characters_IT
            extends _IT<CharacterPage, CharacterType> {

        Characters_IT() {
            super(
                    i -> p -> {
                        try {
                            return i.getAllCharacters(p);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> {
                        return i.getAllCharacters();
                    },
                    i -> ids -> {
                        try {
                            return i.getCharacters(ids);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> id -> {
                        try {
                            return i.getCharacter(id);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    RickAndMortyApiClientTestConstants.CHARACTERS_PAGE_COUNT,
                    RickAndMortyApiClientTestConstants.NUMBER_OF_ALL_CHARACTERS
            );
        }

        @DisplayName("?page=")
        @Nested
        class GetAllWithPage_IT
                extends _GetAllWithPage_IT {

        }

        @DisplayName("getAll...()")
        @Nested
        class GetAll_IT
                extends _GetAll_IT {

            @Test
            @Override
            void __() {
                super.__();
            }

            @Override
            void __(final List<CharacterType> result) {
                if (false) {
                    final var statuses = result.stream().map(CharacterType::getStatus).distinct().sorted().toList();
                    log.debug("character statuses: {}", statuses);
                    final var nullCount =
                            result.stream().map(CharacterType::getStatus).distinct().filter(Objects::isNull).count();
                    log.debug("character statuses / null count: {}", nullCount);
                }
                if (false) {
                    final var species = result.stream().map(CharacterType::getSpecies).distinct().sorted().toList();
                    log.debug("species: {}", species);
                    final var nullCount =
                            result.stream().map(CharacterType::getSpecies).distinct().filter(Objects::isNull).count();
                    log.debug("species / null count: {}", nullCount);
                }
                if (false) {
                    result.stream().filter(v -> v.getType() != null && v.getType().strip().isBlank()).forEach(v -> {
                        log.debug("character with blank type: {}", v.getId());
                    });
                    final var types = result.stream().map(CharacterType::getType).distinct().sorted().toList();
                    log.debug("character types: {}", types);
                    final var nullCount =
                            result.stream().map(CharacterType::getType).distinct().filter(Objects::isNull).count();
                    log.debug("types / null count: {}", nullCount);
                }
                if (false) {
                    final var genders = result.stream().map(CharacterType::getGender).distinct().sorted().toList();
                    log.debug("genders: {}", genders);
                    final var nullCount =
                            result.stream().map(CharacterType::getGender).distinct().filter(Objects::isNull).count();
                    log.debug("genders / null count: {}", nullCount);
                }
            }
        }

        @DisplayName("/1,2,3")
        @Nested
        class GetWithIds_IT
                extends _GetWithIds_IT {

        }

        @DisplayName("/1")
        @Nested
        class GetWithId_IT
                extends _GetWithId_IT {

        }
    }

    @Disabled
    @Nested
    class Episodes_IT
            extends _IT<EpisodePage, EpisodeType> {

        Episodes_IT() {
            super(
                    i -> p -> {
                        try {
                            return i.getAllEpisodes(p);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> {
                        return i.getAllEpisodes();
                    },
                    i -> ids -> {
                        try {
                            return i.getEpisodes(ids);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> id -> {
                        try {
                            return i.getEpisode(id);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    RickAndMortyApiClientTestConstants.EPISODES_PAGE_COUNT,
                    RickAndMortyApiClientTestConstants.NUMBER_OF_ALL_EPISODES
            );
        }

        @DisplayName("?page=")
        @Nested
        class GetAllWithPage_IT
                extends _GetAllWithPage_IT {

        }

        @DisplayName("getAll...()")
        @Nested
        class GetAll_IT
                extends _GetAll_IT {

            @Test
            @Override
            void __() {
                super.__();
            }

            @Override
            void __(final List<EpisodeType> result) {
            }
        }

        @DisplayName("/1,2,3")
        @Nested
        class GetWithIds_IT
                extends _GetWithIds_IT {

        }

        @DisplayName("/1")
        @Nested
        class GetWithId_IT
                extends _GetWithId_IT {

        }
    }

    @Disabled
    @Nested
    class Locations_IT
            extends _IT<LocationPage, LocationType> {

        Locations_IT() {
            super(
                    i -> p -> {
                        try {
                            return i.getAllLocations(p);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> {
                        return i.getAllLocations();
                    },
                    i -> ids -> {
                        try {
                            return i.getLocations(ids);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    i -> id -> {
                        try {
                            return i.getLocation(id);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    },
                    RickAndMortyApiClientTestConstants.LOCATIONS_PAGE_COUNT,
                    RickAndMortyApiClientTestConstants.NUMBER_OF_ALL_LOCATIONS
            );
        }

        @DisplayName("?page=")
        @Nested
        class GetAllWithPage_IT
                extends _GetAllWithPage_IT {

        }

        @DisplayName("getAll...()")
        @Nested
        class GetAll_IT
                extends _GetAll_IT {

            @Test
            @Override
            void __() {
                super.__();
            }

            @Override
            void __(final List<LocationType> result) {
                if (true) {
                    assertThat(result).map(LocationType::getType).doesNotContainNull();
                    final var types = result.stream().map(LocationType::getType).distinct().sorted().toList();
                    log.debug("location types: {}", types);
                }
            }
        }

        @DisplayName("/1,2,3")
        @Nested
        class GetWithIds_IT
                extends _GetWithIds_IT {

        }

        @DisplayName("/1")
        @Nested
        class GetWithId_IT
                extends _GetWithId_IT {

        }
    }

    // ----------------------------------------------------------------------------------------------------- clientClass
    protected CLIENT newClientInstance() {
        try {
            final var constructor = clientClass.getDeclaredConstructor();
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException("failed to instantiate" + clientClass, roe);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<CLIENT> clientClass;
}
