package edu.umb.cs680.hw08_optional;

import java.time.LocalDateTime;

public abstract class FSElement {
	protected FatDirectory parent;
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	
	public FSElement(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
	}
	
	public FatDirectory getParent() {
		return parent;
	}

	public void setParent(FatDirectory parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	
	public abstract boolean isDirectory();
	public abstract boolean isFile();
	
}
