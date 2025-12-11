package io.github.jinahya.rickandmortyapi.client.jre;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

final class RickAndMortyApiClientJavaNetConfigurationTestUtils {

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------
    static final String RESOURCE_NAME = "rickandmortyapi-client-javanet-configuration.yaml";

    static RickAndMortyApiClientConfigurationJre load() throws IOException {
        try (var resource = RickAndMortyApiClientConfigurationJre.class.getResourceAsStream(RESOURCE_NAME)) {
            if (resource == null) {
                return new RickAndMortyApiClientConfigurationJre();
            }
            final var mapper = new YAMLMapper()
                    .findAndRegisterModules()
                    .setPropertyNamingStrategy(PropertyNamingStrategies.KEBAB_CASE);
            final var value = mapper.readValue(resource, RickAndMortyApiClientConfigurationJre.class);
            logger.log(System.Logger.Level.DEBUG, "value: {0}", value);
            return value;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientJavaNetConfigurationTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
