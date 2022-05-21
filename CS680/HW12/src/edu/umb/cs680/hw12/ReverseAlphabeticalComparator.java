package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsFSElement>{

	public int compare(ApfsFSElement a1, ApfsFSElement a2) {
		return a2.getName().compareTo(a1.getName());
	}

}
