package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public final class EpisodeType_AirDateDeserializer
        extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JacksonException {
        final var text = p.getText();
        if (text == null) {
            return null;
        }
        return LocalDate.parse(text, EpisodeType_Constants.AIR_DATE_FORMATTER);
    }
}
