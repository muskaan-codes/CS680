package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw2.Singleton;



public class SingletonTesting{

    @Test
    public void verifyGetInstanceforNonNull() {
        assertNotNull(Singleton.getInstance());
    }

    @Test
    public void verifyGetInstanceforSimilar() {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        assertSame(a,b);
    }

}