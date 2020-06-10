//player ship - movement in relation to islands --- make sure its observable!!
import java.util.Observable;
import java.awt.Point;


public class PlayerShip extends Observable implements Ship {
	
	Point curr;
	
	Point[] islands;
	Point[] pirates;
	
	//use example shown in class
	public PlayerShip() {
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
			if (pirates.x == curr.x && pirates.y == curr.y) return false;
		}
		return true;
	}
	
	public void goNorth() {
		if (curr.y != 0 && checkIslands(new Point(curr.x, curr.y - 1)))
			curr.setLocation(curr.x, curr.y-1);
		setChanged();
		notifyObservers();
		
	}
	public void goSouth() {
		if (curr.y != 9 && checkIslands(new Point(curr.x, curr.y + 1)))
			curr.setLocation(curr.x, curr.y+1);
		setChanged();
		notifyObservers();
	}

	public void goEast() {
		if (curr.x != 9 && checkIslands(new Point(curr.x + 1, curr.y)))
			curr.setLocation(curr.x+1, curr.y);
		setChanged();
		notifyObservers();
	}
	public void goWest() {
		if (curr.x != 0 && checkIslands(new Point(curr.x - 1, curr.y))) 
			curr.setLocation(curr.x-1, curr.y);
		setChanged();
		notifyObservers();
	}
	


}
