package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EpisodeType extends __BaseType {

    public static final String JSON_NAME_AIR_DATE = "air_date";

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private Integer id;

    private String name;

    @JsonProperty(JSON_NAME_AIR_DATE)
    @JsonbProperty(JSON_NAME_AIR_DATE)
    private String airDate;

    private String episode;

    private List<@NotBlank String> characters;

    private String url;

    @Past
    private Instant created;
}
