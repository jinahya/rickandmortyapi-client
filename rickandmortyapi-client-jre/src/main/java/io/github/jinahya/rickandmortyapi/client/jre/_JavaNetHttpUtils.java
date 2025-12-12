package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class _JavaNetHttpUtils {

    static <T, U> HttpResponse.BodyHandler<U> newJsonBodyHandler(final HttpResponse.BodySubscriber<T> upstream,
                                                                 final Function<? super T, ? extends U> deserializer) {
        Objects.requireNonNull(upstream, "upstream is null");
        Objects.requireNonNull(deserializer, "deserializer is null");
        return ri -> {
            final var statusCode = ri.statusCode();
            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                return HttpResponse.BodySubscribers.mapping(
                        HttpResponse.BodySubscribers.discarding(),
                        b -> null
                );
            }
            if (statusCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("unexpected response code: " + statusCode);
            }
            return HttpResponse.BodySubscribers.mapping(
                    upstream,
                    b -> {
                        return deserializer.apply(b);
                    }
            );
        };
    }

    static <T> HttpResponse.BodyHandler<T> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                              final Class<T> valueType) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(valueType, "valueType is null");
        return newJsonBodyHandler(
                HttpResponse.BodySubscribers.ofInputStream(),
                b -> {
                    try {
                        return objectMapper.readValue(b, valueType);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
        );
    }

    static <T> HttpResponse.BodyHandler<T> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                              final TypeReference<T> typeReference) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(typeReference, "typeReference is null");
        return newJsonBodyHandler(
                HttpResponse.BodySubscribers.ofInputStream(),
                b -> {
                    try {
                        return objectMapper.readValue(b, typeReference);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * .
     *
     * @param upstream     .
     * @param deserializer .
     * @param <T>          .
     * @param <U>          .
     * @return .
     * @see java.net.http.HttpResponse.BodySubscribers#mapping(HttpResponse.BodySubscriber, Function)
     */
    static <T, U> HttpResponse.BodyHandler<Supplier<U>> newJsonBodyHandlerDeferred(
            final HttpResponse.BodySubscriber<T> upstream,
            final Function<? super T, ? extends U> deserializer) {
        Objects.requireNonNull(upstream, "upstream is null");
        Objects.requireNonNull(deserializer, "deserializer is null");
        return ri -> {
            final var statusCode = ri.statusCode();
            if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                return HttpResponse.BodySubscribers.mapping(
                        HttpResponse.BodySubscribers.discarding(),
                        b -> () -> null
                );
            }
            if (statusCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("unexpected response code: " + statusCode);
            }
            return HttpResponse.BodySubscribers.mapping(
                    upstream,
                    b -> () -> {
                        return deserializer.apply(b);
                    }
            );
        };
    }

    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandlerDeferred(final ObjectMapper objectMapper,
                                                                                final Class<T> valueType) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(valueType, "valueType is null");
        return newJsonBodyHandlerDeferred(
                HttpResponse.BodySubscribers.ofInputStream(),
                b -> {
                    try {
                        return objectMapper.readValue(b, valueType);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
        );
    }

    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandlerDeferred(final ObjectMapper objectMapper,
                                                                                final TypeReference<T> typeReference) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(typeReference, "typeReference is null");
        return newJsonBodyHandlerDeferred(
                HttpResponse.BodySubscribers.ofInputStream(),
                b -> {
                    try {
                        return objectMapper.readValue(b, typeReference);
                    } catch (final IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _JavaNetHttpUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
