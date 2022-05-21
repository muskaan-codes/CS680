package edu.umb.cs680.hw08_optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08_optional.FatDirectory;
import edu.umb.cs680.hw08_optional.FatFile;

public class FatDirectoryTest {
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

	private String[] dirToStringArray(FatDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
							String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "root", "150", String.valueOf(root.getCreationTime()), "3" };
		FatDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "home", "120", String.valueOf(home.getCreationTime()), "2" };
		FatDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectoyTestingWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileTestingWithRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void appendChildrenTestingWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenTestingWithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void countChildrenTestingWithRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenTestingWithHome() {
		assertSame(2, home.countChildren());
	}
	
	@Test
	public void getSubDirectoriesTestingWithRoot() {
		FatDirectory[] expected = new FatDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		FatDirectory[] actual = new FatDirectory[3];
		LinkedList<FatDirectory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesTestingWithHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void getFilesTestingWithHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void getFilesTestingWithPictures() {
		FatFile[] expected = new FatFile[2];
		expected[0] = a;
		expected[1] = b;
		FatFile[] actual = new FatFile[2];
		LinkedList<FatFile> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getTotalSizeTestingWithRoot() {
		assertEquals(150, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeTestingWithHome() {
		assertEquals(120, home.getTotalSize());
	}

}
