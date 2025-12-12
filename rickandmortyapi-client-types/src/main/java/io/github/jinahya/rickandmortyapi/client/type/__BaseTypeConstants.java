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

        public static final class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

            @Override
            public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
                    throws IOException, JacksonException {
                final var text = p.getText();
                if (text == null) {
                    return null;
                }
                return LocalDate.parse(text, DATE_FORMATTER);
            }
        }

        private OfJackson() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    public static final class OfJsonb {

        public static final class LocalDateAdapter implements JsonbAdapter<LocalDate, String> {

            @Override
            public String adaptToJson(LocalDate obj) throws Exception {
                throw new UnsupportedOperationException("not implemented yet");
            }

            @Override
            public LocalDate adaptFromJson(final String obj) throws Exception {
                return Optional.ofNullable(obj)
                        .map(v -> LocalDate.parse(v, DATE_FORMATTER))
                        .orElse(null);
            }
        }

        private OfJsonb() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    private __BaseTypeConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
