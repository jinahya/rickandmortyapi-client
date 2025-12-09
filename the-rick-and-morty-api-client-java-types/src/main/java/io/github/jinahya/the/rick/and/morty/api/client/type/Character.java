package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
public class Character extends __BaseType {

    protected Character() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private int id;
}
