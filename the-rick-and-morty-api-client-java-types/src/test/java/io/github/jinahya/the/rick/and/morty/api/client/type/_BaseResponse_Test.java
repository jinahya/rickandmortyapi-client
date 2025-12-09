package io.github.jinahya.the.rick.and.morty.api.client.type;

import java.util.Objects;

class _BaseResponse_Test<T extends _BaseResponse<RESULT>, RESULT extends __BaseType> extends __BaseType_Test<T> {

    _BaseResponse_Test(final Class<T> typeClass, final Class<RESULT> resultClass) {
        super(typeClass);
        this.resultClass = Objects.requireNonNull(resultClass, "resultClass is null");
    }

    final Class<RESULT> resultClass;
}
