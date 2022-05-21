package edu.umb.cs680.hw11;

import java.util.Comparator;

public class YearComparator implements Comparator<Car>{

	public int compare(Car carOne, Car carTwo) {
		return carTwo.getYear() - carOne.getYear();
	}

}
