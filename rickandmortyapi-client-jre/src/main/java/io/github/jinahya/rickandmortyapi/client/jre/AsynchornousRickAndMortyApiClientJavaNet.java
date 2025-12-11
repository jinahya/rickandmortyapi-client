package io.github.jinahya.rickandmortyapi.client.jre;

import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class AsynchornousRickAndMortyApiClientJavaNet implements AsynchronousRickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    public AsynchornousRickAndMortyApiClientJavaNet(final RickAndMortyApiClientJavaNet synchronous) {
        super();
        this.synchronous = Objects.requireNonNull(synchronous, "synchronous is null");
    }

    AsynchornousRickAndMortyApiClientJavaNet() {
        this(new RickAndMortyApiClientJavaNet());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public CompletableFuture<CharacterPage> getAllCharacters(final int page) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return synchronous.getAllCharacters(page).orElse(null);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<List<CharacterType>> getAllCharacters() {
        return AsynchronousRickAndMortyApiClient.super.getAllCharacters();
    }

    @Override
    public CompletableFuture<List<CharacterType>> getCharacters(final int... ids) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return synchronous.getCharacters(ids);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<CharacterType> getCharacter(final int id) {
        if (id < 1) {
            throw new IllegalArgumentException("is is not positive: " + id);
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                return synchronous.getCharacter(id).orElse(null);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final RickAndMortyApiClientJavaNet synchronous;
}
