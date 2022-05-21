package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class FileTest {
	static LocalDateTime localTime = LocalDateTime.now();

	Directory root = new Directory(null, "root", 0, localTime);

	Directory apps = new Directory(root, "Apps", 0, localTime);
	File x = new File(apps, "x", 100, localTime);

	Directory bin = new Directory(root, "bin", 0, localTime);
	File y = new File(bin, "y", 150, localTime);

	Directory home = new Directory(root, "home", 0, localTime);

	File c = new File(home, "c", 250, localTime);
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityX() {
		String[] expected = { "false", "x", "100", String.valueOf(x.getCreationTime()), "apps" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "false", "c", "250", String.valueOf(a.getCreationTime()), "home" };
		File actual = c;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingFalse() {
		assertFalse(c.isDirectory());
	}

}
