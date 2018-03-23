package task1_triangle;

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class RoundTriangle extends GCompound {


	public RoundTriangle(double side) {
		double height = side / 2 * Math.sqrt(3);
		GPolygon triangle = new GPolygon();
		triangle.addVertex(0, -height);
		triangle.addArc(side / 5, side / 5, 45, 105);
		triangle.addEdge(-side / 2, height);
		triangle.addArc(side / 5, side / 5, 165, 75);
		triangle.addEdge(side, 0);
		triangle.addArc(side / 5, side / 5, 285, 105);
		triangle.setFilled(true);
		triangle.setFillColor(Color.MAGENTA);
		add(triangle, 300, 300);
	}

	public void run() {
		RoundTriangle t = new RoundTriangle(500);
		add(t);    // Change it to center later
	}
}
