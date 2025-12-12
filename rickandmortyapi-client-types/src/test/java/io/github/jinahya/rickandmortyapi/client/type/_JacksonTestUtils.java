package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;

final class _JacksonTestUtils {

    static <R> R applyObjectMapper(final Function<? super ObjectMapper, ? extends R> mapper) {
        Objects.requireNonNull(mapper, "mapper is null");
        return mapper.apply(new ObjectMapper().findAndRegisterModules());
    }

    static <T> T readValueFromResource(final Class<?> clazz, final String name, final Class<T> valueType)
            throws IOException {
        Objects.requireNonNull(valueType, "valueType is null");
        return __BaseTypeTestUtils.applyResourceStream(
                clazz,
                name,
                s -> applyObjectMapper(om -> {
                    try {
                        return om.readValue(s, valueType);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                })
        );
    }

    static <T> T readValueFromResource(final Class<?> clazz, final String name, final TypeReference<T> typeReference)
            throws IOException {
        Objects.requireNonNull(typeReference, "typeReference is null");
        return __BaseTypeTestUtils.applyResourceStream(
                clazz,
                name,
                s -> applyObjectMapper(om -> {
                    try {
                        return om.readValue(s, typeReference);
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
