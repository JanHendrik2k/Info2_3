package prak3;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class Kollisionsbot extends AdvancedRobot {
	
	/**
	 * Rennt das Programm runter
	 * 
	 */
	@Override
	public void run() {
		//Dreh dich dauerhaft :)
		while (true) {
			setTurnRight(10);
			execute();
			}
		
	}
	/**
	 * Wenn ein Roboter gescannt wurde, beende die Drehung fahre nach vorne und schieﬂ.
	 */
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		setTurnRight(0);
		ahead(5);
		fire(1);
	}

}
