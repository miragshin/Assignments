import acm.graphics.*;

import java.awt.*;

import acm.program.*;

public class Background extends GCompound {
	private static final int AMOUNT_OF_SQUARES = 50;
	private static final int GROUND_SQUARE_WIDTH = 32;
	private static final double GROUND_SQUARE_RATIO = 0.75;
	private double WIDTH;
	private double HEIGHT;

	public Background(double WIDTH, double HEIGHT) {
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;

		for (int i = 0; i <= AMOUNT_OF_SQUARES; i++) {
			add(new GImage(
					"Images/Background/Ground2.gif",
					i * GROUND_SQUARE_WIDTH,
					HEIGHT * GROUND_SQUARE_RATIO)
			);
		}
	}
}