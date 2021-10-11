
// The purpose of this program is making a puzzle game.
// You have to click on the tile that you want to move and release the mouse to on the tile that is your target tile.
// Please do not run the game from this class you should run the program from TestForMovement Class.
package application;

import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import application.Main.subclass_ImageView;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
	
	}

public boolean checkLevelCompleted(int level, Pane pane, subclass_ImageView[] nodes ) {
	
	switch(level) {
	
	case 1:{
		
		int point = 0;
		for(int i = 1 ; i < 17 ; i++) {
			
			
			
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
					point = point + 1;
				}					
			}
			
		}
		if(point == 4) {
			System.out.println("*******LEVEL 1 COMPLETED********");
			return true;
		}
		
		
	};
	
	case 2:{
		
		int point = 0;
		for(int i = 1 ; i < 17 ; i++) {
			
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
					point = point + 1;
				}					
			}

		}
		if(point == 4) {
			System.out.println("*******LEVEL 2 COMPLETED********");
			return true;
		}
		
	}
	case 3:{
		int point = 0;
		for(int i = 1 ; i < 17 ; i++) {
			
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
					point = point + 1;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
					point = point + 1;
				}					
			}

		}
		if(point == 4) {
			System.out.println("*******LEVEL 3 COMPLETED********");
			return true;
		}
		
	}
	case 4:{
		int point = 0;
		for(int i = 1; i < 17; i++) {
			if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 101 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 202 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(CURVEDPIPE_00)) {
				if(nodes[i].getX() == 303 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
		}
		if(point == 4) {
			System.out.println("*******LEVEL 4 COMPLETED********");
			return true;
		}
		
		
	}
		
	case 5:{
		int point = 0;
		for(int i = 1; i < 17; i++) {
			if(nodes[i].getImage().equals(PIPE_V)) {
				if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 101 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(PIPE_H)) {
				if(nodes[i].getX() == 202 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
			if(nodes[i].getImage().equals(CURVEDPIPE_00)) {
				if(nodes[i].getX() == 303 && nodes[i].getY() == 202) {
					point = point + 1 ;
				}
			}
		}
		if(point == 4) {
			System.out.println("*******LEVEL 5 COMPLETED********");
			return true;
		}
		
		
	}
}
	return false;
	
		
}

// ******************* LEVEL INPUT **********************************

	final Image STARTER_V = (new Image("application/images/StarterV.png"));
	final Image STARTER_H = (new Image("application/images/StarterH.png"));
	final Image END_V = (new Image("application/images/EndV.png"));
	final Image END_H = (new Image("application/images/EndH.png"));
	final Image EMPTYFREE = (new Image("application/images/EmptyFree.png"));
	final Image EMPTY = (new Image("application/images/Empty.png"));
	final Image PIPESTATIC_V = (new Image("application/images/PipeStaticV.png"));
	final Image PIPESTATIC_H = (new Image("application/images/PipeStaticH.png"));
	final Image PIPE_H = (new Image("application/images/PipeV.png")); // Kendisi Ters alýyor
	final Image PIPE_V = (new Image("application/images/PipeH.png")); // Kendisi Ters alýyor
	final Image CURVEDPIPE_00 = (new Image("application/images/CurvedPipe00.png"));
	final Image CURVEDPIPE_01 = (new Image("application/images/CurvedPipe01.png"));
	final Image CURVEDPIPE_10 = (new Image("application/images/CurvedPipe10.png"));
	final Image CURVEDPIPE_11 = (new Image("application/images/CurvedPipe11.png"));
	final Image CURVEDPIPESTATIC_00 = (new Image("application/images/CurvedPipeStatic00.png"));
	final Image CURVEDPIPESTATIC_01 = (new Image("application/images/CurvedPipeStatic01.png"));
	final Image CURVEDPIPESTATIC_10 = (new Image("application/images/CurvedPipeStatic10.png"));
	final Image CURVEDPIPESTATIC_11 = (new Image("application/images/CurvedPipeStatic11.png"));
	
	
	
	
	public class subclass_ImageView extends ImageView {				///creating a subclass that extends imageview , to add new methods such as canMove or moveOnMe.

		public subclass_ImageView() {
			super();
			// TODO Auto-generated constructor stub
		}

		public subclass_ImageView(Image arg0) {
			super(arg0); 
			// TODO Auto-generated constructor stub
		}

		public subclass_ImageView(String arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}
		
		public boolean moveOnMe(subclass_ImageView node) {       //indicate tiles that can move on this tile
			if(node.getImage().equals(STARTER_V)) {       
			//	System.out.println("false");
				return false;
			}
			if(node.getImage().equals(STARTER_H)) {
			//	System.out.println("false");
				return false;
			}
			if(node.getImage().equals(END_V)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(END_H)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(EMPTYFREE)) {
//				System.out.println("false");
				return true;                                   /// only true in this method
			}
			if(node.getImage().equals(EMPTY)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(PIPESTATIC_V)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(PIPESTATIC_H)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(PIPE_H)) {
			//	System.out.println("true");
				return false;
			}
			if(node.getImage().equals(PIPE_V)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPE_00)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPE_01)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPE_10)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPE_11)) {
//				System.out.println("true");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_00)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_01)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_10)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_11)) {
//				System.out.println("false");
				return false;
			}
			else {
				return false;
			}
			
			
		}
		
		public boolean can_Move(subclass_ImageView node) {       //indicate tiles that can move
			if(node.getImage().equals(STARTER_V)) {       
			//	System.out.println("false");
				return false;
			}
			if(node.getImage().equals(STARTER_H)) {
			//	System.out.println("false");
				return false;
			}
			if(node.getImage().equals(END_V)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(END_H)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(EMPTYFREE)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(EMPTY)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(PIPESTATIC_V)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(PIPESTATIC_H)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(PIPE_H)) {
			//	System.out.println("true");
				return true;
			}
			if(node.getImage().equals(PIPE_V)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(CURVEDPIPE_00)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(CURVEDPIPE_01)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(CURVEDPIPE_10)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(CURVEDPIPE_11)) {
//				System.out.println("true");
				return true;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_00)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_01)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_10)) {
//				System.out.println("false");
				return false;
			}
			if(node.getImage().equals(CURVEDPIPESTATIC_11)) {
//				System.out.println("false");
				return false;
			}
			else {
				return true;
			}
			
			
		}
		
	}
	
	Image[] tilesOfCurrentLevelList = new Image[17];

	public void createLevel(int i) throws FileNotFoundException {   // This method is making an array using the level.txt input files.

		Scanner input = new Scanner(
				new File("application/level"+i+".txt"));

		input.useDelimiter(",");

		while (input.hasNext()) {

			int id = input.nextInt();
			String type = input.next();
			String property = input.nextLine(); // iflerde ,Vercital vs.

			switch (type) {

			case "Starter":
				if (property.equals(",Vertical")) {					
					tilesOfCurrentLevelList[id] = STARTER_V;
					
				} else {
					tilesOfCurrentLevelList[id] = STARTER_H;
				}

				break;

			case "End":
				if (property.equals(",Vertical")) {
					tilesOfCurrentLevelList[id] = END_V;
				} else {
					tilesOfCurrentLevelList[id] = END_H;
				}

				break;

			case "Empty":
				if (property.equals(",none")) {
					tilesOfCurrentLevelList[id] = EMPTY;
				} else {
					tilesOfCurrentLevelList[id] = EMPTYFREE;
				}

				break;

			case "Pipe":
				if (property.equals(",Vertical")) {
					tilesOfCurrentLevelList[id] = PIPE_V;
				}

				if (property.equals(",Horizontal")) {
					tilesOfCurrentLevelList[id] = PIPE_H;
				}

				if (property.equals(",01")) {
					tilesOfCurrentLevelList[id] = CURVEDPIPE_01;
				}
				if (property.equals(",00")) {
					// CURVEDPIPE.setRotate(-90);
					tilesOfCurrentLevelList[id] = CURVEDPIPE_00;
					// CURVEDPIPE.setRotate(90);

				}
				if (property.equals(",11")) {
					// CURVEDPIPE.setRotate(90);
					tilesOfCurrentLevelList[id] = CURVEDPIPE_11;
					// CURVEDPIPE.setRotate(-90);

				}
				if (property.equals(",10")) {
					// CURVEDPIPE.setRotate(180);
					tilesOfCurrentLevelList[id] = CURVEDPIPE_10;
					// CURVEDPIPE.setRotate(-180);

				}

				break;

			case "PipeStatic":
				if (property.equals(",Vertical")) {
					tilesOfCurrentLevelList[id] = PIPESTATIC_V;
				}
				if (property.equals(",Horizontal")) {
					tilesOfCurrentLevelList[id] = PIPESTATIC_H;

				}
				if (property.equals(",01")) {
					tilesOfCurrentLevelList[id] = CURVEDPIPESTATIC_01;
				}
				if (property.equals(",11")) {
					// CURVEDPIPESTATIC.setRotate(90);
					tilesOfCurrentLevelList[id] = CURVEDPIPESTATIC_11;
					// CURVEDPIPESTATIC.setRotate(-90);

				}
				if (property.equals(",10")) {
					// CURVEDPIPESTATIC.setRotate(180);
					tilesOfCurrentLevelList[id] = CURVEDPIPESTATIC_10;
					// CURVEDPIPESTATIC.setRotate(-180);
				}
				if (property.equals(",00")) {
					// CURVEDPIPESTATIC.setRotate(-90);
					tilesOfCurrentLevelList[id] = CURVEDPIPESTATIC_00;
					// CURVEDPIPESTATIC.setRotate(90);

				}
				break;

			}
		}

	}
	

	public static void main(String[] args) {

		launch(args);

	}
}
