
import java.awt.*;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;
import java.util.Random;

public class Task2_train extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private static Random rand = new Random();

	public void run() {
		double x = 0 + CONNECTOR;
		double y = getHeight();
		double dx = CAR_WIDTH + CONNECTOR;

		drawEngine(x, y);
		drawBoxcar(x + dx, y, myColor());
		for (int i = 0, bound = rand.nextInt(21) + 1; i < bound; i++) {
			drawBoxcar(x + dx, y, myColor());
			x = x + CAR_WIDTH + CONNECTOR;
		}
		drawCaboose(x + dx, y);
	}

	/* Draws an engine whose origin is at (x, y) */
	private void drawEngine(double x, double y) {
		drawCarFrame(x, y, Color.BLACK);
		drawSmokestack(x, y);
		drawEngineCab(x, y);
		drawCowcatcher(x, y);
	}

	/* Draws the smokestack */
	private void drawSmokestack(double x, double y) {
		double x0 = x + SMOKESTACK_INSET + SMOKESTACK_WIDTH;
		double y0 = y - (CAR_BASELINE + CAR_HEIGHT + SMOKESTACK_HEIGHT);
		GRect rect = new GRect(x0, y0, SMOKESTACK_WIDTH, SMOKESTACK_HEIGHT);
		rect.setFilled(true);
		add(rect);
	}

	/* Draws the engine cab */
	private void drawEngineCab(double x, double y) {
		double x0 = x + CONNECTOR + CAR_WIDTH - CAB_WIDTH;
		double y0 = y - (CAR_BASELINE + CAR_HEIGHT + CAB_HEIGHT);
		GRect rect = new GRect(x0, y0, CAB_WIDTH, CAB_HEIGHT);
		rect.setFilled(true);
		add(rect);
	}

	/* Draws the cowcatcher in the front of the engine */
	private void drawCowcatcher(double x, double y) {
		double x0 = x;
		double y0 = y - CAR_BASELINE;
		double x1 = x + CONNECTOR;
		double y1 = y - (CAR_BASELINE + CAR_HEIGHT/2);

		GLine line = new GLine(x0, y0, x1, y1);
		add(line);
	}

	/* Draws a boxcar in the specified color */
	private void drawBoxcar(double x, double y, Color color) {
		drawCarFrame(x, y, color);
		double xRight = x + CONNECTOR + CAR_WIDTH / 2;
		double xLeft = xRight - DOOR_WIDTH;
		double yDoor = y - CAR_BASELINE - DOOR_HEIGHT;
		add(new GRect(xLeft, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
		add(new GRect(xRight, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
	}

	/* Draws a red caboose */
	private void drawCaboose(double x, double y) {
		drawCarFrame(x, y, Color.RED);
		drawCabooseCupola(x, y, Color.RED);
	}

	/* Draws the caboose's cupola */
	private void drawCabooseCupola(double x, double y, Color color) {
		x = x + CONNECTOR + (CAR_WIDTH - CUPOLA_WIDTH) / 2;
		y = y - (CAR_BASELINE + CAR_HEIGHT + CUPOLA_HEIGHT);
		GRect rect = new GRect(x, y, CUPOLA_WIDTH, CUPOLA_HEIGHT);
		rect.setFilled(true);
		rect.setFillColor(color);
		add(rect);
	}

	/* Draws the common part of a train car */
	private void drawCarFrame(double x, double y, Color color) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		r.setFilled(true);
		r.setFillColor(color);
		add(r);
	}

	/* Draws a wheel centered at (x, y) */
	private void drawWheel(double x, double y) {
		double r = WHEEL_RADIUS;
		GOval wheel = new GOval(x - r, y - r, 2 * r, 2 * r);
		wheel.setFilled(true);
		wheel.setFillColor(Color.GRAY);
		add(wheel);
	}

	private Color myColor() {
		return new Color(
				rand.nextInt(256),
				rand.nextInt(256),
				rand.nextInt(256)
		);
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
