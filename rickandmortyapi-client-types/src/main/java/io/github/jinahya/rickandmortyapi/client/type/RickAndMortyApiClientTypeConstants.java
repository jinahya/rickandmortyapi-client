package io.github.jinahya.rickandmortyapi.client.type;

/**
 * Constants for types.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public final class RickAndMortyApiClientTypeConstants {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String JSON_PATH_PAGE_INFO = "$.info";

    public static final String JSON_PATH_PAGE_RESULTS = "$.results";

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientTypeConstants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
