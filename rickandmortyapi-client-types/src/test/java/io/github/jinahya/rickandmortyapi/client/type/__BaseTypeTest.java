package io.github.jinahya.rickandmortyapi.client.type;

import java.util.Objects;

abstract class __BaseTypeTest<T extends __BaseType> {


    // -----------------------------------------------------------------------------------------------------------------
    __BaseTypeTest(final Class<T> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<T> typeClass;
}
