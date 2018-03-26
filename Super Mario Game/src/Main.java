import acm.graphics.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import acm.program.*;

public class Main extends GraphicsProgram {

	private static Background background;
	private static Mario character;
	private static double WIDTH;
	private static double HEIGHT;
	private final static double SPEED = 10;

	public void run() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		setBackground(Color.BLUE);
		background = new Background(WIDTH, HEIGHT);
		character = new Mario();
		add(background);
		add(character, 0, Background.getStartY() - character.getHeight());
		while(!isGameOver()) {
//			new Runtime.start();
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
			}
		}
	}

	private static void jumpForward() {
		
	}

	public static Mario getCharacter() {
		return character;
	}

	public static void main(String[] args) {
		new Main().start();
	}
}