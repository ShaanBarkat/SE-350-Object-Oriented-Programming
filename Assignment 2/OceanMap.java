import java.awt.Point;

public class OceanMap {
	final int dimensions = 50;
	
	final static int ISLAND_COUNT = 10;
	//10 islands
	final static int PIRATE_COUNT = 3;
	//3 pirates
	
	PlayerShip mainship;
	boolean[][] Grid;
	
	PirateShip[] pirates = new PirateShip[PIRATE_COUNT];
	Point[] islands = new Point[ISLAND_COUNT];
	
	public OceanMap() {
		Grid = new boolean[10][10];
		mainship = new PlayerShip();
		for (int i = 0; i < pirates.length; i++){
			pirates[i] = new PirateShip();
		}
		for (int i = 0; i < islands.length; i++){
			islands[i] = new Point((int)( Math.random()*10), (int) (Math.random()*10));
		}
		for (PirateShip e : pirates){
			mainship.addObserver(e);
		}
		

		mainship.addIslands(islands);
		for (PirateShip e : pirates){
			e.addIslands(islands);
		}
		

	}
	public boolean[][] getMap(){
		return Grid;
	}
	
	public int getGrid(){
		return Grid.length;
	}
	
	public PlayerShip getPlayer() {
		return mainship;
	}
	
	public PirateShip[] getPirates() {
		return pirates;
	}
	
	public Point[] getIslands() {
		return islands;
	}
	
	

}