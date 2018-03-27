import acm.graphics.*;

import java.awt.*;

import acm.program.*;

public class Mario extends GCompound {
	private static GImage character;
	private GImage MadokaStandStillForward = new GImage("Images/Marios/Madoka/MadokaStandStillForward.gif");
	private GImage MadokaStandStillBackward = new GImage("Images/Marios/Madoka/MadokaStandStillBackward.gif");
	private GImage MadokaRunForward = new GImage("Images/Marios/Madoka/MadokaRunForward.gif");
	private GImage MadokaRunBackward = new GImage("Images/Marios/Madoka/MadokaRunBackward.gif");
	private GImage MadokaJumpForward = new GImage("Images/Marios/Madoka/MadokaJumpForward.gif");
	private GImage MadokaJumpBackward = new GImage("Images/Marios/Madoka/MadokaJumpBackward.gif");

	public Mario() {
		character = MadokaStandStillForward;
		add(character);
	}

	public void standStill() {
		remove(character);
		if (character.equals(MadokaRunForward) || character.equals(MadokaStandStillForward) || character.equals(MadokaJumpForward)) {
			character = MadokaStandStillForward;
		} else {
			character = MadokaStandStillBackward;
		}
		add(character);
	}

	public void runForward() {
		remove(character);
		character = MadokaRunForward;
		add(character);
	}

	public void runBackward() {
		remove(character);
		character = MadokaRunBackward;
		add(character);
	}

	public void jump() {
		remove(character);
		if (character.equals(MadokaRunForward) || character.equals(MadokaStandStillForward)) {
			character = MadokaJumpForward;
			add(character);
		} else if (character.equals(MadokaRunBackward) || character.equals(MadokaStandStillBackward)) {
			character = MadokaJumpBackward;
		}
		add(character);
	}

	public void setImage() {
		character.setImage("Images/Marios/Madoka/MadokaRunForward.gif");
	}
}