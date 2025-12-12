package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

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

    // ------------------------------------------------------------------------------------------------------ /character
    @Override
    public CompletableFuture<CharacterPage> getAllCharacters(final Executor executor, final int page) {
        RickAndMortyApiClientUtils.requirePositivePage(page);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character?page=" + page))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandlerDeferred(objectMapper, CharacterPage.class))
                .thenApply(HttpResponse::body)
                .thenApplyAsync(Supplier::get, executor);
    }

    @Override
    public CompletableFuture<List<CharacterType>> getAllCharacters(final Executor executor) {
        Objects.requireNonNull(executor, "executor is null");
        return AsynchronousRickAndMortyApiClient.super.getAllCharacters(executor);
    }

    @Override
    public CompletableFuture<List<CharacterType>> getCharacters(final Executor executor,
                                                                final int... ids) {
        Objects.requireNonNull(executor, "executor is null");
        RickAndMortyApiClientUtils.requireNonEmptyIds(ids);
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
                .thenApply(HttpResponse::body)
                .thenApplyAsync(Supplier::get, executor);
    }

    @Override
    public CompletableFuture<CharacterType> getCharacter(final Executor executor, final int id) {
        RickAndMortyApiClientUtils.requirePositiveId(id);
        final var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri("/character/" + id))
                .build();
        return httpClient
                .sendAsync(request, _JavaNetHttpUtils.newJsonBodyHandlerDeferred(objectMapper, CharacterType.class))
                .thenApply(HttpResponse::body)
                .thenApplyAsync(Supplier::get, executor);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientConfigurationJre configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
