package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<ApfsFSElement>{
	
	private int elementKindToInt(ApfsFSElement a) {
		if (a.isFile()) {
			return 1;
		}else if (a.isDirectory()) {
			return 0;
		}else {
			return 2;
		}
	}
	
	public int compare(ApfsFSElement a1, ApfsFSElement a2) {
		return elementKindToInt(a1) - elementKindToInt(a2);
	}

}
