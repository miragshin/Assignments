import acm.graphics.*;

import java.awt.*;

import acm.program.*;

import java.util.Random;

public class Background extends GCompound {
	public static final int AMOUNT_OF_SQUARES = 50;
	public static final int GROUND_SQUARE_WIDTH = 32;
	public static final double GROUND_SQUARE_RATIO = 0.75;
	public static final int AMOUNT_OF_CLOUDS = 15;
	private static double WIDTH;
	private static double HEIGHT;

	public Background(double WIDTH, double HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		for (int i = 0; i <= AMOUNT_OF_SQUARES; i++) {
			add(new GImage(
					"Images/Background/Ground2.gif",
					i * GROUND_SQUARE_WIDTH,
					HEIGHT * GROUND_SQUARE_RATIO
			));
		}

		/* Adds clouds */
		Random random = new Random();
		int randomY;
		for (int i = 0; i < AMOUNT_OF_CLOUDS; i++) {
			randomY = random.nextInt((int)(HEIGHT * GROUND_SQUARE_RATIO - 120));
			add(new GImage(
					"Images/Background/Cloud - Triple.gif",
					i * 280,
					randomY

			));
		}
	}


	public static double getStartY() {
		return HEIGHT * GROUND_SQUARE_RATIO;
	}
}