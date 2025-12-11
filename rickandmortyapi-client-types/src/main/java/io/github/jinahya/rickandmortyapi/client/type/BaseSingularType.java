package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public abstract class BaseSingularType extends __BaseType {

    @Serial
    private static final long serialVersionUID = -6172731908696246757L;

    // -----------------------------------------------------------------------------------------------------------------
    protected BaseSingularType() {
        super();
    }

    // -------------------------------------------------------------------------------------------------------------- id
    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Positive
    @NotNull
    private int id;
}
