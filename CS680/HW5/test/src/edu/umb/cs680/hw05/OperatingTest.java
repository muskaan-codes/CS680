package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;
import edu.umb.cs680.hw05.Operating;
import edu.umb.cs680.hw05.StandBy;
import edu.umb.cs680.hw05.Stopped;

class OperatingTest {
	private static Escalator e;

	@BeforeAll
	public static void verifySetUpBeforeClass() throws Exception {
		e = Escalator.getInstance();
	}

	@BeforeEach
	public void verifySetUpBeforeEveryTest() throws Exception {
		e.changeState(Operating.getInstance());
	}

	@Test
	public void verifyGetInstanceReturnNonNullValue() {
		assertNotNull(Operating.getInstance());
	}

	@Test
	public void verifyGetInstanceReturnIdenticalInstance() {
		Operating o1 = Operating.getInstance();
		Operating o2 = Operating.getInstance();
		assertSame(o1, o2);
	}

	@Test
	public void verifyStartButtonPushedTesting() {
		e.startButtonPushed();
		assertSame(e.getState(), Operating.getInstance());
	}

	@Test
	public void verifyStopButtonPushedTesting() {
		e.stopButtonPushed();
		assertSame(e.getState(), Stopped.getInstance());
	}

	@Test
	public void verifyMotionDetectedTesting() {
		e.motionDetected();
		assertSame(e.getState(), Operating.getInstance());
	}
}
	
