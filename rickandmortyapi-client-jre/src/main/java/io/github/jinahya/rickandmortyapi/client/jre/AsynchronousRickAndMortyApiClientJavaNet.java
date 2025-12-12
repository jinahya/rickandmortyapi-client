package io.github.jinahya.rickandmortyapi.client.jre;

import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsynchronousRickAndMortyApiClientJavaNet implements AsynchronousRickAndMortyApiClient {

    // -----------------------------------------------------------------------------------------------------------------
    public AsynchronousRickAndMortyApiClientJavaNet(final RickAndMortyApiClientJavaNet synchronous) {
        super();
        this.synchronous = Objects.requireNonNull(synchronous, "synchronous is null");
    }

    AsynchronousRickAndMortyApiClientJavaNet() {
        this(new RickAndMortyApiClientJavaNet());
    }

    // ------------------------------------------------------------------------------------------------------ characters
    @Override
    public CompletableFuture<CharacterPage> getAllCharacters(final Executor executor, final int page) {
        Objects.requireNonNull(executor, "executor is null");
        RickAndMortyApiClientUtils.requirePositivePage(page);
        return CompletableFuture.supplyAsync(() -> {
            try {
                return synchronous.getAllCharacters(page).orElse(null);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<List<CharacterType>> getAllCharacters(final Executor executor) {
        Objects.requireNonNull(executor, "executor is null");
        return AsynchronousRickAndMortyApiClient.super.getAllCharacters(executor);
    }

    @Override
    public CompletableFuture<List<CharacterType>> getCharacters(final Executor executor, final int... ids) {
        Objects.requireNonNull(executor, "executor is null");
        RickAndMortyApiClientUtils.requireNonEmptyIds(ids);
        return CompletableFuture.supplyAsync(() -> {
            try {
                return synchronous.getCharacters(ids);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<CharacterType> getCharacter(final Executor executor, final int id) {
        Objects.requireNonNull(executor, "executor is null");
        RickAndMortyApiClientUtils.requirePositiveId(id);
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
