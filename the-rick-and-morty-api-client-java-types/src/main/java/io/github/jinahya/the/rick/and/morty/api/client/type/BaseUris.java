package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;

import java.net.URI;
import java.util.Objects;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
public class BaseUris extends __BaseType {

    public static final String REQUEST_URI = "https://rickandmortyapi.com/api";

    // -----------------------------------------------------------------------------------------------------------------
    private static final String PROPERTY_CHARACTERS = "characters";

    private static final String PROPERTY_LOCATIONS = "locations";

    private static final String PROPERTY_EPISODES = "episodes";

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Creates a new instance.
     */
    protected BaseUris() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "characters=" + characters +
                ",locations=" + locations +
                ",episodes=" + episodes +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof BaseUris baseUris)) {
            return false;
        }
        return Objects.equals(characters, baseUris.characters)
                && Objects.equals(locations, baseUris.locations)
                && Objects.equals(episodes, baseUris.episodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters, locations, episodes);
    }

    // ------------------------------------------------------------------------------------------------------ characters
    public URI getCharacters() {
        return characters;
    }

    void setCharacters(final URI characters) {
        this.characters = characters;
    }

    // ------------------------------------------------------------------------------------------------------- locations
    public URI getLocations() {
        return locations;
    }

    void setLocations(final URI locations) {
        this.locations = locations;
    }

    // -------------------------------------------------------------------------------------------------------- episodes
    public URI getEpisodes() {
        return episodes;
    }

    void setEpisodes(final URI episodes) {
        this.episodes = episodes;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URI characters;

    private URI locations;

    private URI episodes;
}
