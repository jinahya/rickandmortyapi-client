package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LocationPage extends BasePageType<LocationType> {

    @Serial
    private static final long serialVersionUID = 5348232151591119753L;

    protected LocationPage() {
        super();
    }
}
