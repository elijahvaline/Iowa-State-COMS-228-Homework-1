package edu.iastate.cs228.hw1;

import java.util.ArrayList;

/**
 *  
 * @author Elijah Valine
 *
 */

/**
 * Living refers to the life form occupying a square in a plain grid. It is a
 * superclass of Empty, Grass, and Animal, the latter of which is in turn a
 * superclass of Badger, Fox, and Rabbit. Living has two abstract methods
 * awaiting implementation.
 */
public abstract class Living {
	
	protected Plain plain; // the plain in which the life form resides
	protected int row; // location of the square on which
	protected int column; // the life form resides
	protected ArrayList<Living> neighborhood = new ArrayList<Living>();
	
	// constants to be used as indices.
	protected static final int BADGER = 0;
	protected static final int EMPTY = 1;
	protected static final int FOX = 2;
	protected static final int GRASS = 3;
	protected static final int RABBIT = 4;

	public static final int NUM_LIFE_FORMS = 5;

	// life expectancies
	public static final int BADGER_MAX_AGE = 4;
	public static final int FOX_MAX_AGE = 6;
	public static final int RABBIT_MAX_AGE = 3;

	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a plain.
	 * 
	 * @param population counts of all life forms
	 */
	

	protected void census(int population[]) {
		//Using the ArrayList neighborhood, and increments the corresponding spot in the population array.
		this.neighbors();
		population[0] = 0;
		population[1] = 0;
		population[2] = 0;
		population[3] = 0;
		population[4] = 0;
		for (int i = 0; i < neighborhood.size(); i++) {
			switch (neighborhood.get(i).who()) {
			case BADGER:
				population[0]++;
				break;
			case EMPTY:
				population[1]++;
				break;
			case FOX:
				population[2]++;
				break;
			case GRASS:
				population[3]++;
				break;
			case RABBIT:
				population[4]++;
				break;
			}
		}
	}

	/**
	 * Adds all adjacent Living objects to the ArrayList neighborhood.
	 */
	protected void neighbors() {
		
		//Looks at every component of the neighborhood and adds the Living object to an ArrayList neighborhood.

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int xPosition = this.row - 1 + j;
				int yPosition = this.column - 1 + i;

				 if (xPosition < this.plain.grid.length && xPosition > -1) {
					if (yPosition < this.plain.grid[1].length && yPosition > -1) {
						neighborhood.add(this.plain.grid[xPosition][yPosition]);
					}
				}
			}
		}
	}
	
	/**
	 * The neighborhood is all the adjacent Living objects.
	 * @return Returns a string containing all the Living objects in the neighborhood.
	 */
	public String neighborsString() {
		
		//Converts all components of the ArrayList neighborhood to a string.
		
		this.neighbors();
		String s = "";
		for (int i = 0; i<neighborhood.size(); i++) {
			
			s += " " + neighborhood.get(i).stringer();
		}
		return s;
	}

	/**
	 * Gets the identity of the life form on the square.
	 * 
	 * @return State
	 */
	public abstract String stringer();
	public abstract State who();
	public abstract Living next(Plain pNew);

}
