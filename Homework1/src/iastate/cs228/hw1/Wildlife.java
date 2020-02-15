package iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  
 * @author
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
		// TODO
		//
		// For every life form (i.e., a Living object) in the grid pOld, generate
		// a Living object in the grid pNew at the corresponding location such that
		// the former life form changes into the latter life form.
		//
		// Employ the method next() of the Living class.
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
		// TODO
		//
		// Generate wildlife simulations repeatedly like shown in the
		// sample run in the project description.
		//
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		// file, and 3 to end the simulation. (An input file always ends with
		// the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description.
		//
		// 3. For convenience, you may define two plains even and odd as below.
		// In an even numbered cycle (starting at zero), generate the plain
		// odd from the plain even; in an odd numbered cycle, generate even
		// from odd.

		Plain even; // the plain after an even number of cycles
		Plain odd; // the plain after an odd number of cycles

		// 4. Print out initial and final plains only. No intermediate plains should
		// appear in the standard output. (When debugging your program, you can
		// print intermediate plains.)
		//
		// 5. You may save some randomly generated plains as your own test cases.
		//
		// 6. It is not necessary to handle file input & output exceptions for this
		// project. Assume data in an input file to be correctly formated.

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
				System.out.print("Enter the number of cycles: " + "\n" );
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
