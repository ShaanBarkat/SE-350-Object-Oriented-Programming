//Random Search --> Implement into Search Strategy
package assignment1;

import java.util.HashSet;

public class RandomSearch implements SearchStrategy {
	String BSHead; //Battleship Head - starting position
	String BSTail; //Battleship Tail - ending position
	String SSHead; //SubShip Head - starting position
	String SSTail; //SubShip Tail -  ending position
	int seekAcc = 0;
	//Need accumulator for seeker
	
	HashSet<String> detectedAcc;
	
	public void search(int[][] Grid) {
		
		detectedAcc = new HashSet<String>();
		System.out.println("Random Search Strategy");
		
		while (detectedAcc.size() < 8) 
		{
			int R = (int) (Math.random() * Grid.length);
			int C = (int) (Math.random() * Grid[0].length);
			//randomly generate coordinates
			//rand.nextInt- Random()* didn't work.. stuck with math.random
			if (Grid[R][C] != 0) 
			{
				detectedAcc.add(R + " " + C);
				
				if (Grid[R][C] == 1){ 
					BSHead = "(" + R + "," + C + ")";
				}
				
				else if (Grid[R][C] == 2){
					BSTail = "(" + R + "," + C + ")";
				}
				
				else if (Grid[R][C] == 3){
					SSHead = "(" + R + "," + C + ")";
				}
				
				else if (Grid[R][C] == 4){
					SSTail = "(" + R + "," + C + ")";
				}
			}
			seekAcc++;
		}
		
		
		System.out.println("Number of cells searched: " + seekAcc);
		System.out.println("Battleship found: " + BSHead + " to " + BSTail + " SubShip found: " + SSHead + " to " + SSTail + "\n");
	}
}