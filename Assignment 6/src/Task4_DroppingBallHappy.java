
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
 * Remember the “DroppingBall.java” that we discussed in class? Recall the issue with 
 * the ball landing on the ground. Your job is to modify the existing code in such a way 
 * that the ball actually sits on the ground properly (shown in the pic in PDF). 
 */

public class Task4_DroppingBallHappy extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
	/* The initial x velocity of the ball. */
	private static final double INITIAL_SPEED = 5.0;

	/* Gravitational acceleration. */
	private static final double GRAVITY = 0.5;

	/* How long to pause between frames. */
	private static final int PAUSE_TIME = 50;

	public void run() {
		waitForClick();
		GOval ball = createBall();
		add(ball);
		moveBall(ball);
	}

	/**
	 * Creates the ball that will fall.
	 *
	 * @return The ball that falls.
	 */
	private GOval createBall() {
		GOval ball = new GOval(0, 0, 50, 50);
		ball.setFilled(true);
		ball.setColor(Color.BLUE);
		return ball;
	}

	/**
	 * Simulates the given ball falling.
	 *
	 * @param ball The ball to drop.
	 */
	private void moveBall(GOval ball) {
		double dx = INITIAL_SPEED;
		double dy = 0;

		/* While the ball hasn't yet hit the ground, keep pulling it down. */
		while (ballAboveGround(ball)) {
			ball.move(dx, dy);
			if (isEnoughDistance(ball)) {
				dy += GRAVITY;
				pause(PAUSE_TIME);
			} else {
				dy = getHeight() - ball.getY() - ball.getHeight();
				ball.move(dx, dy);
				break;
			}
		}
	}

	/**
	 * Returns whether the ball is still above ground.
	 *
	 * @param ball The ball to check.
	 * @return Whether that ball is above ground.
	 */
	private boolean ballAboveGround(GOval ball) {
		return (ball.getY() + ball.getHeight()) < getHeight();
	}
	private boolean isEnoughDistance(GOval ball) {
		return (ball.getY() + ball.getHeight() + GRAVITY <= getHeight());
	}

	// Do not delete this:
	public static void main(String[] args) {
		new Task4_DroppingBallHappy().start();
	}

}
