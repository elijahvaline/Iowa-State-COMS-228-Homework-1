package iastate.cs228.hw1;

/**
 *  
 * @author Elijah Valine
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	
	private int[] pop = new int[5];
	
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */

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
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		//Returns a new Living object, that will reside in the current space on the grid, based on the set of rules.
		super.census(pop);
		
		if (this.age >=  6) {
			
			return new Empty(pNew, this.row, this.column );
		}
		
		else if (pop[0] > pop[2]) {
			return new Badger(pNew, this.row, this.column, 0 );
		}
		
		else if (pop[0] + pop[2] > pop[4]) {
			return new Empty(pNew, this.row, this.column );
		}
		
		else {
			this.age++;
			return new Fox(pNew, this.row, this.column, this.age );	
		} 
	}

	/**
	 * @return A string containing the letter "F" and the current age of the fox object.
	 */
	public String stringer() {
		
		return "F" + super.age;
	}
}
