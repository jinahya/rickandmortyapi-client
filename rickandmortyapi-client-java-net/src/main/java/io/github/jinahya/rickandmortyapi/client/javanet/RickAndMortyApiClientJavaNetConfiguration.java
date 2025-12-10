package io.github.jinahya.rickandmortyapi.client.javanet;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.github.jinahya.rickandmortyapi.client.AbstractRickAndMortyApiClientConfiguration;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

public class RickAndMortyApiClientJavaNetConfiguration extends AbstractRickAndMortyApiClientConfiguration {

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------
    public static final String RESOURCE_NAME = "rickandmortyapi-client-javanet-configuration.yaml";

    public static RickAndMortyApiClientJavaNetConfiguration load() throws IOException {
        try (var resource = RickAndMortyApiClientJavaNetConfiguration.class.getResourceAsStream(RESOURCE_NAME)) {
            if (resource == null) {
                return new RickAndMortyApiClientJavaNetConfiguration();
            }
            final var mapper = new YAMLMapper()
                    .findAndRegisterModules()
                    .setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
            final var value = mapper.readValue(resource, RickAndMortyApiClientJavaNetConfiguration.class);
            logger.log(System.Logger.Level.DEBUG, "value: {0}", value);
            return value;
        }
    }

//    private static final class InstanceHolder {
//
//        private static final RickAndMortyApiClientJavaNetConfiguration INSTANCE;
//
//        static {
//            try {
//                INSTANCE = load();
//            } catch (final IOException ioe) {
//                ioe.printStackTrace();
//                throw new ExceptionInInitializerError(ioe);
//            }
//        }
//
//        private InstanceHolder() {
//            throw new AssertionError("instantiation is not allowed");
//        }
//    }
//
//    static RickAndMortyApiClientJavaNetConfiguration getInstance() {
//        return InstanceHolder.INSTANCE;
//    }

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientJavaNetConfiguration() {
        super();
    }
}
