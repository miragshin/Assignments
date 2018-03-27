import Actions.Jumping;
import Actions.Running;
import Actions.State;
import Actions.Still;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.program.*;

public class Character extends GCompound {
	public State state;
	public Running running;
	public Jumping jumping;
	public Still still;
	public String name;

	public Character() {
		state = new State();
		running = new Running();
		jumping = new Jumping();
		still = new Still();
	}

	public Character(Character character) {
		state = new State();
		running = new Running();
		jumping = new Jumping();
		still = new Still();

		/* I don't know why this line is here, but I won't remove it just in case */
//		character.still.state.forward = this.still.state.forward;
		add(character.still.state.forward);
	}
}