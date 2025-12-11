package io.github.jinahya.rickandmortyapi.client.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

@Slf4j
class EpisodePageResponseTest extends BasePageResponseTest<EpisodePage, EpisodeType> {

    EpisodePageResponseTest() {
        super(EpisodePage.class, EpisodeType.class);
    }

//    // -----------------------------------------------------------------------------------------------------------------
//    @DisplayName("episode_.json")
//    @Nested
//    class _Test {
//
//        @Test
//        void __Jackson() throws IOException {
//            try (var resource = EpisodeResponse.class.getResourceAsStream("episode_.json")) {
//                final var value = _JacksonTestUtils.applyObjectMapper(om -> {
//                    try {
//                        return om.readValue(resource, EpisodeResponse.class);
//                    } catch (final IOException ioe) {
//                        throw new RuntimeException(ioe);
//                    }
//                });
//                log.debug("value: {}", value);
//            }
//        }
//
//        @Test
//        void __Jsonb() throws IOException {
//            try (var resource = EpisodeResponse.class.getResourceAsStream("episode_.json")) {
//                final var value = _JsonbTestUtils.applyJsonb(j -> {
//                    return j.fromJson(resource, EpisodeResponse.class);
//                });
//                log.debug("value: {}", value);
//            } catch (final Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private static Stream<String> resources() {
        return Stream.of("episode_page_1.json");
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jackson(final String name) throws IOException {
        final var value = _JacksonTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
    }

    @MethodSource({"resources"})
    @ParameterizedTest
    void __Jsonb(final String name) throws Exception {
        final var value = _JsonbTestUtils.readValueFromResource(getClass(), name, typeClass);
        log.debug("name: {}, value: {}", name, value);
    }
}
