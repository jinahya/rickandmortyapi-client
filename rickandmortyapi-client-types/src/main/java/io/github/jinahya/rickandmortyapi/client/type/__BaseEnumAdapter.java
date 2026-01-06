package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.adapter.JsonbAdapter;

import java.util.Objects;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
abstract class __BaseEnumAdapter<E extends Enum<E> & __BaseEnum<E>>
        implements JsonbAdapter<E, String> {

    __BaseEnumAdapter(final Class<E> enumClass) {
        super();
        this.enumClass = Objects.requireNonNull(enumClass, "enumClass is null");
    }

    @Override
    public String adaptToJson(final E obj)
            throws Exception {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public E adaptFromJson(final String obj)
            throws Exception {
        return null;
    }

    final Class<E> enumClass;
}
