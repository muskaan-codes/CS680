package edu.umb.cs680.hw08_optional;

import java.time.LocalDateTime;

public class FatFile extends FatFSElement{

	public FatFile(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

}
