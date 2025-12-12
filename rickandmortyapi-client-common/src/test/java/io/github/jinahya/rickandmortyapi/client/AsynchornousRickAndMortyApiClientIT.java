package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
public abstract class AsynchornousRickAndMortyApiClientIT<CLIENT extends AsynchronousRickAndMortyApiClient> {

    private final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    protected AsynchornousRickAndMortyApiClientIT(final Class<CLIENT> clientClass) {
        super();
        this.clientClass = Objects.requireNonNull(clientClass, "clientClass is null");
    }

    // ------------------------------------------------------------------------------------------------------ characters
    @DisplayName("getAllCharacters(page)")
    @Nested
    class GetAllCharactersWithPage_IT {

        @ValueSource(ints = {1, 42})
        @ParameterizedTest
        void __(final int page) {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getAllCharacters(page, EXECUTOR);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result)
                    .succeedsWithin(Duration.ofSeconds(20L))
                    .satisfies(v -> {
                        assertThat(v).isNotNull();
                    })
            ;
        }

        @Test
        void _Empty_BeyondLastPage() {
            final var page = RickAndMortyApiClientTestConstants.CHARACTERS_PAGE_COUNT + 1;
            final var instance = newClientInstance();
            final var result = instance.getAllCharacters(page, EXECUTOR);
            assertThat(result)
                    .succeedsWithin(Duration.ofSeconds(20L))
                    .satisfies(v -> {
                        assertThat(v).isNull();
                    })
            ;
        }
    }

    @DisplayName("getAllCharacters()")
    @Nested
    class GetAllCharacters_IT {

        @Test
        void __() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getAllCharacters(EXECUTOR);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result)
                    .succeedsWithin(Duration.ofMinutes(2L))
                    .satisfies(v -> {
                        assertThat(v)
                                .hasSize(RickAndMortyApiClientTestConstants.NUMBER_OF_ALL_CHARACTERS)
                                .isSortedAccordingTo(Comparator.comparingInt(CharacterType::getId));
                    })
            ;
        }
    }

    @DisplayName("getCharacters(ids)")
    @Nested
    class GetCharactersWithIds_IT {

        @DisplayName("(null)NullPointerException")
        @Test
        void _NullPointerException_IdsNull() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            final int[] ids = null;
            // --------------------------------------------------------------------------------------------- when / then
            assertThatThrownBy(() -> {
                instance.getCharacters(ids, EXECUTOR);
            }).isInstanceOf(NullPointerException.class);
        }

        @DisplayName("({empty})IllegalArgumentException")
        @Test
        void _IllegalArgumentException_IdsEmpty() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            final int[] ids = new int[0];
            // --------------------------------------------------------------------------------------------- when / then
            assertThatThrownBy(() -> {
                instance.getCharacters(ids, EXECUTOR);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void __() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            final var ids = new int[]{1, 2, 3};
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getCharacters(ids, EXECUTOR);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result)
                    .succeedsWithin(Duration.ofSeconds(20L))
                    .satisfies(v -> {
                        assertThat(v).hasSize(3)
                                .isSortedAccordingTo(Comparator.comparingInt(CharacterType::getId))
                                .satisfies(l -> {
                                    assertThat(l.getFirst().getId()).isEqualTo(ids[0]);
                                    assertThat(l.getLast().getId()).isEqualTo(ids[ids.length - 1]);
                                });
                    })
            ;
        }
    }

    @DisplayName("getCharacter(id)")
    @Nested
    class GetCharacterWithId_IT {

        @DisplayName("({zero})IllegalArgumentException")
        @Test
        void _IllegalArgumentException_Zero() {
            final var id = 0;
            final var instance = newClientInstance();
            assertThatThrownBy(() -> {
                instance.getCharacter(id, EXECUTOR);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("({negative})IllegalArgumentException")
        @Test
        void _IllegalArgumentException_Negative() {
            final var id = ThreadLocalRandom.current().nextInt() | Integer.MIN_VALUE;
            final var instance = newClientInstance();
            assertThatThrownBy(() -> {
                instance.getCharacter(id, EXECUTOR);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("({beyond-last-id}){empty}")
        @Test
        void _Empty_BeyondLastId() {
            // --------------------------------------------------------------------------------------------------- given
            final var id = 1048576;
            final var instance = newClientInstance();
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getCharacter(id, EXECUTOR);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result).succeedsWithin(Duration.ofSeconds(20L)).satisfies(v -> {
                assertThat(v).isNull();
            });
        }

        @DisplayName("({one}){present}")
        @Test
        void __One() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            final var id = 1;
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getCharacter(id, EXECUTOR);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result)
                    .succeedsWithin(Duration.ofSeconds(20L))
                    .satisfies(v -> {
                        assertThat(v).isNotNull();
                    });
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
