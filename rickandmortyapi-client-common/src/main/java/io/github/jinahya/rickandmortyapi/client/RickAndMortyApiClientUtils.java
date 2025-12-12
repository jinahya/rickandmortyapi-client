package io.github.jinahya.rickandmortyapi.client;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RickAndMortyApiClientUtils {

    // -----------------------------------------------------------------------------------------------------------------
    public static int requireValidPage(final int page) {
        if (page < 1) {
            throw new IllegalArgumentException("page is not positive: " + page);
        }
        return page;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static int[] requireValidIds(final int... ids) {
        if (Objects.requireNonNull(ids, "ids is null").length == 0) {
            throw new IllegalArgumentException("empty ids");
        }
        return ids;
    }

    public static String joinIds(final int... ids) {
        return IntStream.of(ids)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static int requireValidId(final int id) {
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
