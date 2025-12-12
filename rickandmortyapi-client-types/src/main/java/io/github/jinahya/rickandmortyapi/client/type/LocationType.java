package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;

import java.io.Serial;
import java.util.List;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
public class LocationType extends BaseSingularType {

    @Serial
    private static final long serialVersionUID = 947900641364915242L;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected LocationType() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "type=" + type +
                ",dimension=" + dimension +
                ",residents=" + residents +
                '}';
    }

    // ------------------------------------------------------------------------------------------------------------ type
    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    // ------------------------------------------------------------------------------------------------------- dimension
    public String getDimension() {
        return dimension;
    }

    void setDimension(final String dimension) {
        this.dimension = dimension;
    }

    // ------------------------------------------------------------------------------------------------------- residents
    public List<String> getResidents() {
        return residents;
    }

    void setResidents(final List<String> residents) {
        this.residents = residents;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String type;

    private String dimension;

    private List<String> residents;
}
