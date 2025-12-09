package io.github.jinahya.the.rick.and.morty.api.client.type;

import lombok.extern.slf4j.Slf4j;
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
class CharacterResponseTest extends _BaseResponseTest<CharacterResponse, Character> {

    CharacterResponseTest() {
        super(CharacterResponse.class, Character.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("character_.json")
    @Nested
    class _Test {

        @Test
        void __Jackson() throws IOException {
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
        return Stream.of("character1.json");
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
