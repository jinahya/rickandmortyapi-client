package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CharacterTypeTest
        extends BaseSingularTypeTest<CharacterType> {

    CharacterTypeTest() {
        super(CharacterType.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("_1.json")
    @Nested
    class _1_Test {

        @Test
        void __Jackson()
                throws IOException {
            final var value =
                    _JacksonTestUtils.readValueFromResource(getClass(), "character_1.json", CharacterType.class);
            _ValidationTestUtils.assertValid(value);
        }

        @Test
        void __Jsonb()
                throws Exception {
            final var value =
                    _JsonbTestUtils.readValueFromResource(getClass(), "character_1.json", CharacterType.class);
            _ValidationTestUtils.assertValid(value);
        }
    }

    @DisplayName("_123.json")
    @Nested
    class _123_Test {

        @Test
        void __Jackson()
                throws IOException {
            final var value =
                    _JacksonTestUtils.readValueFromResource(
                            getClass(),
                            "character_123.json",
                            new TypeReference<List<CharacterType>>() {
                            }
                    );
            _ValidationTestUtils.assertValid(value);
        }

        @Test
        void __Jsonb()
                throws Exception {
            final var type = new ArrayList<CharacterType>() {
            }.getClass().getGenericSuperclass();
            final var value = _JsonbTestUtils.readValueFromResource(getClass(), "character_123.json", type);
            _ValidationTestUtils.assertValid(value);
        }
    }
}
