import Characters.Madoka;
import acm.graphics.*;

import java.awt.*;

import acm.program.*;

import Characters.*;

public class Core {
	public static Character initMadoka(Character character, Madoka madoka) {
//		Madoka.run();
		character.still.state.forward = madoka.still.state.forward;
		character.still.state.backward = madoka.still.state.backward;
		character.running.state.forward = madoka.running.state.forward;
		character.running.state.backward = madoka.running.state.backward;
		character.jumping.state.forward = madoka.jumping.state.forward;
		character.jumping.state.backward = madoka.jumping.state.backward;
		return character;
	}
}