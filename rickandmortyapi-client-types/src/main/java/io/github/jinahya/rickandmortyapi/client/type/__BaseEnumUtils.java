package io.github.jinahya.rickandmortyapi.client.type;

import java.util.Objects;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class __BaseEnumUtils {

    static <E extends Enum<E> & __BaseEnum<E>> E valueOfValue(final Class<E> enumType, final String value) {
        for (final var enumConstant : enumType.getEnumConstants()) {
            if (Objects.equals(enumConstant.value(), value)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("no value for " + value + " in " + enumType);
    }

    private __BaseEnumUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
