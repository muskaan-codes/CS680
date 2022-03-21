package edu.umb.cs680.hw04;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.nio.file.*;

public class LRUCache extends FileCache{
    private int scope;

    public LRUCache(int capacity) {
        this.scope = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    protected boolean isCached(Path path) {
        return cache.containsKey(path);
    }

    protected boolean isCacheFull() {
        return cache.size() == scope;
    }

    @Override
    protected void cacheFile(Path path) {
        try {
            String matter = Files.readString(path);
            cache.put(path, matter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void replace(Path path) {
        try {
            String matter = Files.readString(path);
            Path deleteKey = cache.keySet().iterator().next();
            cache.remove(deleteKey);
            cache.put(path, matter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
