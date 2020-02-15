package iastate.cs228.hw1;

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
	
	private int[] pop = new int[5];
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
		
		// Count the numbers of Badgers, Empties, Foxes, Grasses, and Rabbits

		
		super.census(pop);
		
		if (this.age >=  4) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column);
		}
		else if (pop[0] == 1 && pop[2] > 1) {
			//fox
//			pNew.grid[this.row][this.column] = new Fox(pNew, this.row, this.column, 0);
//			return pNew.grid[this.row][this.column];
			return new Fox(pNew, this.row, this.column, 0);
		}
		else if (pop[0] + pop[2] > pop[4]) {
			//empty
//			pNew.grid[this.row][this.column] = new Empty(pNew, this.row, this.column);
//			return pNew.grid[this.row][this.column];
			return new Empty(pNew, this.row, this.column);
		}
		else {
			this.age++;
//			pNew.grid[this.row][this.column] = new Badger(pNew, this.row, this.column, this.age);
//			return pNew.grid[this.row][this.column];
			return new Badger(pNew, this.row, this.column, this.age);
			
		}
		
	}
	
	public String stringer() {
		
		return "B" + super.age;
		
	}

//Make a single dimension array with every neighboring square and then run the simulation. Cast to the new wildlife if necessary.
}
