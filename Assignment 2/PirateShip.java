//make sure to add observer **ask about overlapping of pirates and player -- how reset button works
import java.util.Observable;
import java.util.Observer;
import java.awt.Point;


public class PirateShip implements Observer, Ship {
	
	Point curr;
	Point targ;
	
	Point[] islands;
	Point[] pirates;
	
	public PirateShip() {
		curr = new Point((int)( Math.random()*10), (int) (Math.random()*10));
	}
	
	public Point getShipLocation(){
		 return curr;
	}
	
	public void addIslands(Point[] islands) {
		this.islands = islands;
	}
	
	public boolean checkIslands(Point target) {
		for (Point island : islands) {
			if (island.x == target.x && island.y == target.y) return false;
		}
		
		return true;
	}
	
	public void addPirates(Point[] pirates) {
		this.pirates = pirates;
	}
	
	public boolean checkPirates(Point target2) {
		for (Point pirates : pirates) {
			if (pirates.x == target2.x && pirates.y == target2.y) return false;
		}
		return true;
	}
	
	public void goNorth() {
		if (curr.getY() != 0 && checkIslands(new Point(curr.x, curr.y - 1))) 
			curr.setLocation(curr.getX(), curr.getY()-1);
		
	}
	public void goSouth() {
		if (curr.getY() != 9 && checkIslands(new Point(curr.x, curr.y + 1))) 
			curr.setLocation(curr.getX(), curr.getY()+1);
		
	}

	public void goEast() {
		if (curr.getX() != 9 && checkIslands(new Point(curr.x + 1, curr.y)))
			curr.setLocation(curr.getX()+1, curr.getY());
		
	}
	public void goWest() {
		if (curr.getX() != 0 && checkIslands(new Point(curr.x - 1, curr.y))) curr.setLocation(curr.getX()-1, curr.getY());
		
	}

	public void update(Observable x, Object n) {
		if (x instanceof Ship) {
			targ = ((Ship) x).getShipLocation();
			if (targ.y+1 < curr.y) goNorth();
			else if (targ.y > curr.y+1) goSouth();
			else if (targ.x+1 < curr.x) goWest();
			else if (targ.x > curr.x+1) goEast();
		}
		
	}

}