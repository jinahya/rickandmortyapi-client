package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.URI;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseUrlResponse extends __BaseType {

    public static final String REQUEST_URI = "https://rickandmortyapi.com/api";

    // -----------------------------------------------------------------------------------------------------------------
    private static final String PROPERTY_CHARACTERS = "characters";

    private static final String PROPERTY_LOCATIONS = "locations";

    private static final String PROPERTY_EPISODES = "episodes";

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    private URI characters;

    @NotNull
    private URI locations;

    @NotNull
    private URI episodes;
}
