package io.github.jinahya.rickandmortyapi.client.javanet;

import io.github.jinahya.rickandmortyapi.client.AbstractRickAndMortyApiClientConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class RickAndMortyApiClientConfigurationJavaNet extends AbstractRickAndMortyApiClientConfiguration {

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------
    private static final String NAME = "rickandmortyapi-client-configuration-javanet.yaml";

    private static RickAndMortyApiClientConfigurationJavaNet load() throws IOException {
        try (var resource = RickAndMortyApiClientConfigurationJavaNet.class.getResourceAsStream(NAME)) {
            if (resource == null) {
                throw new RuntimeException("no resource loaded form " + NAME);
            }
            final var loaded = new Yaml().loadAs(resource, RickAndMortyApiClientConfigurationJavaNet.class);
            logger.log(System.Logger.Level.DEBUG, "loaded: {0}", loaded);
            return loaded;
        }
    }

    private static final class InstanceHolder {

        private static final RickAndMortyApiClientConfigurationJavaNet INSTANCE;

        static {
            try {
                INSTANCE = load();
            } catch (final IOException ioe) {
                throw new ExceptionInInitializerError(ioe);
            }
        }

        private InstanceHolder() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    static RickAndMortyApiClientConfigurationJavaNet getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected RickAndMortyApiClientConfigurationJavaNet() {
        super();
    }
}
