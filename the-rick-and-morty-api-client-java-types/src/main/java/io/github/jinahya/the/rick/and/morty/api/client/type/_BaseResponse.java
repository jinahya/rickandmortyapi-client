package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.annotation.Nullable;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.net.URI;
import java.util.List;

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
public class _BaseResponse<RESULT> extends __BaseType {

    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    @Setter(AccessLevel.PROTECTED)
    @Getter
    @EqualsAndHashCode(callSuper = true)
    @ToString
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    protected static class Info extends __BaseType {

        // -------------------------------------------------------------------------------------------------------------
        @PositiveOrZero
        private int count;

        @PositiveOrZero
        private int pages;

        @Nullable
        private URI next;

        @Nullable
        private URI prev;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    private Info info;

    private List<@Valid @NotNull RESULT> results;
}
