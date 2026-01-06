package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

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
    public List<URL> getCharacters() {
        return characters;
    }

    void setCharacters(final List<URL> characters) {
        this.characters = characters;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Past
    @NotNull
    @JsonProperty(JSON_NAME_AIR_DATE)
//    @JsonDeserialize(using = EpisodeType_AirDateDeserializer.class)
//    @JsonFormat(pattern = "MMMM d, yyyy")
    @JsonFormat(pattern = EpisodeType_Constants.AIR_DATE_PATTERN, locale = "en")
    @JsonbProperty(JSON_NAME_AIR_DATE)
//    @JsonbTypeAdapter(EpisodeType_AirDateAdapter.class)
    @JsonbDateFormat(value = EpisodeType_Constants.AIR_DATE_PATTERN, locale = "en")
    private LocalDate airDate;

    @NotBlank
    private String episode;

    private List<@NotNull URL> characters;
}
