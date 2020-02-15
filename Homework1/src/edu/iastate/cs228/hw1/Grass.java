package edu.iastate.cs228.hw1;

/**
 *  
 * @author Elijah Valine
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 */
public class Grass extends Living 
{
	private int[] pop = new int[5];
	
	/**
	 * Constructs a grass object.
	 * @param p The plain the current object resides in.
	 * @param r This object's row
	 * @param c This object's column
	 */
	public Grass (Plain p, int r, int c) 
	{
		
		this.row = r;
		this.column = c;
		this.plain = p;
	}
	/**
	 * @return The state of the current object
	 */
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 * @param the plain of the life next cycle
	 * @return a Living object which will reside in the current space in the pNew Plain.
	 */
	public Living next(Plain pNew)
	{
		//Returns a new Living object, that will reside in the current space on the grid, based on the set of rules.
		super.census(pop);
		
		if ( pop[4] >= pop[3] * 3) {
			return new Empty(pNew, this.row, this.column );
		}
		
		else if (pop[4] >= 3) {
			return new Rabbit(pNew, this.row, this.column, 0 );
		}
		
		else {
			return new Grass(pNew, this.row, this.column);
		}
	}

	/**
	 * @return Returns a string containing the letter "G".
	 */
	public String stringer() {
		return "G";
	}
}
