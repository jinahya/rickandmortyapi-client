package io.github.jinahya.rickandmortyapi.client.javanet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class AsynchronousRickAndMortyApiClientJre implements AsynchronousRickAndMortyApiClient {

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

    // -----------------------------------------------------------------------------------------------------------------
    public AsynchronousRickAndMortyApiClientJre(final RickAndMortyApiClientJavaNetConfiguration configuration) {
        super();
        this.configuration = Objects.requireNonNull(configuration, "configuration is null");
        httpClient = this.configuration.configure(HttpClient.newBuilder()).build();
    }

    AsynchronousRickAndMortyApiClientJre() {
        this(new RickAndMortyApiClientJavaNetConfiguration());
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URI uri(final String path) {
        return URI.create(configuration.getBaseUrl() + path);
    }

    private <R> R applyHttpClient(final String path, final Function<? super HttpClient.Builder, ? extends R> function) {
        Objects.requireNonNull(function, "function is null");
        final HttpClient.Builder builder = HttpClient.newBuilder();
        final var built = builder.build();
        return null;
    }

    // ---------------------------------------------------------------------------------------------------- character(s)
    @Override
    public CompletableFuture<CharacterPageResponse> getAllCharacters(final int page) throws IOException {
        return null;
    }

    @Override
    public CompletableFuture<CharacterType> getAllCharacters() {
        return null;
    }

    @Override
    public CompletableFuture<CharacterType> getCharacters(final int... ids) {
        return null;
    }

    @Override
    public CompletableFuture<CharacterType> getCharacter(final int id) {
        return null;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientJavaNetConfiguration configuration;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
}
