package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsFSElement>{

	public int compare(ApfsFSElement a1, ApfsFSElement a2) {
		return a1.getName().compareTo(a2.getName());
	}

}
