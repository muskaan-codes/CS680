package edu.umb.cs680.hw04;

import java.nio.file.Path;
import java.util.Map;

public abstract class FileCache {

    protected Map<Path, String> cache;

    public String fetch(Path path) {
        if (!isCached(path)) {
            if (!isCacheFull()) {
                cacheFile(path);
            } else {
                replace(path);
            }
        }
        return cache.get(path);
    }

    protected abstract boolean isCached(Path path);
    protected abstract boolean isCacheFull();
    protected abstract void cacheFile(Path path);
    protected abstract void replace(Path path);

}
