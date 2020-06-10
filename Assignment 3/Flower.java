// create flower---add circle (extend) --> implement components 
// need the flower to change color in correspondance with it location - flower -> square = same color
// ** ask/research about point2D 															-- iffy ~ mothersday coming up**
// Grader: Thanks for all the notes on previous assignments, been a great help and I learned a lot from them. Haven't
// had this many comments on an assignment ever, just wanted to give a little thanks lol.  
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower extends Circle implements gardenComponent{
Color circleColor;

public Flower(Point2D poi, double ran, Color col) {
	
	super(poi.getX(), poi.getY(), ran);
	this.circleColor = col;
	this.setFill(circleColor);
}

@Override
public Point2D getLocation() {
	Point2D poi = new Point2D(this.getCenterX(), this.getCenterY());
	return poi;
}

public void ChangeColor(Color col) {
	this.setFill(col);
}
@Override
public void move(double deltaX, double deltaY) {
	this.setCenterX(this.getCenterX()+deltaX);
	this.setCenterY(this.getCenterY()+deltaY);
	}
}
