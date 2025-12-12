package io.github.jinahya.rickandmortyapi.client.type;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
interface __BaseEnum<E extends Enum<E> & __BaseEnum<E>> {

    String value();
}
