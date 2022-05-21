package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsFSElement{
	private LinkedList<ApfsFSElement> children;
	
	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
			String lastModifiedTime) {
		super(parent, name, size, creationTime, ownerName, lastModifiedTime);
		this.children = new LinkedList<>();
	}

	public boolean isDirectory() {
		return true;
	}
	
	public boolean isFile() {
		return false;
	}

	public boolean isLink() {
		return false;
	}
	
	public LinkedList<ApfsFSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(ApfsFSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<ApfsDirectory> getSubDirectories() {
		LinkedList<ApfsDirectory> subDirs = new LinkedList<>();
		for (ApfsFSElement e : children) {
			if (e.isDirectory()) {;
				subDirs.add((ApfsDirectory)e);
			}
		}
		return subDirs;
	}
	
	public LinkedList<ApfsFile> getFiles(){
		LinkedList<ApfsFile> files = new LinkedList<>();
		for (FSElement e : children) {
			if (e.isFile()) {
				files.add((ApfsFile)e);
			}
		}
		return files;
	}
	
	public LinkedList<ApfsLink> getLinks(){
		LinkedList<ApfsLink> links = new LinkedList<>();
		for (ApfsFSElement fsElement : children) {
			if (fsElement.isLink()) {
				links.add((ApfsLink)fsElement);
			}
		}
		return links;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (ApfsFSElement e : children) {
			if (e.isDirectory()) {
				totalSize += (ApfsDirectory)e.getTotalSize();
			}else {
				totalSize += e.getSize();
			}
		}
		return totalSize;
	}

	public static void main(String[] args) {
		System.out.println("APFS Directory Class");
	}

}
