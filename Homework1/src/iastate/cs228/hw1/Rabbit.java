package iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	
	private int[] pop = new int[5];
	
	public Rabbit (Plain p, int r, int c, int a) 
	{
		this.age = a;
		this.row = r;
		this.column = c;
		this.plain = p;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		// TODO  
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
	
	super.census(pop);
	
	// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits
		
		if (this.age >=  3) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column );
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column );
			
		}
		else if (pop[3] == 0) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column );
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column );
		}
		else if (pop[0] + pop[2] >= pop[4] && pop[2] > pop[0]) {
//			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0 );
//			return pNew.grid[this.row][this.column];
			return new Fox(pNew, this.row, this.column, 0 );
			//fox
		}
		else if (pop[0] > pop[4]) {
			// badger
//			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0 );
//			return pNew.grid[this.row][this.column];
			return new Badger(pNew, this.row, this.column, 0 );
		}
		else {
			//nothing
			this.age++;
//			pNew.grid[this.row][this.column] = new Rabbit(pNew, this.row, this.column, this.age );
//			return pNew.grid[this.row][this.column];
			return new Rabbit(pNew, this.row, this.column, this.age );
		}

		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a rabbit. 
		
	}
	public String stringer() {
		
		return "R" + super.age;
	}
}
