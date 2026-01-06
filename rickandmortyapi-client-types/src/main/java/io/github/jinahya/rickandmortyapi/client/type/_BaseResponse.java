package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;

import java.io.Serial;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
abstract class _BaseResponse
        extends __BaseType {

    @Serial
    private static final long serialVersionUID = -3379963756912802054L;

    // -----------------------------------------------------------------------------------------------------------------
    _BaseResponse() {
        super();
    }
}
