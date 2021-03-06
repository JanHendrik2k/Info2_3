package prak3;

import java.awt.Color;
import java.awt.event.KeyEvent;
import robocode.AdvancedRobot;
import robocode.WinEvent;

/**
 * Roboter, welcher mit W, A, S, D, SPACE gesteuert werden kann.
 * @author Jan Hendrik
 *
 */
public class Tastaturbot extends AdvancedRobot {

	int drehrichtung = 0;
	int fahrtrichtung = 0;
	int farbschema = 1;

	/**
	 * Starte das Programm und setzt die Geschwindigkeit und Drehung in einer Dauerschleife
	 */
	@Override
	public void run() {

		while (true) {
			if (farbschema == 1) {
				setColors(Color.BLACK, Color.RED, Color.YELLOW, Color.GREEN, Color.RED);
				
			}
			
			if (farbschema == -1) {
				setColors(Color.WHITE, Color.BLUE, Color.GRAY, Color.BLUE, Color.RED);
			}

			// Wie schnell der Roboter fahren soll
			setAhead(10 * fahrtrichtung);

			// Wie schnell sich der Roboter drehen soll
			setTurnRight(45 * drehrichtung);
			execute();
			farbschema = farbschema*(-1);
		}

	}

	/**
	 * Was passiert wenn ein Key gedrueckt wird
	 */
	@Override
	public void onKeyPressed(KeyEvent e) {
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
			fire(1000);
			break;
		default:
			break;
		}

	}

	/**
	 * Was passiert wenn ein Key losgelassen wird
	 */
	@Override
	public void onKeyReleased(KeyEvent e) {
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
