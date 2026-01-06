package io.github.jinahya.rickandmortyapi.client.type;

import java.time.format.DateTimeFormatter;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class EpisodeType_Constants {

    // "December 2, 2013"
    static final String AIR_DATE_PATTERN = "MMMM d, uuuu";
//    static final String AIR_DATE_PATTERN = "MMMM d, yyyy";

    static final DateTimeFormatter AIR_DATE_FORMATTER = DateTimeFormatter.ofPattern(AIR_DATE_PATTERN);

    private EpisodeType_Constants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
