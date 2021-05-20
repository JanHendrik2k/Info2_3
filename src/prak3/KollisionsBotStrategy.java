package prak3;

import java.awt.event.KeyEvent;

import robocode.AdvancedRobot;
import robocode.Event;
import robocode.ScannedRobotEvent;

public class KollisionsBotStrategy implements Strategy {

	AdvancedRobot ar;
	boolean isLeft = true;
	static final int SPEED = 10;
	
	public void identify(AdvancedRobot r) {
		ar = r;
	}

	public void move() {

			if (isLeft) {
				ar.setTurnLeft(SPEED);

			} else {

				ar.setTurnRight(SPEED);
			}
			ar.execute();
		}

	public void reactEvent(Event e) {
		return;

	}

	public void reactOnKeyPressed(KeyEvent e) {
		return;

	}

	public void reactOnKeyReleased(KeyEvent e) {
		return;
		
	}
	public void fire(ScannedRobotEvent e) {
		if (e.getBearing() < 0) {
			isLeft = true;
		} else {
			isLeft = false;
		}
		ar.ahead(SPEED);
		ar.fire(1);

	}


}
