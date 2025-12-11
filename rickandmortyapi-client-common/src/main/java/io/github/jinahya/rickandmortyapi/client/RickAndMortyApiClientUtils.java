package io.github.jinahya.rickandmortyapi.client;

import java.util.Objects;

public final class RickAndMortyApiClientUtils {

    public static int requirePositivePage(final int page) {
        if (page < 1) {
            throw new IllegalArgumentException("page is not positive: " + page);
        }
        return page;
    }

    public static int[] requireNonEmptyIds(final int... ids) {
        if (Objects.requireNonNull(ids, "ids is null").length == 0) {
            throw new IllegalArgumentException("empty ids");
        }
        return ids;
    }

    public static int requirePositiveId(final int id) {
        if (id < 1) {
            throw new IllegalArgumentException("id is not positive: " + id);
        }
        return id;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private RickAndMortyApiClientUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
