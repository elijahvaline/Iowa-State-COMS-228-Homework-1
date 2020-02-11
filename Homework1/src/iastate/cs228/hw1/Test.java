package iastate.cs228.hw1;

public class Test {

	public static void main(String[] args) {
		Plain testy = new Plain(5);
		testy.randomInit();
		System.out.println(testy.toString());
		System.out.println(testy.grid[0][0].neighborsString());

	}

}
