package edu.umb.cs680.hw08_optional;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08_optional.FAT;
import edu.umb.cs680.hw08_optional.FSElement;

public class FATTest {

	@Test
	public void getFileSystemReturnNonNullValue() {
		assertNotNull(FAT.getFat());
	}

	@Test
	public void getFileSystemReturnIdenticalInstance() {
		FAT f1 = FAT.getFat();
		FAT f2 = FAT.getFat();
		assertSame(f1, f2);
	}
	
	@Test
	public void initMethodAndGetRootDirTesting() {
		FAT fat = FAT.getFat();
		FSElement expected = fat.init("fat", 1000);
		FSElement actual = fat.getRootDirs().get(0);
		assertSame(expected, actual);
	}

}
