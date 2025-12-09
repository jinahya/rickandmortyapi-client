package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.util.Objects;
import java.util.function.Function;

final class _JsonbTestUtils {

    static <R> R applyJsonb(final Function<? super Jsonb, ? extends R> mapper) throws Exception {
        Objects.requireNonNull(mapper, "mapper is null");
        try (var jsonb = JsonbBuilder.newBuilder().build()) {
            return mapper.apply(jsonb);
        }
    }

    static <T> T readValueFromResource(final Class<?> clazz, final String name, final Class<T> type) throws Exception {
        Objects.requireNonNull(type, "type is null");
        return __BaseTypeTestUtils.applyResourceStream(
                clazz,
                name,
                s -> {
                    try {
                        return applyJsonb(j -> j.fromJson(s, type));
                    } catch (final Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _JsonbTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
