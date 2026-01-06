package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
public class EpisodeType
        extends BaseSingularType {

    @Serial
    private static final long serialVersionUID = -1595871375041895792L;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_NAME_AIR_DATE = "air_date";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected EpisodeType() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
               "airDate=" + airDate +
               ",episode=" + episode +
               ",characters=" + characters +
               '}';
    }

    // --------------------------------------------------------------------------------------------------------- airDate
    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(final LocalDate airDate) {
        this.airDate = airDate;
    }

    // --------------------------------------------------------------------------------------------------------- episode
    public String getEpisode() {
        return episode;
    }

    void setEpisode(final String episode) {
        this.episode = episode;
    }

    // ------------------------------------------------------------------------------------------------------ characters
    public List<String> getCharacters() {
        return characters;
    }

    void setCharacters(final List<String> characters) {
        this.characters = characters;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @JsonProperty(JSON_NAME_AIR_DATE)
    @JsonDeserialize(using = __BaseTypeConstants.OfJackson.LocalDateDeserializer.class)
    @JsonbProperty(JSON_NAME_AIR_DATE)
    @JsonbTypeAdapter(__BaseTypeConstants.OfJsonb.LocalDateAdapter.class)
    private LocalDate airDate;

    private String episode;

    private List<@NotBlank String> characters;
}
