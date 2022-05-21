package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.ApfsFile;
import edu.umb.cs680.hw08.ApfsLink;

public class ApfsDirectoryTest {
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

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEquality() {
		String[] expected = { "true", "defaultOwnerName", "175", "defaultLastModifiedTime", "2" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "defaultOwnerName", "125", "defaultLastModifiedTime", "1" };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectoryTestingTrue() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileTestingFalse() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkTestingFalse() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void appendChildrenTestingWithRoot() {
		assertSame(root, bin.getParent());
	}
	
	@Test
	public void countChildrenTesting() {
		assertEquals(2, root.countChildren());;
	}

	@Test
	public void getLinksTestingWithHome() {
		assertSame(m, home.getLinks().get(0));
	}

	@Test
	public void getTotalSizeTesting() {
		assertEquals(125, home.getTotalSize());
	}

}
