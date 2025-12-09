package io.github.jinahya.the.rick.and.morty.api.client.type;

import java.util.Objects;

abstract class __BaseType_Test<T extends __BaseType> {

    __BaseType_Test(final Class<T> typeClass) {
        super();
        this.typeClass = Objects.requireNonNull(typeClass, "typeClass is null");
    }

    final Class<T> typeClass;
}
