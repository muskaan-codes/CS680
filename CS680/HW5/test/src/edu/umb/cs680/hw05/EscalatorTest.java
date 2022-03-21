package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;

class EscalatorTest {

	@Test
	public void verifyGetInstanceReturnNonNullValue() {
		assertNotNull(Escalator.getInstance());
	}

	@Test
	public void verifyGetInstanceReturnIdenticalInstance() {
		Escalator e1 = Escalator.getInstance();
		Escalator e2 = Escalator.getInstance();
		assertSame(e1, e2);
	}

}