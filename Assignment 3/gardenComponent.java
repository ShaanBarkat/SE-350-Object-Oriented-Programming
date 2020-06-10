// interface perhaps, need move()/ getlocation()
import javafx.geometry.Point2D;

public interface gardenComponent {
	public Point2D getLocation();
	public void move(double deltaX, double deltaY);
}
