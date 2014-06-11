package be.jforce.generics.solution;

import com.google.common.base.Function;

import java.util.Comparator;

public final class Comparators {
    private Comparators() {
    }

    public static <T, E extends Comparable<E>> Comparator<T> on(final Function<T, E> comparableExtractor) {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return comparableExtractor.apply(o1).compareTo(comparableExtractor.apply(o2));
            }
        };
    }
}
