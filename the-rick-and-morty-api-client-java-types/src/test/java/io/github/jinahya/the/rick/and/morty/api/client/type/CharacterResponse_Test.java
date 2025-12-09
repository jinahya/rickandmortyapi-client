package io.github.jinahya.the.rick.and.morty.api.client.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Slf4j
class CharacterResponse_Test extends _BaseResponse_Test<CharacterResponse, Character> {

    CharacterResponse_Test() {
        super(CharacterResponse.class, Character.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("character_.json")
    @Nested
    class _Test {

        @Test
        void __Jackson() throws IOException {
            try (var resource = CharacterResponse.class.getResourceAsStream("character_.json")) {
                final var value = _JacksonTestUtils.applyObjectMapper(om -> {
                    try {
                        return om.readValue(resource, CharacterResponse.class);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                });
                log.debug("value: {}", value);
            }
        }

        @Test
        void __Jsonb() throws IOException {
            try (var resource = CharacterResponse.class.getResourceAsStream("character_.json")) {
                final var value = _JsonbTestUtils.applyJsonb(j -> {
                    return j.fromJson(resource, CharacterResponse.class);
                });
                log.debug("value: {}", value);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void __Jackson() throws IOException {
        try (var resource = CharacterResponse.class.getResourceAsStream("character1.json")) {
            final var value = _JacksonTestUtils.applyObjectMapper(om -> {
                try {
                    return om.readValue(resource, CharacterResponse.class);
                } catch (final IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            });
            log.debug("value: {}", value);
        }
    }

    @Test
    void __Jsonb() throws IOException {
        try (var resource = CharacterResponse.class.getResourceAsStream("character1.json")) {
            final var value = _JsonbTestUtils.applyJsonb(j -> {
                return j.fromJson(resource, CharacterResponse.class);
            });
            log.debug("value: {}", value);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
