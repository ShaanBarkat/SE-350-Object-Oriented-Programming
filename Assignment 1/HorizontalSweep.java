//Horizontal Sweep --> implement into Search Strategy
package assignment1;

public class HorizontalSweep implements SearchStrategy {
	String BSHead;
	String BSTail;
	String SSHead;
	String SSTail;
	
	int seekAcc = 0;
	int detectedAcc = 0;
	
	public void search(int[][] Grid)
	{
		System.out.println("Horizontal Sweep Strategy");
		for (int R = 0; R < Grid.length; R++) {
				
			for (int C = 0; C < Grid[R].length; C++) {
					
				if (Grid[R][C] != 0) {
					detectedAcc++;
						
					if (Grid[R][C] == 1) { 
						BSHead = "(" + R + "," + C + ")";
					}
					else if (Grid[R][C] == 2) { 
						BSTail = "(" + R + "," + C + ")";
					}
					else if (Grid[R][C] == 3) {
						SSHead = "("+ R + "," + C +")";
					}
					else if (Grid[R][C] == 4) { 
						SSTail = "("+ R + "," + C +")";
					}
				}
				seekAcc++;
					
				if (detectedAcc > 7) break;
			}

			if (detectedAcc > 7) break;
		}
		
		System.out.println("The Number of Cells Searched are " + seekAcc);
		System.out.println("BattleShip has been found: " + BSHead + " to " + BSTail + " SubShip has been found: " + SSHead + " to " + SSTail + "\n");
	}
}
