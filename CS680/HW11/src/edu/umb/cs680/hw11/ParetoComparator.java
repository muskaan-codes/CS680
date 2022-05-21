package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{

	public int compare(Car carOne, Car carTwo) {
		return carOne.getDominationCount() - carTwo.getDominationCount();
	}

}
