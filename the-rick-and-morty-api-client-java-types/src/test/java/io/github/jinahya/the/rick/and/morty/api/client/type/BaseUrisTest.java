package io.github.jinahya.the.rick.and.morty.api.client.type;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class BaseUrisTest {

    private static <R> R applyResource(final Function<? super InputStream, ? extends R> mapper) throws IOException {
        Objects.requireNonNull(mapper, "mapper is null");
        try (var stream = BaseUrisTest.class.getResourceAsStream("api.json")) {
            assertThat(stream).isNotNull();
            return mapper.apply(stream);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void __Jackson() throws IOException {
        final var value = applyResource(r -> {
            return _JacksonTestUtils.applyObjectMapper(om -> {
                try {
                    return om.readValue(r, BaseUris.class);
                } catch (final IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            });
        });
        log.debug("value: {}", value);
    }

    @Test
    void __Jsonb() throws IOException {
        final var value = applyResource(r -> {
            try {
                return _JsonbTestUtils.applyJsonb(j -> {
                    return j.fromJson(r, BaseUris.class);
                });
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        });
        log.debug("value: {}", value);
    }
}
