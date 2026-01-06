package io.github.jinahya.rickandmortyapi.client.type;

import java.util.Objects;

@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention
})
abstract class BasePageTypeTest<T extends BasePageType<RESULT>, RESULT extends BaseSingularType>
        extends _BaseResponseTest<T> {

    // -----------------------------------------------------------------------------------------------------------------
    BasePageTypeTest(final Class<T> typeClass, final Class<RESULT> resultClass) {
        super(typeClass);
        this.resultClass = Objects.requireNonNull(resultClass, "resultClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<RESULT> resultClass;
}
