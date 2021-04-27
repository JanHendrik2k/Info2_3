package prak3;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Umrandungsbot extends AdvancedRobot {

	int richtung = 1;

	@Override
	public void run() {
		turnGunRight(90);
		turnLeft(getHeading() % 90);
		while (true) {
			setAhead(richtung * 5);
			execute();
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
		richtung = richtung * (-1);
	}

}
