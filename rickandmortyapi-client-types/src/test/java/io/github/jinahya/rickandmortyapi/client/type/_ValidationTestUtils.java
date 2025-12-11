package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

final class _ValidationTestUtils {

    static <T> Set<ConstraintViolation<T>> validate(final T object, final Class<?>... groups) {
        Objects.requireNonNull(object, "object is null");
        Objects.requireNonNull(groups, "groups is null");
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            return factory.getValidator().validate(object, groups);
        }
    }

    static void assertValid(final Object object, final Class<?>... groups) {
        assertThat(validate(object, groups))
                .as("constraint validations of %s, with %s", object, Arrays.toString(groups))
                .isEmpty();
    }

    static <T> T requireValid(final T object, final Class<?>... groups) {
        assertValid(object, groups);
        return object;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _ValidationTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
