package io.github.jinahya.rickandmortyapi.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;

@Slf4j
public abstract class RickAndMortyApiClientIT<T extends RickAndMortyApiClient> {

    protected RickAndMortyApiClientIT(final Class<T> clientClass) {
        super();
        this.clientClass = Objects.requireNonNull(clientClass, "clientClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    protected void getAllCharacters__() {
        final var instance = newClientInstance();
        final var result = instance.getAllCharacters();
        if (!result.isEmpty()) {
            log.debug("first character: {}", result.getFirst());
            log.debug("last character: {}", result.getLast());
        }
    }

    // ----------------------------------------------------------------------------------------------------- clientClass
    protected T newClientInstance() {
        try {
            final var constructor = clientClass.getDeclaredConstructor();
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (final ReflectiveOperationException roe) {
            throw new RuntimeException("failed to instantiate" + clientClass, roe);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<T> clientClass;
}
