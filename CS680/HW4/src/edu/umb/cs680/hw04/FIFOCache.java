package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public class FIFOCache extends FileCache{
    private int scope;

    public FIFOCache(int scope) {
        this.scope = scope;
        cache = new LinkedHashMap<>();
    }

    protected boolean isCached(Path path) {
        return cache.containsKey(path);
    }

    protected boolean isCacheFull() {
        return cache.size() == scope;
    }

    protected void cacheFile(Path path) {
        try {
            String matter = Files.readString(path);
            cache.put(path, matter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
