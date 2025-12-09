package io.github.jinahya.the.rick.and.morty.api.client.type;

import java.util.Objects;

abstract class _BaseResponseTest<T extends _BaseResponse<RESULT>, RESULT extends __BaseType> extends __BaseTypeTest<T> {

    _BaseResponseTest(final Class<T> typeClass, final Class<RESULT> resultClass) {
        super(typeClass);
        this.resultClass = Objects.requireNonNull(resultClass, "resultClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<RESULT> resultClass;
}
