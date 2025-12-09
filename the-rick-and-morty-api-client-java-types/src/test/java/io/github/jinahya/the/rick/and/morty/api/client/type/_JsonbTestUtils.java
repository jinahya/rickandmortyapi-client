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

    // -----------------------------------------------------------------------------------------------------------------
    private _JsonbTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
