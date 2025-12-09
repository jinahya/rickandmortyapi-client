package io.github.jinahya.the.rick.and.morty.api.client.type;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApiResponse extends __BaseType {

    @JsonAnySetter
    void addApiNameAndBaseUrl(String apiName, Object baseUrl) {
        getApiNamesAndBaseUrls().put(apiName, (URL) baseUrl);
    }

    // ----------------------------------------------------------------------------------------------------------------- characters
    public URL getCharacters() {
        return characters;
    }

    // ----------------------------------------------------------------------------------------------------------------- locations
    public URL getLocations() {
        return locations;
    }

    // ----------------------------------------------------------------------------------------------------------------- episodes
    public URL getEpisodes() {
        return episodes;
    }

    // ------------------------------------------------------------------------------------------------ namesAndBaseUrls
    Map<String, URL> getApiNamesAndBaseUrls() {
        if (apiNamesAndBaseUrls == null) {
            apiNamesAndBaseUrls = new HashMap<>();
        }
        return apiNamesAndBaseUrls;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private URL characters;

    private URL locations;

    private URL episodes;

    // -----------------------------------------------------------------------------------------------------------------
    private Map<String, URL> apiNamesAndBaseUrls;
}
