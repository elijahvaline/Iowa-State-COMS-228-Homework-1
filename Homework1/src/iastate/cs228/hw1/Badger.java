package iastate.cs228.hw1;

import java.util.ArrayList;

/**
 *  
 * @author
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal {
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger(Plain p, int r, int c, int a) {
		this.age = a;
		this.row = r;
		this.column = c;
		this.plain = p;
	}

	/**
	 * A badger occupies the square.
	 */
	public State who() {
		// TODO
		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group
	 * of foxes.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(Plain pNew) {
		// TODO
		//
		// See Living.java for an outline of the function.
		// See the project description for the survival rules for a badger.
		return null;
	}
	
	public String tString() {
		
		return "B" + super.age;
		
	}

//Make a single dimension array with every neighboring square and then run the simulation. Cast to the new wildlife if necessary.
}
