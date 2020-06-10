//strategic search --> searchstrategy
package assignment1;

import java.util.HashSet;

public class StrategicSearch implements SearchStrategy {
	
	String BSHead;
	String BSTail;
	String SSHead;
	String SSTail;
	
	HashSet<String> seekAcc, detectedAcc; 
	
	public void search(int[][] Grid) {
		System.out.println("Strategic Search Strategy");
		
		seekAcc = new HashSet<String>();
		detectedAcc = new HashSet<String>();
		
		while (detectedAcc.size() < 8) 
		{
			int R = (int) (Math.random() * Grid.length);
			int C = (int) (Math.random() * Grid[0].length);
			
			if (!detectedAcc.contains(R + " " + C)) 
			{
				if (!detectedAcc.contains(R + " " + C) && Grid[R][C] != 0) 
				{
					if (Grid[R][C] == 1){
						BSHead = "(" + R + "," + C + ")";
					}
					else if (Grid[R][C] == 2){
						BSTail = "("+ R +"," + C +")";
					}
					else if (Grid[R][C] == 3){
						SSHead = "(" + R + "," + C + ")";
					}
					else if (Grid[R][C] == 4){
						SSTail = "(" + R + "," + C + ")";
					}
					detectedAcc.add(R + " " + C);
				}
				seekAcc.add(R + " " + C);
			}
		}
		
		System.out.println("Number of cells searched: " + seekAcc.size());
		System.out.println("BattleShip found: " + BSHead + " to " + BSTail + " SubShip found: " + SSHead + " to " + SSTail + "\n");
		
		
	}
}
