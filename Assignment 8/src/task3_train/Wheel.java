package task3_train;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import java.util.ArrayList;

public class Wheel extends GCompound {
	private GOval wheel;
	GStar wheelCenterThingy;

	public Wheel (double radius) {
		wheel = new GOval(2 * radius, 2 * radius);
		wheelCenterThingy = new GStar(20);

		wheel.setFilled(true);
		wheel.setColor(Color.GREEN);
		wheelCenterThingy.setFilled(true);
		wheelCenterThingy.setColor(Color.RED);
		add(wheel);
		add(wheelCenterThingy, wheel.getX() + radius, wheel.getY() + radius);
	}

	public static void rotateWheel(double degree) {
		for (int i = 0; i < TrainCar.WheelList.size(); i++) {
			TrainCar.WheelList.get(i).wheelCenterThingy.rotate(degree);
		}
	}

}