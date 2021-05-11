package prak3;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

/**
 * Ein Roboter, welcher das Spielfeld auﬂen am Rand umrandet. Wenn er getroffen wird, ‰ndert er die Richtung um 180 Grad.
 * Wenn ein Freind im Visier ist, schieﬂt der Roboter automatisch.
 * @author Jan Hendrik
 *
 */
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
		setColors(Color.YELLOW, Color.GREEN, Color.PINK, Color.BLUE, Color.WHITE);
		turnGunRight(90);
		turnLeft(getHeading() % 90);
		while (true) {
			setAhead(richtung * 10);
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
	 * Wenn der Roboter getroffen wurde: aendere Richtung um 180 Grad
	 */
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		richtung = richtung * (-1);
	}
	
	/**
	 * Fortnite Dance, wenn man gewonnen hat
	 */
	@Override
	public void onWin(WinEvent event) {
			setColors(Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN);
		for (int i = 0; i < 50; i++) {
			turnLeft(50);
			turnRight(50);
		}
	}
	

}
