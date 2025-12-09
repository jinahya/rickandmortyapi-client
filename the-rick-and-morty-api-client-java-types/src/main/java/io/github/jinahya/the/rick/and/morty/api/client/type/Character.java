package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character extends __BaseType {

    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    @Setter(AccessLevel.PROTECTED)
    @Getter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class NameAndUrl {

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

    private NameAndUrl origin;

    private NameAndUrl location;

    private String image;

    private List<String> episode;

    private String url;

    private String created;
}
