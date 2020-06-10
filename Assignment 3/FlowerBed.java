//need move, addcircle, the flowerbed 00 square, need a way to creat random color
// check circle!! and make sure to add a getlocale
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;


public class FlowerBed extends Rectangle implements gardenComponent{
	ArrayList<gardenComponent> circlesInside = new ArrayList<>();
	Color color;
	Random GenColor = new Random();
	
	public FlowerBed(double x, double y, int w, int h) {
		super(x,y,w,h);
		this.color = RandomColor();
		this.setStrokeWidth(6);
		this.setStroke(this.color);
		this.setFill(Color.TRANSPARENT);
	}
	

	//generate random colors 
	// for the different squares
	public Color RandomColor() {
		float rand1  = GenColor.nextFloat();
		float rand2 = GenColor.nextFloat();
		float rand3 = GenColor.nextFloat();
		float rand4 = GenColor.nextFloat();
	
		while(rand1 == 1.0 || rand2 == 1.0  || rand3 == 1.0 ) {
			rand1  = GenColor.nextFloat();
			rand2  = GenColor.nextFloat();
			rand3  = GenColor.nextFloat();
		}
	
		return new Color(rand1, rand2, rand3, rand4);		
	}

	@Override
	public Point2D getLocation() {
		return new Point2D(this.getX(), this.getY());
	}
	///drag color change, once flower in garden, color change accordingly
	public void addCircle(gardenComponent circle) {
		circlesInside.add(circle);
		Iterator<gardenComponent> changeCircle = circlesInside.iterator();
		while(changeCircle.hasNext()) {
			gardenComponent c = changeCircle.next();
			if(c instanceof Flower) ((Flower)c).ChangeColor(this.color);
		}
		
	}
	
	public boolean CheckCircle(gardenComponent circle) {
		if(circle instanceof Flower) {
			if(this.contains(((Flower) circle).getCenterX(), ((Flower) circle).getCenterY())){
				return true;
			}
		}
		return false;
	}
	@Override
	public void move(double deltaX, double deltaY) {
		this.setX(this.getX() + deltaX);
		this.setY(this.getY() + deltaY);
		Iterator<gardenComponent> iter = circlesInside.iterator();
		while(iter.hasNext()) {
			gardenComponent circle = iter.next();
			if(circle instanceof Flower) ((Flower) circle).move(deltaX, deltaY);
 		}
	}
	
}
