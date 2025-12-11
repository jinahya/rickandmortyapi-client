package io.github.jinahya.rickandmortyapi.client;

public final class RickAndMortyApiClientConstants {

    static final String BASE_URL = "https://rickandmortyapi.com/api";

    // -----------------------------------------------------------------------------------------------------------------
    public static final int PAGE_ONE = 1;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PARAM_PAGE = "page";

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
