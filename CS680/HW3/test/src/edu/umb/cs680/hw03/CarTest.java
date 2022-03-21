package edu.umb.cs680.hw3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car car) {
        String[] carStringArray = new String[3];
        carStringArray[0] = car.getMake();
        carStringArray[1] = car.getModel();
        carStringArray[2] = car.getYear() + "";
        return carStringArray;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"XYZ", "ABC", "2022"};
        Car actual = new Car("XYZ", "ABC", 2022);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    @Test
    public void verifyDodgeEqualityWithMakeModelYear() {
        String[] expected = {"1234", "789", "2000"};
        Car actual = new Car("1234", "789", 2020);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    @Test
    public void negative()
    {  /* negative test */
        try {
            Car actual = new Car(789, 1234, 2020);
        }
        catch(Exception e) {
            assertEquals("Wrong input values:" ,e.getMessage());
        }
    }


}
