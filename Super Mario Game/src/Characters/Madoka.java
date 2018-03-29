package Characters;

import Builders.Character;
import acm.graphics.*;

import Actions.*;

public class Madoka {
	public static String name = "Kaname Madoka";
	public static GImage MadokaOnscreen = new GImage("Images/Marios/Madoka/MadokaStandStillForward.gif");
	public static GImage MadokaStandStillForward = new GImage("Images/Marios/Madoka/MadokaStandStillForward.gif");
	public static GImage MadokaStandStillBackward = new GImage("Images/Marios/Madoka/MadokaStandStillBackward.gif");
	public static GImage MadokaRunForward = new GImage("Images/Marios/Madoka/MadokaRunForward.gif");
	public static GImage MadokaRunBackward = new GImage("Images/Marios/Madoka/MadokaRunBackward.gif");
	public static GImage MadokaJumpForward = new GImage("Images/Marios/MadokaJumpForward.gif");
	public static GImage MadokaJumpBackward = new GImage("Images/Marios/Madoka/MadokaJumpBackward.gif");

	public Running running;
	public Jumping jumping;
	public Still still;
	public State state;
	public GImage onscreen;

	public Madoka() {
		running = new Running();
		jumping = new Jumping();
		still = new Still();
		state = new State();
		this.onscreen = MadokaOnscreen;
		this.still.state.forward = MadokaStandStillForward;
		this.still.state.backward = MadokaStandStillBackward;
		this.running.state.forward = MadokaRunForward;
		this.running.state.backward = MadokaRunBackward;
		this.jumping.state.forward = MadokaJumpForward;
		this.jumping.state.backward = MadokaJumpBackward;
	}

	public Builders.Character init(Builders.Character character) {
		character.setCurrent(MadokaStandStillForward);
		character.still.state.forward = MadokaStandStillForward;
		character.still.state.backward = MadokaStandStillBackward;
		character.running.state.forward = MadokaRunForward;
		character.running.state.backward = MadokaRunBackward;
		character.jumping.state.forward = MadokaJumpForward;
		character.jumping.state.backward = MadokaJumpBackward;
		return character;
	}





//	public static void run() {
//		running = new Running();
//		jumping = new Jumping();
//		still = new Still();
//		state = new State();
//		Madoka.still.state.forward = MadokaStandStillForward;
//		Madoka.still.state.backward = MadokaStandStillBackward;
//		Madoka.running.state.forward = MadokaRunForward;
//		Madoka.running.state.backward = MadokaRunBackward;
//		Madoka.jumping.state.forward = MadokaJumpForward;
//		Madoka.jumping.state.backward = MadokaJumpBackward;
//	}
}