package edu.umb.cs680.hw08_optional;

import java.time.LocalDateTime;

public abstract class FatFSElement extends FSElement{

	public FatFSElement(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}

}
