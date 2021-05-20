package prak3;

import java.awt.event.KeyEvent;

import robocode.AdvancedRobot;
import robocode.Event;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class UmrandungsBotStrategy implements Strategy {
	
	int richtung = 1;
	AdvancedRobot ar;

	public void identify(AdvancedRobot r) {
		ar = r;
		ar.turnGunRight(90);
		ar.turnLeft(ar.getHeading() % 90);

	}

	public void move() {
			ar.setAhead(richtung * 10);
			ar.execute();
		}


	public void reactEvent(Event e) {
		if (e instanceof HitWallEvent) {
			ar.turnRight(richtung * 90);			
		}
		if (e instanceof HitByBulletEvent) {
			richtung = richtung * (-1);
		}

	}

	public void reactOnKeyPressed(KeyEvent e) {
		return;

	}
	
	public void reactOnKeyReleased(KeyEvent e) {
		return;
		
	}

	public void fire(ScannedRobotEvent e) {
		ar.fire(1);

	}


}
