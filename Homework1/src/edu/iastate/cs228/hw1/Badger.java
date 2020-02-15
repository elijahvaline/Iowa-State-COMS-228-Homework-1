package edu.iastate.cs228.hw1;

/**
 *  
 * @author Elijah Valine
 *
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal {
	
	private int[] pop = new int[5];
	
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger(Plain p, int r, int c, int a) {
		//constructs a new badger object.
		this.age = a;
		this.row = r;
		this.column = c;
		this.plain = p;
	}

	/**
	 * A badger occupies the square.
	 */
	public State who() {
		
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
		//Returns a new Living object, that will reside in the current space on the grid, based on the set of rules.
		super.census(pop);
		
		if (this.age >=  4) {
			
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[0] == 1 && pop[2] > 1) {
			
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[0] + pop[2] > pop[4]) {

			return new Empty(pNew, this.row, this.column);
		}
		else {
			this.age++;
			return new Badger(pNew, this.row, this.column, this.age);
			
		}
		
	}
	
	/**
	 * @return A string with the first containing the Age and first Character of the Living Object
	 */
	public String stringer() {
		//Returns the letter "B" + the current age of the badger
		return "B" + super.age;
		
	}

}
