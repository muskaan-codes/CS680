package edu.umb.cs680.hw05;

public interface State {

	void motionDetected();
	void motionNotDetected();
	void startButtonPushed();
	void stopButtonPushed();
}