package iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	private int[] pop = new int[5];
	public Grass (Plain p, int r, int c) 
	{
		
		this.row = r;
		this.column = c;
		this.plain = p;
	}
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		
		// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits
		Living returner;
		super.census(pop);
		
		if ( pop[4] >= pop[3] * 3) {
			//empty
			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column );
			returner = pNew.grid[this.row][this.column];

		}
		else if (pop[4] >= 3) {
			//rabbit
			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, 0 );
			returner = pNew.grid[this.row][this.column];
		}
		else {
			//nothing
			returner = this;
		}
		
		neighborhood.clear();
		return returner;
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for grass. 

	}

	public String tString() {
		return "G";
	}
}
