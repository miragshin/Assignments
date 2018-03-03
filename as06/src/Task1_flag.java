
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.program.Program;

import java.awt.*;

/*
 * Using the acm.graphics library, draw the national flag of Azerbaijan.
 * No need to draw the star, instead you may draw a white rectangle.
 * The half-moon must be drawn! Note that, the flag must the entire app window!
 */

public class Task1_flag extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
	private static final Color BLUE = new Color(0, 181, 226);
	private static final Color RED = new Color(239, 51, 64);
	private static final Color GREEN = new Color(80, 158, 47);








	public void run() {
		GRect blueRect = new GRect(0, 0, getWidth(), getHeight() / 3);
		GRect redRect = new GRect(0, getHeight() / 3, getWidth(), getHeight() / 3);
		GRect greenRect = new GRect(0, getHeight() / 1.5, getWidth(), getHeight() / 3);
		GOval outerMoon = new GOval(
				(getWidth() - getWidth() / 3) / 2,
				(getHeight() - getHeight() / 3) / 2,
				getHeight() / 3,
				getHeight() / 3
		);

		GOval innerMoon = new GOval(
				outerMoon.getX(),
				outerMoon.getY(),
				outerMoon.getWidth(),
				outerMoon.getHeight()
		);

		blueRect.setFilled(true);
		redRect.setFilled(true);
		greenRect.setFilled(true);
		outerMoon.setFilled(true);
		innerMoon.setFilled(true);
		blueRect.setFillColor(BLUE);
		redRect.setFillColor(RED);
		greenRect.setFillColor(GREEN);
		outerMoon.setFillColor(Color.WHITE);
		innerMoon.setFillColor(RED);
		blueRect.setColor(BLUE);
		redRect.setColor(RED);
		blueRect.setColor(BLUE);
		innerMoon.setColor(RED);
		add(blueRect);
		add(redRect);
		add(greenRect);
		add(outerMoon);
		add(innerMoon);

	}








	// Do not delete this:
	public static void main(String[] args) {
		new Task1_flag().start();
	}

}
