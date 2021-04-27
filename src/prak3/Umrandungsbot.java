package prak3;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Umrandungsbot extends AdvancedRobot {

	int richtung = 1;

	@Override
	public void run() {
		turnLeft(getHeading() % 90);
		while (true) {
			ahead(4);
		}

	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		turnRight(richtung * 90);
	}

	@Override
	public void onHitByBullet(HitByBulletEvent event) {

		if (richtung == -1) {
			turnLeft(180);
			richtung = 1;
		} else if (richtung == 1) {
			turnRight(180);
			richtung = -1;
		}
	}

}
