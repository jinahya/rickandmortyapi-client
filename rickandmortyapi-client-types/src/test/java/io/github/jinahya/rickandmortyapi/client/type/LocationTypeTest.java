package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LocationTypeTest extends BaseSingularTypeTest<LocationType> {

    LocationTypeTest() {
        super(LocationType.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("_1.json")
    @Nested
    class _1_Test {

        @Test
        void __Jackson() throws IOException {
            final var value =
                    _JacksonTestUtils.readValueFromResource(getClass(), "location_1.json", LocationType.class);
            _ValidationTestUtils.assertValid(value);
        }

        @Test
        void __Jsonb() throws Exception {
            final var value =
                    _JsonbTestUtils.readValueFromResource(getClass(), "location_1.json", LocationType.class);
            _ValidationTestUtils.assertValid(value);
        }
    }

    @DisplayName("_123.json")
    @Nested
    class _123_Test {

        @Test
        void __Jackson() throws IOException {
            final var typeReference = new TypeReference<List<LocationType>>() {
            };
            final var value =
                    _JacksonTestUtils.readValueFromResource(
                            getClass(),
                            "location_123.json",
                            typeReference
                    );
            _ValidationTestUtils.assertValid(value);
        }

        @Test
        void __Jsonb() throws Exception {
            final var type = new ArrayList<LocationType>() {
            }.getClass().getGenericSuperclass();
            final var value = _JsonbTestUtils.readValueFromResource(
                    getClass(),
                    "location_123.json",
                    type
            );
            _ValidationTestUtils.assertValid(value);
        }
    }
}
