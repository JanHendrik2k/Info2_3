package prak3;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class Umrandungsbot extends AdvancedRobot {

	int richtung = 1;

	/**
	 * Startet das Programm
	 * richtet die Waffe korrekt aus
	 * richtet den Panzer korrekt aus
	 * in der While Schleife faehrt der Panzer dauerhaft in die ein oder andere Richtung
	 */
	@Override
	public void run() {
		turnGunRight(90);
		turnLeft(getHeading() % 90);
		while (true) {
			setAhead(richtung * 5);
			execute();
		}
	}

	/**
	 * Wenn Roboter gescannt wird: pew pew!
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}

	/**
	 * Wenn der Roboter die Wand beruehrt: 90 Grad Drehung
	 */
	@Override
	public void onHitWall(HitWallEvent event) {
		turnRight(richtung * 90);
	}

	/**
	 * Wenn der Roboter getroffen wurde: aender Richtung
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		richtung = richtung * (-1);
	}

}
