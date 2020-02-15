package iastate.cs228.hw1;

/**
 * 
 * @author Elijah Valine
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal {
	private int[] pop = new int[5];

	/**
	 * Creates a Rabbit object.
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Rabbit(Plain p, int r, int c, int a) {
		this.age = a;
		this.row = r;
		this.column = c;
		this.plain = p;
	}

	/**
	 * @return The state of the current object
	 */
	public State who() {
		// TODO
		return State.RABBIT;
	}

	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a
	 * fox.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living new life form occupying the same square
	 */
	public Living next(Plain pNew) {

		super.census(pop);

		// Returns a new Living object, that will reside in the current space on the
		// grid, based on the set of rules.

		if (this.age >= 3) {
			return new Empty(pNew, this.row, this.column);

		} else if (pop[3] == 0) {
			return new Empty(pNew, this.row, this.column);
			
		} else if (pop[0] + pop[2] >= pop[4] && pop[2] > pop[0]) {
			return new Fox(pNew, this.row, this.column, 0);
			
		} else if (pop[0] > pop[4]) {
			return new Badger(pNew, this.row, this.column, 0);
			
		} else {
			this.age++;
			return new Rabbit(pNew, this.row, this.column, this.age);
		}
	}

	public String stringer() {

		return "R" + super.age;
	}
}
