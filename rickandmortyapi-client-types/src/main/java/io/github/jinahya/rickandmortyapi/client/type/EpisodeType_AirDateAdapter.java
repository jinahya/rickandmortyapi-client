package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.adapter.JsonbAdapter;

import java.time.LocalDate;
import java.util.Optional;

public final class EpisodeType_AirDateAdapter
        implements JsonbAdapter<LocalDate, String> {

    @Override
    public String adaptToJson(LocalDate obj) throws Exception {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public LocalDate adaptFromJson(final String obj) throws Exception {
        return Optional.ofNullable(obj)
                .map(v -> LocalDate.parse(v, EpisodeType_Constants.AIR_DATE_FORMATTER))
                .orElse(null);
    }
}
