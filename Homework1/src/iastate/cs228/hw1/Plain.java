package iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 * 
 * The plain is represented as a square grid of size width x width.
 *
 */
public class Plain {
	private int width; // grid size: width X width

	public Living[][] grid;

	/**
	 * Default constructor reads from a file
	 */
	public Plain(String inputFileName) throws FileNotFoundException {
		
		Scanner s = new Scanner(inputFileName);
		Scanner scan = new Scanner(inputFileName);
		while (s.hasNext()) {
			width++;
			s.next();
		}
		grid = new Living[width][width];

		for (int y = 0; y <= width; y++) {

			for (int x = 0; x <= width; x++) {

				String curr = scan.next();
				char first = curr.charAt(0);

				switch (first) {
				case 'B':
					grid[y][x] = new Badger(this, x, y, (int)curr.charAt(1));
					break;
				case 'E':
					grid[y][x] = new Empty(this,x,y);
					break;
				case 'F':
					grid[y][x] = new Fox(this, x, y, (int)curr.charAt(1));
					break;
				case 'G':
					grid[y][x] = new Grass(this, x,y);
					break;
				case 'R':
					grid[y][x] = new Rabbit(this, x, y, (int)curr.charAt(1));
					break;

				}	
			}
		}
		

		// TODO
		//
		// Assumption: The input file is in correct format.
		//
		// You may create the grid plain in the following steps:
		//
		// 1) Reads the first line to determine the width of the grid.
		//
		// 2) Creates a grid object.
		//
		// 3) Fills in the grid according to the input file.
		//
		// Be sure to close the input file when you are done.
	}

	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * 
	 * @param width the grid
	 */
	public Plain(int w) {
		
		grid = new Living[w][w];
		width = w;
		
	}

	public int getWidth() {
		// TODO
		return width; // to be modified
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid one of
	 * BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		
		Random generator = new Random();
		
		char[] a = {'B','F','R','G','E'};
		
		for (int y = 0; y < width; y++) {

			for (int x = 0; x < width; x++) {
				int z = generator.nextInt(4);
				char critter = a[z];

				switch (critter) {
				case 'B':
					grid[y][x] = new Badger(this, x, y, 0);
					break;
				case 'E':
					grid[y][x] = new Empty(this,x,y);
					break;
				case 'F':
					grid[y][x] = new Fox(this, x, y, 0);
					break;
				case 'G':
					grid[y][x] = new Grass(this, x,y);
					break;
				case 'R':
					grid[y][x] = new Rabbit(this, x, y, 0);
					break;

				}	
			}
		}
	}

	/**
	 * Output the plain grid. For each square, output the first letter of the living
	 * form occupying the square. If the living form is an animal, then output the
	 * age of the animal followed by a blank space; otherwise, output two blanks.
	 */
	public String toString() {
		String output = "";
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				output += " " + grid[j][i].tString();	
				
			}
			output += "\n";
		}
		
		return output;
	}

	/**
	 * Write the plain grid to an output file. Also useful for saving a randomly
	 * generated plain for debugging purpose.
	 * 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException {
		// TODO
		//
		// 1. Open the file.
		//
		// 2. Write to the file. The five life forms are represented by characters
		// B, E, F, G, R. Leave one blank space in between. Examples are given in
		// the project description.
		//
		// 3. Close the file.
	}
}
