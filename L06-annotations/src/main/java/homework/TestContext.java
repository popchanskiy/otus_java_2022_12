package homework;

import java.util.*;
import java.util.concurrent.*;

public class TestContext {

    private static class ContextEntry<T> {
        private T t;

        private ContextEntry(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }

    private static Map<String, ContextEntry> testContext = new ConcurrentHashMap<>();

    public static void clear() {
        testContext = new ConcurrentHashMap<>();
    }

    public static <T> void put(String alias, T t) {
        testContext.put(alias, new ContextEntry<T>(t));
    }

    public static <T> T get(String alias) {
        if (testContext.containsKey(alias)) {
            return (T) testContext.get(alias).getT();
        }
        return null;
    }

}

