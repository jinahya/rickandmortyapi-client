package io.github.jinahya.the.rick.and.morty.api.client.type;

import java.util.Objects;

abstract class BasePageResponseTest<T extends BasePageResponse<RESULT>, RESULT extends __BaseType>
        extends _BaseResponseTest<T> {

    BasePageResponseTest(final Class<T> typeClass, final Class<RESULT> resultClass) {
        super(typeClass);
        this.resultClass = Objects.requireNonNull(resultClass, "resultClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<RESULT> resultClass;
}
