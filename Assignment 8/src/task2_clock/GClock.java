package task2_clock;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.time.LocalDateTime;

/*
 * Using the acm.graphics library, draw an analog clock in the center of the window.
 * The clock should have numbers labeled on it and only two hands (hour and min).
 * No need for hand showing seconds.
(P.S. The thickness of the circle is to be considered, as well! But thickness of hands to
be ignored.)

 */

public class GClock extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private static final double RATIO = 0.95; // Determines thickness of the circle
	public static LocalDateTime date = LocalDateTime.now();
	public static long hour = date.getHour();
	public static long minute = date.getMinute();
	public static long second = date.getSecond();
	static long milliseconds = hour * 60 * 60 + minute * 60 + second;


	/* Optional constructor for user-entered time */
	public GClock(long second, long minute, long hour) {
		this.second = second;
		this.minute = minute;
		this.hour = hour;
	}

	/* Constructor with no arguments */
	public GClock() {}

	public void run() {

		double DIAMETER;
		/* For screen size */
		if (getHeight() > getWidth()) {
			DIAMETER = getWidth();
		} else {
			DIAMETER = getWidth();
		}

		GOval outer = new GOval(getHeight(), getHeight());
		GOval inner = new GOval(getHeight() * RATIO, getHeight() * RATIO);
		GOval center = new GOval(getHeight() / 9, getHeight() / 9);
		double x = outer.getWidth() / 2;
		double y = outer.getHeight() / 2;
		double x1 = 0;
		double y2 = 50;
		GLine secondHand = new GLine(x, y, x, y2);
		GLine minuteHand = new GLine(x, y, x, y2 * 1.6);
		GLine hourHand = new GLine(x, y, (x - (y2 - y + 50)), y);
		secondHand.setColor(Color.BLACK);
		minuteHand.setColor(Color.GREEN);
		hourHand.setColor(Color.RED);

		outer.setFilled(true);
		inner.setFilled(true);
		center.setFilled(true);


		outer.setColor(Color.RED);
		inner.setColor(Color.WHITE);
		center.setColor(Color.RED);

		add(outer);
		add(
				inner,
				(getHeight() - inner.getHeight()) / 2,
				(getHeight() - inner.getHeight()) / 2
		);
		add(
				center,
				(getHeight() - center.getHeight()) / 2,
				(getHeight() - center.getHeight()) / 2
		);
		add(hourHand);
		add(minuteHand);
		add(secondHand);
		for (int i = 1; i <= 12; i++) {

			String str = Integer.toString(i);
			GLabel time = new GLabel(str);

			time.setColor(Color.black);
			time.setFont("Georgia-bold-32");

			double dx = Math.cos((i * 30) * Math.PI / 180);
			double dy = Math.sin((i * 30) * Math.PI / 180);
			double clockWidth = outer.getWidth() / 2;
			double clockHeight = outer.getHeight() / 2;
			double radius = DIAMETER / 2 + 48;
			add(time, clockWidth + dy * (radius - 50) / 2 - time.getWidth() / 2,
					clockHeight - dx * (radius - 50) / 2 + time.getHeight() / 2);
		}

		for (long i = milliseconds; i >= 0; i++) {
			double dx = Math.cos((i * 6) * Math.PI / 180);
			double dy = Math.sin((i * 6) * Math.PI / 180);

			double dx1 = Math.cos((i * 1 / 10) * Math.PI / 180);
			double dy1 = Math.sin((i * 1 / 10) * Math.PI / 180);

			double dx2 = Math.cos((i * 1 / 120) * Math.PI / 180);
			double dy2 = Math.sin((i * 1 / 120) * Math.PI / 180);

			secondHand.setEndPoint(outer.getWidth() / 2 + dy * 175, outer.getHeight() / 2 - dx * 175);
			minuteHand.setEndPoint(outer.getWidth() / 2 + dy1 * 175, outer.getHeight() / 2 - dx1 * 175);
			hourHand.setEndPoint(outer.getWidth() / 2 + dy2 * 175, outer.getHeight() / 2 - dx2 * 175);
			pause(1000);
		}
	}


	public static void main(String[] args) {
		new GClock().start();
	}
}











