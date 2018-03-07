
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
 * Using the acm.graphics library, draw the national flag of Azerbaijan.
 * No need to draw the star, instead you may draw a white rectangle.
 * The half-moon must be drawn! Note that, the flag must the entire app window!
 */

public class Task1_flag extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private static final Color AZ_BLUE = new Color(0, 181, 226);
	private static final Color AZ_RED = new Color(239, 51, 64);
	private static final Color AZ_GREEN = new Color(80, 158, 47);

	public void run() {

		//Because there are too many function calls otherwise
		final double WIDTH = getWidth();
		final double HEIGHT = getHeight() / 3;
		GRect blueRect = new GRect(0, 0, WIDTH, HEIGHT);
		GRect redRect = new GRect(0, HEIGHT, WIDTH, HEIGHT);
		GRect greenRect = new GRect(0, HEIGHT * 2, WIDTH, HEIGHT);
		GOval outerMoon = new GOval(HEIGHT * 0.95, HEIGHT * 0.95);
		GOval innerMoon = new GOval(HEIGHT * 0.8, HEIGHT * 0.8);
		GRect pseudoStar = new GRect(HEIGHT / 4, HEIGHT / 4);

		// Set the objects filled
		blueRect.setFilled(true);
		redRect.setFilled(true);
		greenRect.setFilled(true);
		outerMoon.setFilled(true);
		innerMoon.setFilled(true);
		pseudoStar.setFilled(true);

		// Fill the objects with colors
		outerMoon.setFillColor(Color.WHITE);

		// Remove borders
		blueRect.setColor(AZ_BLUE);
		redRect.setColor(AZ_RED);
		blueRect.setColor(AZ_BLUE);
		greenRect.setColor(AZ_GREEN);
		innerMoon.setColor(AZ_RED);
		outerMoon.setColor(AZ_RED);
		pseudoStar.setColor(Color.WHITE);

		outerMoon.setLocation(
				(WIDTH / 2) - (outerMoon.getWidth() / 2),
				((HEIGHT * 3) / 2) - (outerMoon.getHeight() / 2)
		);
		innerMoon.setLocation(
				(WIDTH / 2) - (innerMoon.getWidth() / 2),
				((HEIGHT * 3) / 2) - (innerMoon.getHeight() / 2)
		);
		innerMoon.move(
				((outerMoon.getHeight() - innerMoon.getHeight()) / 2),
				0
		);
		pseudoStar.setLocation(
				(WIDTH / 2) - (pseudoStar.getWidth() / 2),
				((HEIGHT * 3) / 2) - (pseudoStar.getHeight() / 2)
		);
		pseudoStar.move(outerMoon.getWidth() / 2, 0);

		// Add to screen
		add(blueRect);
		add(redRect);
		add(greenRect);
		add(outerMoon);
		add(innerMoon);
		add(pseudoStar);
	}

	public static void main(String[] args) {
		new Task1_flag().start();
	}
}