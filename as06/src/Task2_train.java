


import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class Task2_train extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	private static final int NUM_OF_BOXCARS = 6;

	public void run() {

		// Coordinates
		double x = 50;
		double y = 50;
		GRect[] car = new GRect[NUM_OF_BOXCARS];
		GLine[] connector = new GLine[(NUM_OF_BOXCARS - 1) * 2];
		GRect[] window = new GRect[NUM_OF_BOXCARS];

		// Add stuff
		for (int i = 0; i < NUM_OF_BOXCARS; i++) {

			// Cars
			car[i] = new GRect(CAR_WIDTH, CAR_HEIGHT);
			car[i].setFilled(true);
			car[i].setColor(Color.MAGENTA);
			add(car[i]);
			car[i].setLocation(x, y);
			x = x + car[i].getWidth() + CONNECTOR;

			// Connector
			connector[i] = new GLine(
					x + CAR_WIDTH,
					y + CAR_HEIGHT,
					x + CAR_WIDTH + CONNECTOR,
					y + CAR_HEIGHT
			);
			add(connector[i]);

			// Windows
			window[i] = new GRect(DOOR_WIDTH, DOOR_HEIGHT);
			add(
					window[i],
					(car[i].getX() +((car[i].getWidth() - DOOR_WIDTH) / 4)),
					car[i].getY() + (car[i].getHeight() - DOOR_HEIGHT)
			);
		}
	}


	public static void main(String[] args) {
		new Task2_train().start();
	}

	/* Private constants */

	/* Dimensions of the frame of a train car */
	private static final double CAR_WIDTH = 75;
	private static final double CAR_HEIGHT = 36;

	/* Distance from the bottom of a train car to the track below it */
	private static final double CAR_BASELINE = 10;

	/* Width of the connector, which overlaps between successive cars */
	private static final double CONNECTOR = 6;

	/* Radius of the wheels on each car */
	private static final double WHEEL_RADIUS = 8;

	/* Distance from the edge of the frame to the center of the wheel */
	private static final double WHEEL_INSET = 16;

	/* Dimensions of the cab on the engine */
	private static final double CAB_WIDTH = 35;
	private static final double CAB_HEIGHT = 8;

	/* Dimensions of the smokestack and its distance from the front */
	private static final double SMOKESTACK_WIDTH = 8;
	private static final double SMOKESTACK_HEIGHT = 8;
	private static final double SMOKESTACK_INSET = 8;

	/* Dimensions of the door panels on the boxcar */
	private static final double DOOR_WIDTH = 18;
	private static final double DOOR_HEIGHT = 32;

	/* Dimensions of the cupola on the caboose */
	private static final double CUPOLA_WIDTH = 35;
	private static final double CUPOLA_HEIGHT = 8;

}





