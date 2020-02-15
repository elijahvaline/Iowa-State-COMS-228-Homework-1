package edu.iastate.cs228.hw1;

/**
 *  
 * @author Elijah Valine
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	private int[] pop = new int[5];
	
	/**
	 * Constructs an empty Living object.
	 * @param p The plain this object resides in.
	 * @param r This object's row.
	 * @param c This object's column
	 */
	public Empty (Plain p, int r, int c) 
	{
		this.row = r;
		this.column = c;
		this.plain = p; 
	}
	/**
	 * @return The current state of this Living object.
	 */
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		// Returns a new Living object, that will reside in the current space on the
		// grid, based on the set of rules.
		
	super.census(pop);
	
		if (pop[4] > 1) {

			return new Rabbit(pNew, this.row, this.column, 0 );
		}
		else if (pop[2] > 1) {

			return new Fox(pNew, this.row, this.column, 0 );
		}
		else if (pop[0] > 1) {

			return new Badger(pNew, this.row, this.column, 0 );
		}
		else if (pop[3] >= 1){

			return new Grass(pNew, this.row, this.column );
		}
		else {

			return new Empty(pNew, this.row, this.column);
		}
	}
	
	/**
	 * @return A string containing the letter "E"
	 */
	public String stringer() {
		
		return "E";
	}
}
