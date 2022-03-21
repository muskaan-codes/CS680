package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;
import edu.umb.cs680.hw05.Operating;
import edu.umb.cs680.hw05.StandBy;
import edu.umb.cs680.hw05.Stopped;

class StandByTest {
	private static Escalator e;

	@BeforeAll
	public static void verifySetUpBeforeClass() throws Exception {
		e = Escalator.getInstance();
	}

	@BeforeEach
	public void verifySetUpBeforeEveryTest() throws Exception {
		e.changeState(StandBy.getInstance());
	}

	@Test
	public void verifyGetInstanceReturnNonNullValue() {
		assertNotNull(StandBy.getInstance());
	}

	@Test
	public void verifyGetInstanceReturnIdenticalInstance() {
		StandBy s1 = StandBy.getInstance();
		StandBy s2 = StandBy.getInstance();
		assertSame(s1, s2);
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

	@Test
	public void verifyMotionNotDetectedTesting() {
		e.motionNotDetected();
		assertSame(e.getState(), StandBy.getInstance());
	}
}