package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

final class _JavaNetHttpUtils {

    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandler(
            final Function<? super InputStream, ? extends T> deserializer) {
        Objects.requireNonNull(deserializer, "deserializer is null");
        return ri -> {
            {
                final var statusCode = ri.statusCode();
                ri.headers().map().forEach((n, l) -> {
                });
                if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
                    return HttpResponse.BodySubscribers.mapping(
                            HttpResponse.BodySubscribers.discarding(),
                            b -> () -> null
                    );
                }
            }
            return HttpResponse.BodySubscribers.mapping(
                    HttpResponse.BodySubscribers.ofInputStream(),
                    b -> () -> {
                        return deserializer.apply(b);
                    });
        };
    }

    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                                        final Class<T> valueType) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(valueType, "valueType is null");
        return newJsonBodyHandler(b -> {
            try {
                return objectMapper.readValue(b, valueType);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                                        final TypeReference<T> typeReference) {
        Objects.requireNonNull(objectMapper, "objectMapper is null");
        Objects.requireNonNull(typeReference, "typeReference is null");
        return newJsonBodyHandler(b -> {
            try {
                return objectMapper.readValue(b, typeReference);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

//    // -----------------------------------------------------------------------------------------------------------------
//    static <T> HttpResponse.BodyHandler<Supplier<Optional<T>>> newJsonBodyHandlerOptional(
//            final Function<? super InputStream, ? extends T> deserializer) {
//        Objects.requireNonNull(deserializer, "deserializer is null");
//        return ri -> {
//            {
//                final var statusCode = ri.statusCode();
//                ri.headers().map().forEach((n, l) -> {
//                });
//                if (statusCode == HttpURLConnection.HTTP_NOT_FOUND) {
//                    return HttpResponse.BodySubscribers.mapping(
//                            HttpResponse.BodySubscribers.discarding(),
//                            b -> () -> null
//                    );
//                }
//            }
//            return HttpResponse.BodySubscribers.mapping(
//                    HttpResponse.BodySubscribers.ofInputStream(),
//                    b -> () -> {
//                        return deserializer.apply(b);
//                    });
//        };
//    }
//
//    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandlerOptional(final ObjectMapper objectMapper,
//                                                                                final Class<T> valueType) {
//        Objects.requireNonNull(objectMapper, "objectMapper is null");
//        Objects.requireNonNull(valueType, "valueType is null");
//        return newJsonBodyHandler(b -> {
//            try {
//                return objectMapper.readValue(b, valueType);
//            } catch (final IOException ioe) {
//                throw new RuntimeException(ioe);
//            }
//        });
//    }
//
//    static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandlerOptional(final ObjectMapper objectMapper,
//                                                                                final TypeReference<T> typeReference) {
//        Objects.requireNonNull(objectMapper, "objectMapper is null");
//        Objects.requireNonNull(typeReference, "typeReference is null");
//        return newJsonBodyHandler(b -> {
//            try {
//                return objectMapper.readValue(b, typeReference);
//            } catch (final IOException ioe) {
//                throw new RuntimeException(ioe);
//            }
//        });
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private _JavaNetHttpUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
