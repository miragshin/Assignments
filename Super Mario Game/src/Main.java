import acm.graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import acm.program.*;

public class Main extends GraphicsProgram {

	private static Background background;
	public static Mario character;
	private static double WIDTH;
	private static double HEIGHT;
	private final static double SPEED = 10;
	private final static double GRAVITY = 0.5;
	private static double characterX;
	private static boolean isJumping = false;

	public void run() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		setBackground(new Color(84, 208, 249));
		background = new Background(WIDTH, HEIGHT);
		character = new Mario();
		add(background);
		add(character, 0, Background.getStartY() - character.getHeight());
		while (true) {
			characterX = character.getX();
			System.out.println(characterX);
			if (!isIsOnGround()) {
				fallDown();
			}
			if(isJumping) {
//				jump();
			}
		}
	}


	private static boolean isGameOver() {
		return (character.getY() > HEIGHT);
	}


	public void init() {
		addKeyListeners();
	}

	public void keyPressed(KeyEvent e) {
		if (character != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					character.runForward();
					character.move(SPEED, 0);
					break;
				case KeyEvent.VK_LEFT:
					character.runBackward();
					character.move(-SPEED, 0);
					break;
				case KeyEvent.VK_UP:
					character.jump();
					break;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (character != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					character.standStill();
					break;
				case KeyEvent.VK_LEFT:
					character.standStill();
					break;
				case KeyEvent.VK_UP:
					character.standStill();
					break;
			}
		}
	}

	private void jumpForward() {
		for (int i = 0; i < 60; i++) {
			character.move(0, -1);
		}
	}

	private void fallForward() {
		for (int i = 0; i < 60; i++) {
			character.move(0, 1);
		}
	}

	private void fallDown() {
		double dy = 0;
		while (character.getY() < WIDTH) {
			dy += GRAVITY;
			character.move(0.1, dy);
			pause(15);
		}
	}

	private boolean isIsOnGround() {
		return ((characterX < Background.AMOUNT_OF_SQUARES * Background.GROUND_SQUARE_WIDTH));
	}

	public static Mario getCharacter() {
		return character;
	}

	public static void main(String[] args) {
		new Main().start();
	}
}