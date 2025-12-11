package io.github.jinahya.rickandmortyapi.client.type;

abstract class BaseSingularTypeTest<TYPE extends BaseSingularType> extends __BaseTypeTest<TYPE> {

    BaseSingularTypeTest(final Class<TYPE> typeClass) {
        super(typeClass);
    }
}
