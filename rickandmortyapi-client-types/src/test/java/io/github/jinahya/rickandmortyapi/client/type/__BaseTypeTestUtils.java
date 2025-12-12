package io.github.jinahya.rickandmortyapi.client.type;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

final class __BaseTypeTestUtils<T extends __BaseType> {

    static <R> R applyResourceStream(Class<?> clazz, final String name,
                                     final Function<? super InputStream, ? extends R> mapper)
            throws IOException {
        if (clazz == null) {
            clazz = __BaseTypeTestUtils.class;
        }
        Objects.requireNonNull(clazz, "clazz is null");
        Objects.requireNonNull(name, "name is null");
        Objects.requireNonNull(mapper, "mapper is null");
        try (var stream = clazz.getResourceAsStream(name)) {
            assertThat(stream)
                    .as("resource for /%s/%s", clazz.getPackageName().replace('.', '/'), name)
                    .isNotNull();
            return mapper.apply(stream);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private __BaseTypeTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
