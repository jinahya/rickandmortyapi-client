package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public class AsynchronousRickAndMortyApiClientJavaNetHttp implements AsynchronousRickAndMortyApiClient {

//    // -----------------------------------------------------------------------------------------------------------------
//    private static final class InstanceHolder {
//
//        private static final RickAndMortyApiClientJavaNet INSTANCE = new RickAndMortyApiClientJavaNet();
//
//        private InstanceHolder() {
//            throw new AssertionError("instantiation is not allowed");
//        }
//    }
//
//    public static RickAndMortyApiClientJavaNet getInstance() {
//        return InstanceHolder.INSTANCE;
//    }

    private static <T> HttpResponse.BodyHandler<Supplier<T>> newJsonBodyHandler(final ObjectMapper objectMapper,
                                                                                final Class<T> clazz) {
        return ri -> {
            {
                final var statusCode = ri.statusCode();
                ri.headers().map().forEach((n, l) -> {
                });
            }
            return HttpResponse.BodySubscribers.mapping(
                    HttpResponse.BodySubscribers.ofInputStream(),
                    b -> () -> {
                        try {
                            return objectMapper.readValue(b, clazz);
                        } catch (final IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                    });
        };
    }

    // -----------------------------------------------------------------------------------------------------------------
    public AsynchronousRickAndMortyApiClientJavaNetHttp(final RickAndMortyApiClientConfigurationJre configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
        httpClient = this.configuration.configure(HttpClient.newBuilder()).build();
    }

    AsynchronousRickAndMortyApiClientJavaNetHttp() {
        this(new RickAndMortyApiClientConfigurationJre());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URI uri(final String path) {
        return URI.create(configuration.getBaseUrl() + path);
    }

    private <R> R applyHttpClient(final String path,
                                  final Function<? super HttpClient.Builder, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        final HttpClient.Builder builder = HttpClient.newBuilder();
        final var built = builder.build();
        return null;
    }

    // ---------------------------------------------------------------------------------------------------- character(s)
    @Override
    public CompletableFuture<CharacterPage> getAllCharacters(final int page) {
        RickAndMortyApiClientUtils.requirePositivePage(page);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character?page=" + page))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandler(objectMapper, CharacterPage.class))
                .thenApply(HttpResponse::body)
                .thenApply(Supplier::get);
    }

    @Override
    public CompletableFuture<List<CharacterType>> getAllCharacters() {
        return AsynchronousRickAndMortyApiClient.super.getAllCharacters();
    }

    @Override
    public CompletableFuture<List<CharacterType>> getCharacters(final int... ids) {
        RickAndMortyApiClientUtils.requireNonEmptyIds(ids);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character/" + RickAndMortyApiClientUtils.joinIds(ids)))
                .build();
        return httpClient
                .sendAsync(
                        request,
                        _JavaNetHttpUtils.newJsonBodyHandler(objectMapper, new TypeReference<List<CharacterType>>() {
                        })
                )
                .thenApply(HttpResponse::body)
                .thenApply(Supplier::get);
    }

    @Override
    public CompletableFuture<CharacterType> getCharacter(final int id) {
        RickAndMortyApiClientUtils.requirePositiveId(id);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character/" + id))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandler(objectMapper, CharacterType.class))
                .thenApply(HttpResponse::body)
                .thenApply(Supplier::get);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJre configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
