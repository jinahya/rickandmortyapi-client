package io.github.jinahya.rickandmortyapi.client.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class CharacterPageTest extends BasePageTypeTest<CharacterPage, CharacterType> {

    CharacterPageTest() {
        super(CharacterPage.class, CharacterType.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Disabled
    @DisplayName("character_.json")
    @Nested
    class _Test {

        @Test
        void __Jackson() {
            assertThatThrownBy(() -> {
                _JacksonTestUtils.readValueFromResource(getClass(), "character_.json", typeClass);
            }).isInstanceOf(RuntimeException.class);
        }

        @Test
        void __Jsonb() throws Exception {
            final var value = _JsonbTestUtils.readValueFromResource(getClass(), "character_.json", typeClass);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static Stream<String> resources() {
        return Stream.of("character_page_1.json");
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jackson(final String name) throws IOException {
        final var value = _JacksonTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
        assertThat(value).isNotNull();
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jsonb(final String name) throws Exception {
        final var value = _JsonbTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
        assertThat(value).isNotNull();
    }
}
