package io.github.jinahya.rickandmortyapi.client.jre;

import io.github.jinahya.rickandmortyapi.client.AsynchronousRickAndMortyApiClient;
import io.github.jinahya.rickandmortyapi.client.RickAndMortyApiClientUtils;
import io.github.jinahya.rickandmortyapi.client.type.CharacterPage;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class AsynchronousRickAndMortyApiClientJavaNet
        implements AsynchronousRickAndMortyApiClient {

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
    public CompletableFuture<Supplier<CharacterPage>> getAllCharactersDeferred(final int page) {
        RickAndMortyApiClientUtils.requireValidPage(page);
        return CompletableFuture.supplyAsync(() -> () -> {
            try {
                return synchronous.getAllCharacters(page).orElse(null);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<Supplier<List<CharacterType>>> getCharactersDeferred(final int[] ids) {
        RickAndMortyApiClientUtils.requireValidIds(ids);
        return CompletableFuture.supplyAsync(() -> () -> {
            try {
                return synchronous.getCharacters(ids);
            } catch (final IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });
    }

    @Override
    public CompletableFuture<Supplier<CharacterType>> getCharacterDeferred(final int id) {
        RickAndMortyApiClientUtils.requireValidId(id);
        return CompletableFuture.supplyAsync(() -> () -> {
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
