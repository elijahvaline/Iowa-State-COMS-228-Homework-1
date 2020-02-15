package iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	private int[] pop = new int[5];

	
	public Fox (Plain p, int r, int c, int a) 
	{
		this.age = a;
		this.row = r;
		this.column = c;
		this.plain = p;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		
		// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits
	
		super.census(pop);
		
		if (this.age >=  6) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column );
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column );
			
		}
		else if (pop[0] > pop[2]) {
			//badger
//			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, 0 );
//			return pNew.grid[this.row][this.column];
			return new Badger(pNew, this.row, this.column, 0 );
		}
		else if (pop[0] + pop[2] > pop[4]) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column );
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column );
		}
		else {
			//nothing
			this.age++;
//			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, this.age );
//			return pNew.grid[this.row][this.column];
			return new Fox(pNew, this.row, this.column, this.age );
			
		}
		
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a fox. 
	
	}

	public String stringer() {
		
		return "F" + super.age;
	}
}
