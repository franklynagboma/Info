package com.franklyn.info.helper;

import java.util.HashMap;

/**
 * Created by FRANKLYN on 03/09/2016.
 */
public class Maps {
    /**
     * Creates a {@code HashMap} instance.
     *
     * @return a newly-created, initially-empty {@code HashMap}
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }
}
