package io.github.jinahya.rickandmortyapi.client.type;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
abstract class __BaseType
        implements Serializable {

    @Serial
    private static final long serialVersionUID = 7705231465211672955L;
}
