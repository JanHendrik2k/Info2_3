package prak3;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class Kollisionsbot extends AdvancedRobot {
	
	@Override
	public void run() {
		
		while (true) {
			setTurnRight(45);
			execute();
			}
		
	}
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		setTurnRight(0);
		ahead(5);
		fire(1);
	}

}
