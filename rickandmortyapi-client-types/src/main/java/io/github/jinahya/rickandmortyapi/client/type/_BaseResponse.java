package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.annotation.JsonbVisibility;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
public class _BaseResponse extends __BaseType {

}
