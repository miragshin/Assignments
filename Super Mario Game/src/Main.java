import acm.graphics.*;
import java.awt.*;
import acm.program.*;

public class Main extends GraphicsProgram {

	public void run() {
		setBackground(Color.BLUE);

//		Background background = new Background(getWidth(), getHeight());
//		add(background);

		add(new Background(getWidth(), getHeight()));
	}

	public static void main(String[] args) {
		new Main().start();
	}
}