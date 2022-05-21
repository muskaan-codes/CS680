package edu.umb.cs680.hw08_optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08_optional.FatDirectory;
import edu.umb.cs680.hw08_optional.FatFile;

public class FatFileTest {
	private static FatDirectory root;
	private static FatDirectory apps;
	private static FatDirectory bin;
	private static FatDirectory home;
	private static FatDirectory pictures;
	private static FatFile x;
	private static FatFile y;
	private static FatFile a;
	private static FatFile b;
	private static FatFile c;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new FatDirectory(null, "root", 0, LocalDateTime.now());
		apps = new FatDirectory(root, "apps", 0, LocalDateTime.now());
		bin = new FatDirectory(root, "bin", 0, LocalDateTime.now());
		home = new FatDirectory(root, "home", 0, LocalDateTime.now());
		pictures = new FatDirectory(home, "pictures", 0, LocalDateTime.now());
		x = new FatFile(apps, "x", 10, LocalDateTime.now());
		y = new FatFile(bin, "y", 20, LocalDateTime.now());
		a = new FatFile(pictures, "a", 30, LocalDateTime.now());
		b = new FatFile(pictures, "b", 40, LocalDateTime.now());
		c = new FatFile(home, "c", 50, LocalDateTime.now());
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		pictures.appendChild(a);
		pictures.appendChild(b);
	}
	
	private String[] fileToStringArray(FatFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), String.valueOf(f.getSize()),
						String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void verifyFileEqualityX() {
		String[] expected = { "true", "x", "10", String.valueOf(x.getCreationTime()), "apps" };
		FatFile actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileEqualityA() {
		String[] expected = { "true", "a", "30", String.valueOf(a.getCreationTime()), "pictures" };
		FatFile actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirectoyTestingWithB() {
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void isFileTestingWithB() {
		assertTrue(b.isFile());
	}

}
