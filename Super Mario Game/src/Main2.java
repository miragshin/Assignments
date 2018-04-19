import Builders.Character;
import Characters.Madoka;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main2 extends GraphicsProgram {

	public static Character character;
	private static double WIDTH;
	private static double HEIGHT;
	private static double SPEED = 5;
	private final static double GRAVITY = 0.5;
	private static double characterInitialY;
	private static boolean isJumping = false;
	private static boolean RIGHT_KEY_PRESSED = false;
	private static boolean LEFT_KEY_PRESSED = false;
	private static boolean UP_KEY_PRESSED = false;
	private static boolean IS_FAllING = false;
	private static boolean IS_ON_GROUND = true;
	private static boolean IS_ON_AIR = false;
	private static double dy = 0;


	public void run() {
		WIDTH = getWidth();
		HEIGHT = getHeight();

		setBackground(new Color(84, 208, 249));
		add(new Background(WIDTH, HEIGHT));

		GroundChecker groundChecker = new GroundChecker();
		Thread t1 = new Thread(groundChecker);
		t1.start();

		character = new Character();


		character = new Character(Madoka.initiate(character));
//		character = new Character(new Mami().initiate(character));
		add(character, 0, Background.getStartY() - character.getHeight());

		characterInitialY = character.getY();

		while (true) {
			System.out.println("Hi");
			if (RIGHT_KEY_PRESSED) {
				move(SPEED);
				pause(10);
			}
			if (LEFT_KEY_PRESSED) {
				move(-SPEED);
				pause(10);
			}
//			if (!isIsOnGround()) {
//				dy += GRAVITY;
//				character.move(1, dy);
//				pause(10);
//			}
			if (UP_KEY_PRESSED) {
//				jumpForward();
				character.move(0, -10);
				pause(10);
			}

//			if (!isIsOnGround()) {
//				character.move(0, 10);
//				pause(10);
//			}

		}
	}


	public void move(double SPEED) {
		character.move(SPEED, 0);
	}

	public void init() {
		addKeyListeners();
	}

	public void keyPressed(KeyEvent e) {
		if (character != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					character.runForward(character);
					RIGHT_KEY_PRESSED = true;
					break;
				case KeyEvent.VK_LEFT:
					character.runBackward();
					LEFT_KEY_PRESSED = true;
					break;
				case KeyEvent.VK_UP:
					character.jumpForward();
					UP_KEY_PRESSED = true;
					IS_ON_AIR = true;
					break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (character != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					RIGHT_KEY_PRESSED = false;
					character.standStillForward();
					break;
				case KeyEvent.VK_LEFT:
					character.standStillBackward();
					LEFT_KEY_PRESSED = false;
					break;
				case KeyEvent.VK_UP:
					UP_KEY_PRESSED = false;
					break;
			}
		}
	}


	private void jumpForward() {
		double dx = 0;
		for (int i = 0; i < 60; i++) {
			dx += GRAVITY;
			character.move(0, -1);
			pause(10);
		}
		fallDown();
	}

	//
//	private void fallForward() {
//		for (int i = 0; i < 60; i++) {
//			character.move(0, 1);
//		}
//	}
//
	private void fallDown() {
		double dy = 0;
		while (character.getY() < WIDTH) {
			dy += GRAVITY;
			character.move(0.1, dy);
			pause(20);
		}
	}

	private boolean isIsOnGround() {
//		return ((character.getY() < Background.AMOUNT_OF_SQUARES * Background.GROUND_SQUARE_WIDTH));
		return (character.getY() == characterInitialY);
	}

	public static void setIsOnGround(boolean isOnGround) {
		IS_ON_GROUND = isOnGround;
	}

	public static void main(String[] args) {
		new Main2().start();
	}
}