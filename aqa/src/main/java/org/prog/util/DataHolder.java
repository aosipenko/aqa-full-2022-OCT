package org.prog.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataHolder {
    private final HashMap<String, Object> objectHolder = new HashMap<>();

    public void put(String key, Object object) {
        objectHolder.put(key, object);
    }

    public Object get(String key) {
        return objectHolder.get(key);
    }
}
