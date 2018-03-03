


import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class Task2_train extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	
	// NUM_OF_BOXCARS

	public void run() {
		// You fill in here
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
