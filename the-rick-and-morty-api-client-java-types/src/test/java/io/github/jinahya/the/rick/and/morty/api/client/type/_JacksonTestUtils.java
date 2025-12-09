package io.github.jinahya.the.rick.and.morty.api.client.type;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;

final class _JacksonTestUtils {

    static <R> R applyObjectMapper(final Function<? super ObjectMapper, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return mapper.apply(new ObjectMapper().findAndRegisterModules());
    }

    static <T> T readValueFromResource(final Class<?> clazz, final String name, final Class<T> type)
            throws IOException {
        Objects.requireNonNull(type, "type is null");
        return __BaseTypeTestUtils.applyResourceStream(
                clazz,
                name,
                s -> applyObjectMapper(om -> {
                    try {
                        return om.readValue(s, type);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                })
        );
    }


    // -----------------------------------------------------------------------------------------------------------------
    private _JacksonTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
