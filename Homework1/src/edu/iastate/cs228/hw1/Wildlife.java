package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  
 * @author Elijah Valine 
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with squares
 * inhabited by badgers, foxes, rabbits, grass, or none.
 *
 */
public class Wildlife {
	private static Scanner sc;

	/**
	 * Update the new plain from the old plain in one cycle.
	 * 
	 * @param pOld old plain
	 * @param pNew new plain
	 */

	public static void updatePlain(Plain pOld, Plain pNew) {
		// Updates the cycle by calling next() on every element of the plain pOld.
		Living x;
		for (int i = 0; i < pOld.grid.length; i++) {
			for (int j = 0; j < pOld.grid.length; j++) {
				x = pOld.grid[i][j].next(pNew);
				pNew.grid[i][j] = x;
				pOld.grid[i][j].neighborhood.clear();
				pNew.grid[i][j].neighborhood.clear();

			}
		}

	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. Over each
	 * plain, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Outputs the user instructions and takes user input from a scanner and applies
		// it to variables. Using a switch statement the correct trial is then executed.
		
		//On an somewhat unrelated note, I really feel like rabbits are somewhat OP in this
		//Simulation. They are much better off to survive long term than either the fox or the badger.
		int input;
		boolean running = true;
		int trial = 1;
		int grid;
		int cycles;
		String file;
		Plain theWild;

		sc = new Scanner(System.in);
		System.out.println(
				"Simulation of Wildlife of the Plain" + "\n" + "keys: 1 (random plain) 2 (file input) 3 (exit)");

		while (running == true) {
			System.out.print("Trial " + trial + ":");
			input = sc.nextInt();

			switch (input) {

			case 1:

				System.out.println("Random plain");
				System.out.print("Enter grid width:");
				grid = sc.nextInt();
				theWild = new Plain(grid);
				System.out.print("Enter the number of cycles:");
				cycles = sc.nextInt();

				System.out.println("\n" + "Initial Plain: " + "\n" + "\n" + theWild.toString());
				for (int i = 0; i < cycles; i++) {
					Plain p2 = new Plain(theWild.grid.length);
					Wildlife.updatePlain(theWild, p2);
					theWild = p2;
				}
				System.out.println("Final Plain:" + "\n" + "\n" + theWild.toString());
				break;

			case 2:
				System.out.println("Plain input from a file");
				System.out.print("File Name: ");
				file = sc.next();
				System.out.print("Enter the number of cycles: " + "\n");
				cycles = sc.nextInt();
				theWild = new Plain(file);
				System.out.println("Initial Plain: " + "\n" + "\n" + theWild.toString());
				for (int i = 0; i < cycles; i++) {
					Plain p2 = new Plain(theWild.grid.length);
					Wildlife.updatePlain(theWild, p2);
					theWild = p2;
				}
				System.out.println("Final Plain:" + "\n" + "\n" + theWild.toString());

				break;

			case 3:
				running = false;
				break;

			}

			trial++;

		}
	}
}
