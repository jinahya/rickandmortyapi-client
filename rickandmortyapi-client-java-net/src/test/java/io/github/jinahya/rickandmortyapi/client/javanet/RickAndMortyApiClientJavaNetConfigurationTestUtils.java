package io.github.jinahya.rickandmortyapi.client.javanet;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

final class RickAndMortyApiClientJavaNetConfigurationTestUtils {

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------
    static final String RESOURCE_NAME = "rickandmortyapi-client-javanet-configuration.yaml";

    static RickAndMortyApiClientJavaNetConfiguration load() throws IOException {
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

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientJavaNetConfigurationTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
