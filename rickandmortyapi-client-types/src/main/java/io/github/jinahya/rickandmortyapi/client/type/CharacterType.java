package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;

import java.io.Serial;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
public class CharacterType
        extends BaseSingularType {

    @Serial
    private static final long serialVersionUID = -7867037207488854753L;

    // -------------------------------------------------------------------------------------------------------- $.status
    public static final String JSON_NAME_STATUS = "status";

    // ------------------------------------------------------------------------------------------------------- $.species
    public static final String JSON_NAME_SPECIES = "species";

    // ---------------------------------------------------------------------------------------------------------- $.type
    public static final String JSON_NAME_TYPE = "type";

    // -------------------------------------------------------------------------------------------------------- $.gender
    public static final String JSON_NAME_GENDER = "gender";

    // -----------------------------------------------------------------------------------------------------------------
    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    public static class NameAndUrl
            extends __BaseType {

        @Serial
        private static final long serialVersionUID = 7184812096300183319L;

        // -------------------------------------------------------------------------------------------------------------
        public static final String JSON_NAME_NAME = "name";

        public static final String JSON_NAME_URL = "url";

        // ------------------------------------------------------------------------------------------------ CONSTRUCTORS
        protected NameAndUrl() {
            super();
        }

        // -------------------------------------------------------------------------------------------- java.lang.Object
        @Override
        public String toString() {
            return super.toString() + '{' +
                   "name=" + name +
                   ",url=" + url +
                   '}';
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof NameAndUrl that)) {
                return false;
            }
            return Objects.equals(name, that.name)
                   && Objects.equals(url, that.url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, url);
        }

        // -------------------------------------------------------------------------------------------------------- name
        public String getName() {
            return name;
        }

        void setName(final String name) {
            this.name = name;
            if (this.name != null && this.name.strip().isBlank()) {
                setName(null);
            }
        }

        // --------------------------------------------------------------------------------------------------------- url
        public URL getUrl() {
            return url;
        }

        void setUrl(final URL url) {
            this.url = url;
        }

        // -------------------------------------------------------------------------------------------------------------
        @Nullable
        private String name;

        @Nullable
        private URL url;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected CharacterType() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
               "status=" + status +
               ",species=" + species +
               ",type=" + type +
               ",gender=" + gender +
               ",origin=" + origin +
               ",location=" + location +
               ",image=" + image +
               ",episode=" + episode +
               '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getStatus() {
        return status;
    }

    void setStatus(final String status) {
        this.status = status;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getSpecies() {
        return species;
    }

    void setSpecies(final String species) {
        this.species = species;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    public String getType() {
        return type;
    }

    void setType(@Nullable final String type) {
        this.type = type;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getGender() {
        return gender;
    }

    void setGender(final String gender) {
        this.gender = gender;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    public NameAndUrl getOrigin() {
        return origin;
    }

    void setOrigin(@Nullable final NameAndUrl origin) {
        this.origin = origin;
        if (this.origin != null
            && ((this.origin.name == null || this.origin.name.strip().isBlank())
                || this.origin.url == null)) {
            setOrigin(null);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nullable
    public NameAndUrl getLocation() {
        return location;
    }

    void setLocation(@Nullable final NameAndUrl location) {
        this.location = location;
        if (this.location != null
            && ((this.location.name == null || this.location.name.strip().isBlank())
                || this.location.url == null)) {
            setLocation(null);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getImage() {
        return image;
    }

    void setImage(final String image) {
        this.image = image;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public List<URL> getEpisode() {
        return episode;
    }

    void setEpisode(final List<URL> episode) {
        this.episode = episode;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String status;

    @NotBlank
    private String species;

    @Nullable
    private String type;

    @NotBlank
    private String gender;

    @Nullable
    private NameAndUrl origin;

    @Nullable
    private NameAndUrl location;

    @NotBlank
    private String image;

    private List<@NotNull URL> episode;
}
