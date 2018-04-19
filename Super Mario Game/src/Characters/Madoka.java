package Characters;

import Builders.Character;
import acm.graphics.*;

import Actions.*;

public class Madoka extends Character {
	public static String name = "Kaname Madoka";
	public static GImage Onscreen = new GImage("Images/Marios/Madoka/MadokaStandStillForward.gif");
	public static GImage StandStillForward = new GImage("Images/Marios/Madoka/MadokaStandStillForward.gif");
	public static GImage StandStillBackward = new GImage("Images/Marios/Madoka/MadokaStandStillBackward.gif");
	public static GImage RunForward = new GImage("Images/Marios/Madoka/MadokaRunForward.gif");
	public static GImage RunBackward = new GImage("Images/Marios/Madoka/MadokaRunBackward.gif");
	public static GImage JumpForward = new GImage("Images/Marios/Madoka/MadokaJumpForward.gif");
	public static GImage JumpBackward = new GImage("Images/Marios/Madoka/MadokaJumpBackward.gif");

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
		this.onscreen = Onscreen;
		this.still.state.forward = StandStillForward;
		this.still.state.backward = StandStillBackward;
		this.running.state.forward = RunForward;
		this.running.state.backward = RunBackward;
		this.jumping.state.forward = JumpForward;
		this.jumping.state.backward = JumpBackward;
	}

	public static Builders.Character initiate(Builders.Character character) {
		character.setCurrent(StandStillForward);
		character.still.state.forward = StandStillForward;
		character.still.state.backward = StandStillBackward;
		character.running.state.forward = RunForward;
		character.running.state.backward = RunBackward;
		character.jumping.state.forward = JumpForward;
		character.jumping.state.backward = JumpBackward;
		return character;
	}
}