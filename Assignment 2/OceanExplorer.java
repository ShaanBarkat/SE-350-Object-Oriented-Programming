//application -- gui stuff -- main function -- start -- images
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.File;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;



public class OceanExplorer extends Application {
	final int size = 50;
	OceanMap ocean;
	Scene scene;
	AnchorPane root;
	Image shipi, islandi, piratei;
	ImageView shipImageView;
	ImageView[] islandImageView, pirateImageView;
	
	public OceanExplorer() {
		ocean = new OceanMap();
		
		pirateImageView = new ImageView[ocean.getPirates().length];
		islandImageView = new ImageView[ocean.getIslands().length];
		// JavaFX Setup
		root = new AnchorPane();
		for(int x = 0; x < ocean.getGrid(); x++){
			for(int y = 0; y < ocean.getGrid(); y++){
				Rectangle rect = new Rectangle(x*size, y*size, size, size);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);
			}
		}
		
		// Draw Islands
		for (int i = 0; i < ocean.getIslands().length; i++) {
			Rectangle rect = new Rectangle(ocean.getIslands()[i].x*size, ocean.getIslands()[i].y*size, size, size);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.GREEN);
			root.getChildren().add(rect);
		}
	}
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Stage oceanStage = arg0;
		scene = new Scene(root, 500, 500); 
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus");
		oceanStage.show();
		loadImages();
		startSailing();
		

	}
	public void loadImages() {
	//Create player - issue with loading in picture!
		//Image shipImage = new Image("src\\ship.png", 50, 50, true, true); 
		File f = new File("src\\ship.png");
		shipi = new Image(f.toURI().toString()); 
		//ImageView shipImageView = new ImageView(shipImage);
		shipImageView = new ImageView(shipi);
		shipImageView.setImage(shipi);
		shipImageView.setFitHeight(50); 
		shipImageView.setFitWidth(50);
		shipImageView.setX(ocean.getPlayer().getShipLocation().x * size);
		shipImageView.setY(ocean.getPlayer().getShipLocation().y * size);
		root.getChildren().add(shipImageView);
		
		File nff = new File("src\\pirateShip.png");
		//Image pirateImage = new Image("src\\pirateShip.png", 50, 50, true, true);
		piratei = new Image(nff.toURI().toString());
		for (int i = 0; i < ocean.getPirates().length; i++) {
			pirateImageView[i] = new ImageView(piratei);
			pirateImageView[i].setFitHeight(50); 
			pirateImageView[i].setFitWidth(50);
			pirateImageView[i].setX(ocean.getPirates()[i].getShipLocation().x * size);
			pirateImageView[i].setY(ocean.getPirates()[i].getShipLocation().y * size);
			root.getChildren().add(pirateImageView[i]);
		}
	
		File nf = new File("src\\island.png");
		//Image islandImage = new Image("src\\island.png", 50, 50, true, true);
		islandi = new Image(nf.toURI().toString());
		for (int i = 0; i < ocean.getIslands().length; i++) {
			islandImageView[i] = new ImageView(islandi);
			islandImageView[i].setFitHeight(50); 
			islandImageView[i].setFitWidth(50);
			islandImageView[i].setX(ocean.getIslands()[i].x * size);
			islandImageView[i].setY(ocean.getIslands()[i].y * size);
			root.getChildren().add(islandImageView[i]);
		}
	}
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
			switch(ke.getCode()){
			 	case RIGHT:
			 		ocean.getPlayer().goEast();
			 		break;
			 	case LEFT:
			 		ocean.getPlayer().goWest();
			 		break;
			 	case UP:
			 		ocean.getPlayer().goNorth();
			 		break;
			 	case DOWN:
			 		ocean.getPlayer().goSouth();
			 		break;
			 	default:
			 		break;
			 }
			 updateShips();                
			}
		});
	}
	
	private void updateShips() {
		// check movement of my keystrokes and ships
		System.out.println(ocean.getPlayer().getShipLocation().x + "/" + ocean.getPlayer().getShipLocation().y);
		shipImageView.setX(ocean.getPlayer().getShipLocation().x*size);
		shipImageView.setY(ocean.getPlayer().getShipLocation().y*size);
		for (int i = 0; i < ocean.getPirates().length; i++) {
			System.out.println("[" + i + "]" + ocean.getPirates()[i].getShipLocation().x  + "/" + ocean.getPirates()[i].getShipLocation().y);
			pirateImageView[i].setX(ocean.getPirates()[i].getShipLocation().x * size);
			pirateImageView[i].setY(ocean.getPirates()[i].getShipLocation().y * size);
		 }
	}
}
	
