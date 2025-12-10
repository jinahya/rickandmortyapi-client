package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
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
public class CharacterType extends __BaseType {

    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    @Setter(AccessLevel.PROTECTED)
    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString(callSuper = true)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class NameAndLink extends __BaseType {

        private String name;

        private String url;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private int id;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private NameAndLink origin;

    private NameAndLink location;

    private String image;

    private List<String> episode;

    private String url;

    private Instant created;
}
