package edu.umb.cs680.hw08_optional;

import java.time.LocalDateTime;

public class FAT extends FileSystem{
	private static FAT instance = null;

	private FAT(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public static FAT getFat() {
		if (instance == null) {
			instance = new FAT("SingletonFAT", 1000);
		}
		return instance;
	}
	
	protected FSElement createDefaultRoot() {
		return new FatDirectory(null, "default_root", 200, LocalDateTime.now());
	}
	
	public void addRootDir(FatDirectory dir) {
		this.getRootDirs().add(dir);
	}

}
