package prak3;

import java.awt.event.KeyEvent;
import robocode.AdvancedRobot;
import robocode.Event;
import robocode.ScannedRobotEvent;

public interface Strategy {
	void identify(AdvancedRobot r);

	void move();

	void reactEvent(Event e);

	void reactOnKeyPressed(KeyEvent e);

	void reactOnKeyReleased(KeyEvent e);

	void fire(ScannedRobotEvent e);

}
