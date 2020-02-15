package iastate.cs228.hw1;

import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
//		Plain testy = new Plain(5);
//		testy.randomInit();
//		System.out.println(testy.toString());
//
//		
//		Plain p1 = new Plain(5);
//		
//		Wildlife.updatePlain(testy, p1);
//		System.out.println(p1.toString());

		Plain zed = new Plain(6);
		System.out.println(" First:" + "\n" + zed.toString());

		for (int i = 0; i < 6; i++) {
			Plain p2 = new Plain(zed.grid.length);
			Wildlife.updatePlain(zed, p2);
			zed = p2;
			System.out.println(zed.toString());
		}
		zed.write("test.txt");

	

	}

}
