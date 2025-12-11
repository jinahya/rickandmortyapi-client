package io.github.jinahya.rickandmortyapi.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public abstract class RickAndMortyApiClientIT<T extends RickAndMortyApiClient> {

    protected RickAndMortyApiClientIT(final Class<T> clientClass) {
        super();
        this.clientClass = Objects.requireNonNull(clientClass, "clientClass is null");
    }

    // ------------------------------------------------------------------------------------------------------ characters
    @DisplayName("getAllCharacters(page)")
    @Nested
    class GetAllCharactersWithPage_IT {

        @ValueSource(ints = {1, 42})
        @ParameterizedTest
        void __(final int page) throws IOException {
            final var instance = newClientInstance();
            final var result = instance.getAllCharacters(page).orElseThrow();
            log.debug("page: {}, first: {}", page, result.getResults().getFirst());
            log.debug("page: {}, last: {}", page, result.getResults().getLast());
        }

        @Test
        void __() throws IOException {
            final var instance = newClientInstance();
            final var result = instance.getAllCharacters(43);
            assertThat(result).isEmpty();
        }
    }

    @DisplayName("getAllCharacters()")
    @Nested
    class GetAllCharacters_IT {

        @Test
        void __() {
            final var instance = newClientInstance();
            final var result = instance.getAllCharacters();
            if (!result.isEmpty()) {
                log.debug("first: {}", result.getFirst());
                log.debug("last: {}", result.getLast());
            }
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
                instance.getCharacters(ids);
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
                instance.getCharacters(ids);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void __() throws IOException {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newClientInstance();
            final var ids = new int[]{1, 2, 3};
            // ---------------------------------------------------------------------------------------------------- when
            final var result = instance.getCharacters(ids);
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(result).hasSize(3).satisfies(l -> {
                assertThat(l.getFirst().getId()).isEqualTo(ids[0]);
                assertThat(l.getLast().getId()).isEqualTo(ids[ids.length - 1]);
            });
        }
    }

    @DisplayName("getCharacter(id)")
    @Nested
    class GetCharacterWithId_IT {

        @DisplayName("({non-positive})IllegalArgumentException")
        @Test
        void _IllegalArgumentException_NonPositive() {
            final var instance = newClientInstance();
            assertThatThrownBy(() -> {
                instance.getCharacter(0);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("(1048576){empty}")
        @Test
        void __1048576() throws IOException {
            final var instance = newClientInstance();
            final var result = instance.getCharacter(1048576);
            assertThat(result).isEmpty();
        }

        @DisplayName("(1){present}")
        @Test
        void __1() throws IOException {
            final var instance = newClientInstance();
            final var result = instance.getCharacter(1);
            assertThat(result).isPresent();
        }
    }

    // ----------------------------------------------------------------------------------------------------- clientClass
    protected T newClientInstance() {
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
    protected final Class<T> clientClass;
}
