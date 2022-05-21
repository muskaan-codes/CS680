package edu.umb.cs680.hw12;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsFSElement{
	
	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			String lastModifiedTime) {
		super(parent, name, size, creationTime, ownerName, lastModifiedTime);
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
	}

	public static void main(String[] args) {
		System.out.println("APFS File Class");
	}

}
