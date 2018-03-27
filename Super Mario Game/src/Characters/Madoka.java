package Characters;

import acm.graphics.*;

import java.awt.*;

import acm.program.*;

import Actions.*;

public class Madoka {
	public static String name = "Kaname Madoka";
	public static GImage MadokaStandStillForward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaStandStillForward.gif");
	public static GImage MadokaStandStillBackward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaStandStillBackward.gif");
	public static GImage MadokaRunForward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaRunForward.gif");
	public static GImage MadokaRunBackward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaRunBackward.gif");
	public static GImage MadokaJumpForward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaJumpForward.gif");
	public static GImage MadokaJumpBackward = new GImage("C:\\Users\\cavid\\Documents\\Assignments\\Super Mario Game\\src\\Characters\\Images\\MadokaJumpBackward.gif");

	public Running running;
	public Jumping jumping;
	public Still still;
	public State state;

	public Madoka() {
		running = new Running();
		jumping = new Jumping();
		still = new Still();
		state = new State();
		this.still.state.forward = MadokaStandStillForward;
		this.still.state.backward = MadokaStandStillBackward;
		this.running.state.forward = MadokaRunForward;
		this.running.state.backward = MadokaRunBackward;
		this.jumping.state.forward = MadokaJumpForward;
		this.jumping.state.backward = MadokaJumpBackward;
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