import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

public class MarioMap extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	private GImage marioModel;

	private String marioState;

	private boolean keyDown;

	private static final double INITIAL_SPEED = 5.0;

	private static final int PAUSE_TIME = 1000 / 48;

	private static final double GRAVITY = 0.5;

	private static boolean falling;

	private static boolean jumping;

	static int cnt = 0;

	private double fallThreshold = 520;

	public void init() {

		addKeyListeners();
	}

	public void run() {

		setBackground(Color.BLUE);
		add(new GImage("Images/Bush - Triple.gif"), 100, 420);
		marioModel = new GImage("Images/mario.png");
		marioModel.scale(2, 2);
		add(marioModel, 0, 420);

		for (int i = 0; i < 20; i++) {
			GImage groundImage = new GImage("Images/mario.png");
			add(groundImage, 25 * i, 450);
		}
		

		while (true) {
			marioFalling(fallThreshold);
		}

	}

	public void marioJumpFalling(double edge) {
		double dy = 0;
		while (marioModel.getY() < edge) {
			dy += GRAVITY;
			marioModel.move(0, dy);
			pause(15);
		}
	}

	public void getNearestGround(GImage image) {
		GPoint marioPoint = new GPoint(image.getX(), image.getY() + 10);
	}

	public void marioFalling(double edge) {
		GPoint marioPoint = new GPoint(marioModel.getX(), marioModel.getY() + 50);
		if (getElementAt(marioPoint) == null) {
			falling = true;
			double dy = 0;
			while (marioModel.getY() < edge) {
				dy += GRAVITY;
				marioModel.move(0.1, dy);
				pause(15);
			}
		}
	}

	public void makeMarioJump(double edge) {
		double dy = 3;
		jumping = true;
		while (marioModel.getY() > edge) {
			dy -= GRAVITY;
			marioModel.move(0, -dy);
			pause(15);
		}
		if (marioModel.getY() == edge) {
			marioJumpFalling(420);
		}
	}

	// THIS IS A GAME OVER CONDITION REMEMBER THIS//
	public boolean didMarioFall() {
		if (marioModel.getY() >= 520)
			return true;
		return false;
	}

	/*
	 * Things you have to implement: 1)Not being able to go out of the screen
	 * 2)Actions.Jumping 3)Music and sounds effects 4)Falling and landing on objects
	 * 5)Moving the camera
	 */

	/*
	 * You figured out the idea but still have to implement gravity and smooth
	 * falling
	 */

	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			marioModel.setImage("Images/mario.png");
			System.out.println("I'm going up");
			marioModel.scale(2, 2);
			marioState = "standing";
			makeMarioJump(400);
			System.out.println(marioModel.getBounds());
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("I'm going down");
			marioState = "crouching";
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("<---");
			marioModel.setImage("Images/mario.png");
			marioModel.move(-10, 0);
			marioState = "left";
			cnt++;
			System.out.println(marioModel.getBounds());
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("--->");
			marioModel.setImage("Images/mario.png");
			marioModel.move(10, 0);
			marioState = "right";
			cnt++;
			System.out.println(marioModel.getBounds());
			break;
		default:
			System.out.println("Gotta figure this out");
			marioModel.setImage("Images/mario.png");
			marioModel.scale(2, 2);
			marioState = "standing";
			break;

		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			marioModel.setImage("Images/mario.png");
			marioModel.scale(2, 2);
			break;
		case KeyEvent.VK_DOWN:
			marioModel.setImage("Images/mario.png");
			marioModel.scale(2, 2);
			break;
		case KeyEvent.VK_LEFT:
			marioModel.setImage("Images/mario.png");
			marioModel.scale(2, 2);
			break;
		case KeyEvent.VK_RIGHT:
			marioModel.setImage("Images/mario.png");
			marioModel.scale(2, 2);
		}
	}

	public static void main(String[] args) {
		new MarioMap().start();
	}

	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 500;
}
