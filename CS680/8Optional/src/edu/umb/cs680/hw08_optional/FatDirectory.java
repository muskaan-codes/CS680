package edu.umb.cs680.hw08_optional;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FatDirectory extends FatFSElement{
	private LinkedList<FatFSElement> children;
	
	public FatDirectory(FatDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		this.children = new LinkedList<>();
	}
	
	public boolean isDirectory() {
		return true;
	}
	
	public boolean isFile() {
		return false;
	}
	
	public LinkedList<FatFSElement> getChildren(){
		return this.children;
	}
	
	public void appendChild(FatFSElement child) {
		this.children.add(child);
		child.setParent(this);
	}
	
	public int countChildren() {
		return this.children.size();
	}
	
	public LinkedList<FatDirectory> getSubDirectories() {
		LinkedList<FatDirectory> subDirs = new LinkedList<>();
		for (FatFSElement e : children) {
			if (e.isDirectory()) {
				FatDirectory subDir = (FatDirectory)e;
				subDirs.add(subDir);
			}
		}
		return subDirs;
	}
	
	public LinkedList<FatFile> getFiles(){
		LinkedList<FatFile> files = new LinkedList<>();
		for (FSElement e : children) {
			if (e.isFile()) {
				FatFile file = (FatFile)e;
				files.add(file);
			}
		}
		return files;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for (FatFSElement e : children) {
			if (e.isDirectory()) {
				FatDirectory subDir = (FatDirectory)e;
				totalSize += subDir.getTotalSize();
			}else {
				totalSize += e.getSize();
			}
		}
		return totalSize;
	}

}
