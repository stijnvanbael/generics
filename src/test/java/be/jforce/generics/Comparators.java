package be.jforce.generics;

import com.google.common.base.Function;

import java.util.Comparator;

public final class Comparators {
    private Comparators() {
    }

    public static Comparator on(final Function comparableExtractor) {
        return new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) comparableExtractor.apply(o1)).compareTo(comparableExtractor.apply(o2));
            }
        };
    }
}
