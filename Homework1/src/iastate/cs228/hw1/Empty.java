package iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	private int[] pop = new int[5];
	public Empty (Plain p, int r, int c) 
	{
		
		this.row = r;
		this.column = c;
		this.plain = p; 
	}
	
	public State who()
	{
		// TODO 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		
	super.census(pop);
	// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits
		if (pop[4] > 1) {
//			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, 0 );
//			return  pNew.grid[this.row][this.column];
			return new Rabbit(pNew, this.row, this.column, 0 );
		}
		else if (pop[2] > 1) {
			//fox
//			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0 );
//			return pNew.grid[this.row][this.column];
			return new Fox(pNew, this.row, this.column, 0 );
		}
		else if (pop[0] > 1) {
			//badger
//			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0 );
//			return pNew.grid[this.row][this.column];
			return new Badger(pNew, this.row, this.column, 0 );
		}
		else if (pop[3] >= 1){
			//grass
//			pNew.grid[this.row][this.column] = new Grass(pNew, this.row, this.column );
//			return pNew.grid[this.row][this.column];
			return new Grass(pNew, this.row, this.column );
		}
		else {
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column);
		}
		
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for corresponding survival rules. 
	
	}
	
	public String tString() {
		
		return "E";
	}
}
