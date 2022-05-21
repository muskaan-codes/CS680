package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.ApfsFile;
import edu.umb.cs680.hw08.ApfsLink;

public class ApfsFileTest {
	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new ApfsDirectory(null, "root", 0, localTime, "defaultOwnerName", "defaultLastModifiedTime");  // directory has size 0

	Directory bin = new ApfsDirectory(root, "bin", 0, localTime, "defaultOwnerName", "defaultLastModifiedTime");
	File y = new ApfsFile(bin, "y", 50, localTime, "defaultOwnerName", "defaultLastModifiedTime");

	Directory home = new ApfsDirectory(root, "home", 0, localTime, "defaultOwnerName", "defaultLastModifiedTime");

	Directory pictures = new ApfsDirectory(home, "pictures", 0, localTime, "defaultOwnerName", "defaultLastModifiedTime");
	File a = new ApfsFile(pictures, "a", 50, localTime, "defaultOwnerName", "defaultLastModifiedTime");
	File b = new ApfsFile(pictures, "b", 50, localTime, "defaultOwnerName", "defaultLastModifiedTime");
	File c = new ApfsFile(home, "c", 25, localTime, "defaultOwnerName", "defaultLastModifiedTime");
	Link m = new ApfsLink(home, "m", 0, localTime, "defaultOwnerName", "defaultLastModifiedTime", bin);
	
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getOwnerName(), String.valueOf(f.getSize()),
							f.getLastModifiedTime(), f.getParent().getName() };
		return fileInfo;
	}


	
	@Test
	public void verifyFileEquality() {
		String[] expected = { "true", "defaultOwnerName", "50", "defaultLastModifiedTime", "pictures" };
		ApfsFile actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoryTestingFalse() {
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void isFileTestingWithTrue() {
		assertTrue(b.isFile());
	}
	
	@Test
	public void isLinkTestingWithFalse() {
		assertFalse(b.isLink());
	}

}
