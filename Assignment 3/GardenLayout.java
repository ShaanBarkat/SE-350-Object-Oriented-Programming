// gui stuff, scene pane ect. 
// need a handle function, to control mouse functions - practice mouse functions
// mouse released and the goooods
// start to show the stage etc...
// need the components for the "garden" 

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;


public class GardenLayout extends Application{
	Scene scene;
	Pane root;
	gardenComponent shape; 
	Point2D last_position = null;
	private final int rectangle_width = 150;
	private final int rectangle_height = 150;
	private final double bbCircle = 12;
	boolean inDragMode = false;
	ArrayList<gardenComponent> Shapes = new ArrayList<>();
	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

private gardenComponent getShape(Point2D poi) {
	Iterator<gardenComponent> iter = Shapes.iterator();
	gardenComponent giver = null;
	
	while(iter.hasNext()) {
		gardenComponent var = iter.next();
		
		if(var instanceof FlowerBed) {
			if(((FlowerBed) var).contains(poi))
				giver = var;
		}
		if(var instanceof Flower) {
			if(((Flower) var).contains(poi))
				giver = var;
		}
	}
	return giver;
}
@Override	
public void handle (MouseEvent Event) {
	Point2D click = new Point2D(Event.getX(), Event.getY());
	String eventName = Event.getEventType().getName();
	
	if (inDragMode == false)
		shape = getShape(click);
			
	switch (eventName) {	
	case ("MOUSE_DRAGGED"):
		inDragMode = true;
	
	if(shape != null && last_position != null) {
		double deltaX = click.getX() - last_position.getX();
		double deltaY = click.getY() - last_position.getY();
		shape.move(deltaX, deltaY);
	}
	break;
			
	case("MOUSE_RELEASED"):
		if (shape == null) {
			if(Event.getButton() == MouseButton.PRIMARY) {
				Flower circle = new Flower(click,bbCircle,Color.BLACK);
				Shapes.add(circle);
				root.getChildren().add(circle);
				}
			if(Event.getButton() == MouseButton.SECONDARY) {
				FlowerBed rectangle = new FlowerBed(click.getX(), click.getY(), rectangle_width, rectangle_height);
				Shapes.add(rectangle);
				root.getChildren().add(rectangle);
			}	
		}
		else if(shape != null && shape instanceof Flower) {
			Iterator<gardenComponent> iter = Shapes.iterator();
			while(iter.hasNext()) {
				gardenComponent comp = iter.next();
				if(comp instanceof FlowerBed && ((FlowerBed) comp).contains(click)) {
						((FlowerBed) comp).addCircle(shape);
						break;
						}
				}
			}
		inDragMode=false;
		break;
				
		}
		last_position = click;
	}
};



@Override
public void start(Stage stage) throws Exception {
	root = new AnchorPane();
	scene = new Scene(root,500,500);
	scene.setFill(Color.WHITE);
	scene.setOnMouseDragged(mouseHandler);
	scene.setOnMouseReleased(mouseHandler);
	scene.setOnMousePressed(mouseHandler);
	stage.setScene(scene);
	stage.show();
	
}


public static void main(String[] args) {
	launch(args);
}	
}

