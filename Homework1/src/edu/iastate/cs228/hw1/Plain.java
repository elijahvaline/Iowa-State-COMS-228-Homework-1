package edu.iastate.cs228.hw1;

/**
 *  
 * @author Elijah Valine 
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
	private Scanner s;
	private Scanner scan;

	/**
	 * Default constructor reads from a file
	 */
	public Plain(String inputFileName) throws FileNotFoundException {
		
		/*
		 * Uses a scanner to find the total width of the given plain, and then uses a different scanner to read each
		 * individual component and setting a the variable curr equal to it. Using a switch statement a Living object
		 * is created for every component in the file.
		 */
		
		File f = new File(inputFileName);
		s = new Scanner(f);
		scan = new Scanner(f);
		while (s.hasNextLine()) {
			width++;
			s.nextLine();
		}
		
		grid = new Living[width][width];
		int x;
		int y;

		for (x = 0; x < width; x++) {

			for (y = 0; y < width; y++) {

				String curr = scan.next();
				char first = curr.charAt(0);

				switch (first) {
				case 'B':
					grid[x][y] = new Badger(this, x, y, Character.getNumericValue(curr.charAt(1)));
					break;
				case 'E':
					grid[x][y] = new Empty(this,x,y);
					break;
				case 'F':
					grid[x][y] = new Fox(this, x, y, Character.getNumericValue(curr.charAt(1)));
					break;
				case 'G':
					grid[x][y] = new Grass(this, x,y);
					break;
				case 'R':
					grid[x][y] = new Rabbit(this, x, y, Character.getNumericValue(curr.charAt(1)));
					break;

				}	
			}
			y = 0;
		}

	}

	/**
	 * Constructor that builds a w x w grid without initializing it.
	 * 
	 * @param width the grid
	 */
	public Plain(int w) {
		//Creates a plain with the given width and then initializes it with the randomInit() method.
		grid = new Living[w][w];
		width = w;
		randomInit();
		
		
		
	}
/**
 * 
 * @return The width of the current plain.
 */
	public int getWidth() {
		
		return width; 
	}

	/**
	 * Initialize the plain by randomly assigning to every square of the grid one of
	 * BADGER, FOX, RABBIT, GRASS, or EMPTY.
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit() {
		
		/*
		 * Takes a random number between 0-4 and uses an array to convert it to a character. Using the character
		 * it creates a new random Living object.
		 */
		
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
		
		//Calls stringer on all Living objects in the plain and outputs it to a single string.
 		String output = "";
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				output += grid[i][j].stringer() + " ";	
				
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
		
		//outputs this.toString() to a .txt file
		
		File outFile = new File(outputFileName);
		PrintWriter out = new PrintWriter(outFile);
		out.print(this.toString());
		out.close();
	}
}
