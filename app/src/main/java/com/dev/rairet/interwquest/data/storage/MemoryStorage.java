package com.dev.rairet.interwquest.data.storage;

import java.util.HashMap;

public class MemoryStorage {

    private HashMap<String, Object> map;

    public MemoryStorage() {
        map = new HashMap<>();
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object getAndClear(String key) {
        Object result = map.get(key);
        clear(key);
        return result;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void clear(String key) {
        map.remove(key);
    }

}
