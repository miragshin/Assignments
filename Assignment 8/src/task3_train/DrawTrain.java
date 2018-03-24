package task3_train;

import java.awt.*;

import acm.program.GraphicsProgram;

public class DrawTrain extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	public void run() {
		double xc = getWidth() / 2;
		double x = CONNECTOR + WHEEL_INSET;
		double y = -WHEEL_RADIUS;
		Train train = new Train();
		Wheel wheel = new Wheel(WHEEL_RADIUS);
		train.append(new Engine());
		train.append(new Boxcar(Color.GREEN));
		train.append(new Boxcar(Color.BLUE));
		train.append(new Caboose());
		add(train, xc - train.getWidth() / 2, getHeight());
		add(wheel, 200, 200);
		waitForClick();
		while (train.getX() + train.getWidth() >= 0) {
			train.move(-DELTA_X, 0);
			pause(PAUSE_TIME);
			wheel.rotateWheel(90);
		}
	}

	public static void main(String[] args) {
		new DrawTrain().start();
	}

	/* Private constants */
	private static final double PAUSE_TIME = 20;
	private static final double DELTA_X = 2;
	private static final double WHEEL_RADIUS = 8;

	/* Distance from the edge of the frame to the center of the wheel */
	private static final double WHEEL_INSET = 16;

	public static final double CONNECTOR = 6;
}
