package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
abstract class _BaseRequest
        extends __BaseType {

    @Serial
    private static final long serialVersionUID = -6420180898111430473L;

    // -----------------------------------------------------------------------------------------------------------------
    _BaseRequest() {
        super();
    }
}
