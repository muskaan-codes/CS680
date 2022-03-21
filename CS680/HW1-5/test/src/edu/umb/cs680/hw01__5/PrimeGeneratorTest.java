package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

    @Test
    public void onetoten()
    { /* positive test */
        PrimeGenerator gen = new PrimeGenerator(1,10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );
    }

    @Test
    public void negtopos()
    {  /* negative test */
        try {
            PrimeGenerator gen = new PrimeGenerator(-5,5);
        }
        catch(Exception e) {
            assertEquals("Wrong input values: from=-5 to=5" ,e.getMessage());
        }
    }

    @Test
    public void zero()
    {  /* negative test */
        try {
            PrimeGenerator gen = new PrimeGenerator(0,0);
        }
        catch(Exception e) {
            assertEquals("Wrong input values: from=0 to=0" ,e.getMessage());
        }
    }
}

