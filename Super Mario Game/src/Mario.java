import acm.graphics.*;
import java.awt.*;
import acm.program.*;

public class Mario extends GCompound {
	public void run() {
		GImage mario = new GImage(
				"Images/MarioRight.mp4",
				100,
				100
		);
		add(mario);
	}
}
