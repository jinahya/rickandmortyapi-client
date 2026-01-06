package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.io.Serial;
import java.net.URL;
import java.time.Instant;
import java.util.Comparator;
import java.util.Objects;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
public abstract class BaseSingularType
        extends __BaseType {

    @Serial
    private static final long serialVersionUID = -6172731908696246757L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_NAME_ID = "id";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_NAME_NAME = "name";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_NAME_URL = "url";

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_NAME_CREATED = "created";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A comparator compares {@link BaseSingularType#getId()} values.
     */
    public static final Comparator<BaseSingularType> COMPARING_ID = Comparator.comparingInt(BaseSingularType::getId);

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    protected BaseSingularType() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               ",name=" + name +
               ",url=" + url +
               ",created=" + created +
               '}';
    }

    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof BaseSingularType that)) {
            return false;
        }
        return id == null || Objects.equals(id, that.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(id);
    }

    // -------------------------------------------------------------------------------------------------------------- id
    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    // ------------------------------------------------------------------------------------------------------------ name
    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    // ------------------------------------------------------------------------------------------------------------- url
    public URL getUrl() {
        return url;
    }

    void setUrl(final URL url) {
        this.url = url;
    }

    // --------------------------------------------------------------------------------------------------------- created
    public Instant getCreated() {
        return created;
    }

    void setCreated(final Instant created) {
        this.created = created;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Positive
    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private URL url;

    @Past
    @NotNull
    private Instant created;
}
