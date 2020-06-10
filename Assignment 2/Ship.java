//add interface ~~ movement, island ect
import java.awt.Point;

public interface Ship {
	
	public void addIslands(Point[] islands);
	public boolean checkIslands(Point target);
	
	public void addPirates(Point[] pirares);
	public boolean checkPirates(Point target2);
	
	public Point getShipLocation();
	
	public void goNorth();
	public void goSouth();
	public void goEast();
	public void goWest();

}

