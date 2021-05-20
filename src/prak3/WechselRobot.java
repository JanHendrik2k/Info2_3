package prak3;

import robocode.AdvancedRobot;

import java.awt.event.KeyEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.ScannedRobotEvent;

public class WechselRobot extends AdvancedRobot {

	Strategy strategy = null;
	Strategy[] strategies = new Strategy[3];
	int strategyPos = 0;

	public void run() {
		strategies[0] = new KollisionsBotStrategy();
		strategies[0].identify(this);
		strategies[1] = new TastaturBotStrategy();
		strategies[1].identify(this);
		strategies[2] = new UmrandungsBotStrategy();
		//strategies[2].identify(this);
		
		strategy = strategies[0];
		while (true) {
			strategy.move();
		}
	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		out.println("taste " + e.getKeyChar());
		if (e.getKeyChar() == 'c') {
			toggleStrategies();
			out.println("change!");
		} else {
			strategy.reactOnKeyPressed(e);
		}
	}

	public void onHitByBullet(HitByBulletEvent hbbe) {
		strategy.reactEvent(hbbe);
	}

	public void onHitRobot(HitRobotEvent hre) {
		strategy.reactEvent(hre);
	}

	public void onHitWall(HitWallEvent hwe) {
		strategy.reactEvent(hwe);
	}

	public void onScannedRobot(ScannedRobotEvent sre) {
		strategy.fire(sre);
	}
	

	public void onKeyReleased(KeyEvent e) {
		strategy.reactOnKeyReleased(e);
	}

	private synchronized void toggleStrategies() {
		strategyPos += 1;
		
		//My
		if (strategyPos == 2) {
			out.println("Umrandungsbot identify");
			strategies[2].identify(this);
			
		}
		
		if (strategyPos >= strategies.length) {
			//My
			turnGunLeft(90);
			strategyPos = 0;
		}
		out.println("Strategiewechsel auf " + strategyPos);
		strategy = strategies[strategyPos];
	}
}
