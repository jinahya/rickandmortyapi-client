package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

public final class EpisodeType_AirDateSerializer
        extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        gen.writeString(EpisodeType_Constants.AIR_DATE_FORMATTER.format(value));
    }
}
