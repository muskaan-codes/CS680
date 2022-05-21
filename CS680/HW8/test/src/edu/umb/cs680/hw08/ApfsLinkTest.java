package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.ApfsFile;
import edu.umb.cs680.hw08.ApfsLink;

public class ApfsLinkTest {
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
	
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void verifyLinkEquality() {
		String[] expected = { "true", "defaultOwnerName", "0", "defaultLastModifiedTime", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	

	@Test
	public void isDirectoyTestingFalse() {
		assertFalse(m.isDirectory());
	}
	
	@Test
	public void isFileTestingFalse() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void isLinkTestingTrue() {
		assertTrue(m.isLink());
	}
	
	@Test
	public void getTargetTestingTrue() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void setTargetTesting() {
		m.setTarget(bin);
		assertSame(bin, m.getTarget());
	}

}
