//BattleshipSearch --> SearchStrategy()
package assignment1;

public class BattleshipSearch {
	
	SearchStrategy[] strats = {new HorizontalSweep(), new RandomSearch(), new StrategicSearch()};
	Input scan;
	int[][] Grid;

	public void seek() {
		for (int i = 0; i < strats.length; i++) {
			System.out.println("Game "+(i+1));
			//game 1-3
			int[][] Grid = scan.read();
			strats[i].search(Grid);
		}
	}
	
	public BattleshipSearch() {
		scan = new Input();
	}
	
	public static void main(String[] args) {
		BattleshipSearch seek = new BattleshipSearch();
		seek.seek();
	}
}