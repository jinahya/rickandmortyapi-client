package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import jakarta.json.bind.adapter.JsonbAdapter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class __BaseTypeConstants {

    // "December 2, 2013"
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d, uuuu");

    public static final class OfJackson {

        private OfJackson() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    public static final class OfJsonb {

        private OfJsonb() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    private __BaseTypeConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
