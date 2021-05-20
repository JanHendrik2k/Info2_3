package prak3;

import java.awt.event.KeyEvent;

import robocode.AdvancedRobot;
import robocode.Event;
import robocode.ScannedRobotEvent;

public class TastaturBotStrategy implements Strategy {

	int drehrichtung = 0;
	int fahrtrichtung = 0;
	int farbschema = 1;
	AdvancedRobot ar;
	
	public void identify(AdvancedRobot r) {
		ar = r;
	}

	public void move() {
			// Wie schnell der Roboter fahren soll
			ar.setAhead(10 * fahrtrichtung);

			// Wie schnell sich der Roboter drehen soll
			ar.setTurnRight(45 * drehrichtung);
			ar.execute();
			farbschema = farbschema * (-1);
		}


	public void reactEvent(Event e) {
		return;
	}

	public void reactOnKeyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {

		// W oder K: Fahrtrichtung nach vorne einstellen
		case KeyEvent.VK_W:
		case KeyEvent.VK_K:
			fahrtrichtung = 1;
			break;

		// S oder L: Fahrtrichtung nach rechts einstellen
		case KeyEvent.VK_S:
		case KeyEvent.VK_L:
			fahrtrichtung = -1;
			break;

		// A oder H: Drehrichtung nach links einstellen
		case KeyEvent.VK_A:
		case KeyEvent.VK_H:
			drehrichtung = -1;
			break;

		// D oder J: Drehrichtung nach rechts einstellen
		case KeyEvent.VK_D:
		case KeyEvent.VK_J:
			drehrichtung = 1;
			break;

		// SPACE: feuer, peng peng
		case KeyEvent.VK_SPACE:
			ar.fire(1000);
			break;
		default:
			break;
		}

		

	}
	
	public void reactOnKeyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		// W oder K: Fahrtrichtung resetten
		case KeyEvent.VK_W:
		case KeyEvent.VK_K:
			fahrtrichtung = 0;
			break;

		// S oder L: Fahrtrichtung resetten
		case KeyEvent.VK_S:
		case KeyEvent.VK_L:
			fahrtrichtung = 0;
			break;

		// A oder H: Drehrichtung resetten
		case KeyEvent.VK_A:
		case KeyEvent.VK_H:
			drehrichtung = 0;
			break;

		// D oder J: Drehrichtung resetten
		case KeyEvent.VK_D:
		case KeyEvent.VK_J:
			drehrichtung = 0;
			break;
		default:
			break;
		}
		
	}

	public void fire(ScannedRobotEvent e) {
		return;
	}

}
