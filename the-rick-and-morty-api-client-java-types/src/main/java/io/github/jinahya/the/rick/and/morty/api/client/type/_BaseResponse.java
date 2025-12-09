package io.github.jinahya.the.rick.and.morty.api.client.type;

import jakarta.annotation.Nullable;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.validation.constraints.PositiveOrZero;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
public class _BaseResponse<RESULT> extends __BaseType {

    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    protected static class _Info extends __BaseType {

        // -------------------------------------------------------------------------------------------------------------
        protected _Info() {
            super();
        }

        // -------------------------------------------------------------------------------------------- java.lang.Object
        @Override
        public String toString() {
            return super.toString() + '{' +
                    "count=" + count +
                    ",pages=" + pages +
                    ",next=" + next +
                    ",prev=" + prev +
                    '}';
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof _Info info)) {
                return false;
            }
            return count == info.count
                    && pages == info.pages
                    && Objects.equals(next, info.next)
                    && Objects.equals(prev, info.prev);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, pages, next, prev);
        }

        // -------------------------------------------------------------------------------------------------------------
        public int getCount() {
            return count;
        }

        void setCount(final int count) {
            this.count = count;
        }

        // -------------------------------------------------------------------------------------------------------------
        public int getPages() {
            return pages;
        }

        void setPages(final int pages) {
            this.pages = pages;
        }

        // -------------------------------------------------------------------------------------------------------------
        public URI getNext() {
            return next;
        }

        void setNext(final URI next) {
            this.next = next;
        }

        // -------------------------------------------------------------------------------------------------------------
        public URI getPrev() {
            return prev;
        }

        void setPrev(final URI prev) {
            this.prev = prev;
        }

        // -------------------------------------------------------------------------------------------------------------
        @PositiveOrZero
        private int count;

        @PositiveOrZero
        private int pages;

        @Nullable
        private URI next;

        @Nullable
        private URI prev;
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected _BaseResponse() {
        super();
    }

    // ----------------------------------------------------------------------------------------------------------------- java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "info=" + info +
                ",results=" + results +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    public _Info getInfo() {
        return info;
    }

    void setInfo(_Info info) {
        this.info = info;
    }

    public List<RESULT> getResults() {
        return results;
    }

    void setResults(List<RESULT> results) {
        this.results = results;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private _Info info;

    private List<RESULT> results;
}
