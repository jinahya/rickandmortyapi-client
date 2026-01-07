package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class AsynchronousRickAndMortyApiClientJavaNetHttp implements AsynchronousRickAndMortyApiClient {

    private static Executor requireNonNullExecutor(final Executor executor) {
        return Objects.requireNonNull(executor, "executor is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    public AsynchronousRickAndMortyApiClientJavaNetHttp(final RickAndMortyApiClientConfigurationJavaNetHttp configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
        httpClient = this.configuration.configure(HttpClient.newBuilder()).build();
    }

    AsynchronousRickAndMortyApiClientJavaNetHttp() {
        this(new RickAndMortyApiClientConfigurationJavaNetHttp());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URI uri(final String path) {
        return URI.create(configuration.getBaseUrl() + path);
    }

    // ------------------------------------------------------------------------------------------------------ /character
    @Override
    public CompletableFuture<Supplier<CharacterPage>> getAllCharactersDeferred(final int page) {
        RickAndMortyApiClientUtils.requireValidPage(page);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character?page=" + page))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandlerDeferred(objectMapper, CharacterPage.class))
                .thenApply(HttpResponse::body);
    }

    @Override
    public CompletableFuture<Supplier<List<CharacterType>>> getCharactersDeferred(@NotNull int... ids) {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character/" + RickAndMortyApiClientUtils.joinIds(ids)))
                .build();
        return httpClient
                .sendAsync(
                        request,
                        _JavaNetHttpUtils.newJsonBodyHandlerDeferred(
                                objectMapper,
                                new TypeReference<List<CharacterType>>() {
                                }
                        )
                )
                .thenApply(HttpResponse::body);
    }

    @Override
    public CompletableFuture<Supplier<CharacterType>> getCharacterDeferred(final int id) {
        RickAndMortyApiClientUtils.requireValidId(id);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character/" + id))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandlerDeferred(objectMapper, CharacterType.class))
                .thenApply(HttpResponse::body);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJavaNetHttp configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
