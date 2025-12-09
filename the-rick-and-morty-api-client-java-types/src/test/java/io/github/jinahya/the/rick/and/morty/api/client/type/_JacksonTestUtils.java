package io.github.jinahya.the.rick.and.morty.api.client.type;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;
import java.util.function.Function;

final class _JacksonTestUtils {

    static <R> R applyObjectMapper(final Function<? super ObjectMapper, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return mapper.apply(new ObjectMapper());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _JacksonTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
