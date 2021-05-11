package prak3;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

/**
 * OP Roboter mit Aimbot, da es kein Anti cheat in Robocode gibt
 * @author Jan Hendrik
 *
 */
public class Kollisionsbot extends AdvancedRobot {
	
	boolean isLeft = true;
	static final int SPEED = 10;
	
	/**
	 * Rennt das Programm runter
	 * 
	 */
	@Override
	public void run() {
		//Dreh dich dauerhaft :)
		setColors(Color.BLACK, Color.RED, Color.YELLOW, Color.PINK, Color.RED);
		while (true) {
			
			if (isLeft) {
				setTurnLeft(SPEED);
				
			}else {
				
				setTurnRight(SPEED);
			}
			execute();
			}
		
	}
	/**
	 * Wenn ein Roboter gescannt wurde, beende die Drehung fahre nach vorne und schieﬂ.
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		if (event.getBearing() < 0) {
			isLeft = true;
		} else {
			isLeft = false;
		}
		ahead(SPEED);
		fire(1);
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
