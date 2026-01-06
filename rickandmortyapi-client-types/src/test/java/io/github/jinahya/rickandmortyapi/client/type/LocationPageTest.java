package io.github.jinahya.rickandmortyapi.client.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@Slf4j
class LocationPageTest
        extends BasePageTypeTest<LocationPage, LocationType> {

    LocationPageTest() {
        super(LocationPage.class, LocationType.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static Stream<String> resources() {
        return Stream.of("location_page_1.json");
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jackson(final String name)
            throws IOException {
        final var value = _JacksonTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jsonb(final String name)
            throws Exception {
        final var value = _JsonbTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
    }
}
