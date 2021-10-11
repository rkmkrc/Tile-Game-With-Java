
// The purpose of this program is making a puzzle game.
// You have to click on the tile that you want to move and release the mouse to on the tile that is your target tile.
// Please run program from this (TestForMovement) class.

package application;

import java.io.FileNotFoundException;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.sun.corba.se.pept.transport.EventHandler;

import application.Main.subclass_ImageView;
import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestForMovement extends Main {
	public void start(Stage primaryStage) throws FileNotFoundException {
	
	
		StackPane startingPane = new StackPane();
		Button button = new Button("Start Game");
		button.setAlignment(Pos.CENTER);
		startingPane.getChildren().add(button);
		
		Scene startingScene = new Scene(startingPane,403,403);
		primaryStage.setScene(startingScene);
		primaryStage.setTitle("Tile Game");
		primaryStage.show();
		
		button.setOnMouseClicked(e->{
			Stage window = new Stage();
			window = primaryStage;
			try {
				createLevel(1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Scene scene = new Scene(printLevel(window,1), 403, 403);
			
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		});
		
		

	}
	
	public PathTransition animation123(Stage window,Pane pane,int[] check) {  // This is the animation for level1-2-3
		Circle circle = new Circle(0, 0, 10);
	    circle.setFill(Color.GOLD);
	    
	    
	    Polyline polyline = new Polyline();
	    polyline.setOpacity(0);
	    polyline.getPoints().addAll(new Double[]{
	        50.0, 30.0,
	        50.0, 340.0,
	        60.0, 353.0,
	        380.0, 353.0 });
	    
	    // Add circle and rectangle to the group
	    pane.getChildren().addAll(polyline);
	    pane.getChildren().add(circle);
	   
	    // Create a path transition 
	    PathTransition pt = new PathTransition();
	    pt.setDuration(Duration.millis(4000));
	    pt.setPath(polyline);
	    pt.setNode(circle);
	    pt.setOrientation(
	      PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	    pt.setCycleCount(1);
	    pt.setAutoReverse(false);   
	    pt.setDuration(new Duration(4000));
	    pt.play(); // Start animation 
	    return pt;
		
	}
	public PathTransition animation45(Stage window,Pane pane,int[] check) {  // This is the animation for level4-5
		Circle circle = new Circle(0, 0, 10);
	    circle.setFill(Color.GOLD);
	    
	    
	    Polyline polyline = new Polyline();
	    polyline.setOpacity(0);
	    polyline.getPoints().addAll(new Double[]{
	        50.0, 30.0,
	        50.0, 240.0,
	        60.0, 253.0,
	        353.0, 253.0,
	        
	        353.0,130.0
	        });
	    
	    // Add circle 
	    pane.getChildren().addAll(polyline);
	    pane.getChildren().add(circle);
	   
	    // Create a path transition 
	    PathTransition pt = new PathTransition();
	    pt.setDuration(Duration.millis(4000));
	    pt.setPath(polyline);
	    pt.setNode(circle);
	    pt.setOrientation(
	      PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
	    pt.setCycleCount(1);
	    pt.setAutoReverse(false);   
	    pt.setDuration(new Duration(4000));
	    pt.play(); // Start animation 
	    return pt;
		
	}
	public Pane printLevel(Stage window,int checkNum) {
		Pane pane = new Pane();
		
		// pane.setVgap(5);
		// pane.setHgap(5);

		int x = 0;
		int y = -1;
		subclass_ImageView[] nodes = new subclass_ImageView[17];
		
		int[] movement = new int[1];			// for movement number
		movement[0] = 0;
		int[] check = new int[1];
		check[0] = checkNum ;
		
		for (int i = 1; i < 17; i++) {

			if (x > 3 || x == 0) {
				x = 0;
				y += 1;
			}
			if (y > 3) {
				y = 0;
			}
			subclass_ImageView iw = new subclass_ImageView(tilesOfCurrentLevelList[i]);
			iw.setX(x * 101);
			iw.setY(y * 101);
			pane.getChildren().add(iw);
			nodes[i] = iw;
			x += 1;
			
			
			
			
			wantToGo(iw, nodes, pane, movement,window,check);
			 

		}
	
		
		pane.setStyle("-fx-background-color: white;");
		return pane;

	}

	public void movement( Pane pane, int movement) {					//This method aims printing movement number
		
		Rectangle rectangle = new Rectangle(308,10,91,17);
		rectangle.setArcHeight(10);
		rectangle.setArcWidth(10);
		Text text2 = new Text("Movements:" + movement );
		text2.setX(316);
		text2.setY(22);
		text2.setFill(Color.WHITE);
		pane.getChildren().add(rectangle);
		pane.getChildren().add(text2);
		
		
	
	}
	public boolean checkLevelCompleted(int[] check, Pane pane, subclass_ImageView[] nodes ) { // This checks the level if level is completed.
		
		
		switch(check[0]) {
		
		case 1:{
			
			int point1 = 0;
			for(int i = 1 ; i < 17 ; i++) {
				
				
				
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
						point1 = point1 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
						point1 = point1 + 1;
					}
				}
				if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
						point1 = point1 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
						point1 = point1 + 1;
					}					
				}
				if(nodes[i].getImage().equals(PIPESTATIC_H)) {
					if(nodes[i].getX() == 303 && nodes[i].getY() == 202) {
						point1 = point1 + 1;
					}					
				}
				
			}
			if(point1 == 5) {
				System.out.println("*******LEVEL 1 COMPLETED********");
				return true;
				
			}
			
			
		}
		
		case 2:{
			
			int point2 = 0;
			for(int i = 1 ; i < 17 ; i++) {
				
				if(nodes[i].getImage().equals(STARTER_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 0) {
						point2 = point2 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
						point2 = point2 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
						point2 = point2 + 1;
					}
				}
				if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
						point2 = point2 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
						point2 = point2 + 1;
					}					
				}
	
			}
			if(point2 == 5) {
				System.out.println("*******LEVEL 2 COMPLETED********");
				return true;
			}
			
		}
		case 3:{
			int point3 = 0;
			for(int i = 1 ; i < 17 ; i++) {
				
				if(nodes[i].getImage().equals(STARTER_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 0) {
						point3 = point3 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
						point3 = point3 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
						point3 = point3 + 1;
					}
				}
				if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 303) {
						point3 = point3 + 1;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 101 && nodes[i].getY() == 303) {
						point3 = point3 + 1;
					}					
				}
				if(nodes[i].getImage().equals(END_H)) {
					if(nodes[i].getX() == 303 && nodes[i].getY() == 303) {
						point3 = point3 + 1;
					}
				}
	
			}
			if(point3 == 6) {
				System.out.println("*******LEVEL 3 COMPLETED********");
				return true;
			}
			
		}
		case 4:{
			int point4 = 0;
			for(int i = 1; i < 17; i++) {
				if(nodes[i].getImage().equals(CURVEDPIPE_01)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 202) {
						point4 = point4 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 101 && nodes[i].getY() == 202) {
						point4 = point4 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 202 && nodes[i].getY() == 202) {
						point4 = point4 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(CURVEDPIPE_00)) {
					if(nodes[i].getX() == 303 && nodes[i].getY() == 202) {
						point4 = point4 + 1 ;
					}
				}
			}
			if(point4 == 4) {
				System.out.println("*******LEVEL 4 COMPLETED********");
				return true;
			}
			
			
		}
			
		case 5:{
			int point5 = 0;
			for(int i = 1; i < 17; i++) {
				if(nodes[i].getImage().equals(PIPE_V)) {
					if(nodes[i].getX() == 0 && nodes[i].getY() == 101) {
						point5 = point5 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 101 && nodes[i].getY() == 202) {
						point5 = point5 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(PIPE_H)) {
					if(nodes[i].getX() == 202 && nodes[i].getY() == 202) {
						point5 = point5 + 1 ;
					}
				}
				if(nodes[i].getImage().equals(CURVEDPIPE_00)) {
					if(nodes[i].getX() == 303 && nodes[i].getY() == 202) {
						point5 = point5 + 1 ;
					}
				}
			}
			if(point5 == 4) {
				System.out.println("*******LEVEL 5 COMPLETED********");
				return true;
			}
			
			
		}
	}
		return false;
		
			
}
	
	
	
	
	
	public void wantToGo(subclass_ImageView iw, subclass_ImageView[] nodes , Pane pane,int[] movement, Stage window, int[] check) { 
		
	//	This method is most important method because there are lots of methods are running in there
	//  After every movement operation this method check is level completed, if level completed then run animation etc.	
		movement[0] = 0;
		
				 
		iw.setOnMousePressed((e -> {
			iw.setOnMouseReleased(p -> {
				
				System.out.println("Chekck is : "+ check[0]);
				
				////////////////// About UP
				if (((Math.abs(p.getX() - e.getX()) < 100))
						&& ((-200 < (p.getY() - e.getY())) && (p.getY() - e.getY()) < -86)) { // 86 for dont to reach // out of border
					
					System.out.println("ifin içi");
					if (iw.can_Move(iw)) {
						
						for (int i = 1; i < 17; i++) { // target node
							int key = 0;
							

							if ((nodes[i].getX() == iw.getX()) && (nodes[i].getY() == iw.getY() - 101) && (p.getY() < 403) && nodes[i].moveOnMe(nodes[i])) {
								nodes[i].setY(nodes[i].getY() + 101);
								key = 1;
							}
							if ((p.getY() > 0) && key == 1) { // can not move up
								iw.setX(iw.getX());
								iw.setY(iw.getY() - 101);
								
								
								movement[0] = movement[0] + 1; 						
								movement(pane,movement[0]);
								//***************************************************************************************************************//	
								
								if(checkLevelCompleted(check[0], pane, nodes)) {
									if(check[0] == 1 || check[0] == 2 || check[0] == 3 ) {
										
										animation123(window, pane, check);
										
										animation123(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
										});

										
										
									}
									if(check[0] == 4 || check[0] == 5 ) {
										
										animation45(window, pane, check);
										
										animation45(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												
												
												
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											int end = 0;
											if(check[0] == 6) {
												System.out.println("buraya girdi");
												
												
												Rectangle endRec = new Rectangle(0,0,403,403);          // Ending Scene
												endRec.setFill(Color.WHITE);									
												Button btExit = new Button("Exit Game");
												btExit.setTranslateX(170);
												btExit.setTranslateY(180);
												pane.getChildren().addAll(endRec,btExit);
												
												end = 1;
												btExit.setOnMouseClicked(t -> {
													window.close();
												});
											}
											
											if(end != 1) {
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
											}
											
										});

										
										
									}
									
								}
							
								
								
								break;
							}

							System.out.println("Node(" + i + ") " + nodes[i].getX() + "   " + nodes[i].getY());
						}

					}
				}

				/////////////// About DOWN
				if (((Math.abs(p.getX() - e.getX()) < 100))
						&& ((86 < (p.getY() - e.getY())) && (p.getY() - e.getY()) < 200)) {
					System.out.println("ifin içi");
					if (iw.can_Move(iw)) {
						for (int i = 1; i < 17; i++) { // yerine geçilecek node
							int key = 0;
							if ((nodes[i].getX() == iw.getX()) && (nodes[i].getY() == iw.getY() + 101  && nodes[i].moveOnMe(nodes[i]))
									&& (p.getY() < 403)) {
								nodes[i].setY(nodes[i].getY() - 101);
								key = 1;
							}
							if ((p.getY() < 403) && key == 1) { // aþagý gidemesin
								iw.setX(iw.getX());
								iw.setY(iw.getY() + 101);
								
								movement[0] = movement[0] + 1; 						
								movement(pane,movement[0]);
								//***************************************************************************************************************//	
								
								if(checkLevelCompleted(check[0], pane, nodes)) {
									if(check[0] == 1 || check[0] == 2 || check[0] == 3 ) {
										
										animation123(window, pane, check);
										
										animation123(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											int end = 0;
											if(check[0] == 6) {
												System.out.println("buraya girdi");
												
												
												Rectangle endRec = new Rectangle(0,0,403,403);
												endRec.setFill(Color.WHITE);									
												Button btExit = new Button("Exit Game");
												btExit.setTranslateX(170);
												btExit.setTranslateY(180);
												pane.getChildren().addAll(endRec,btExit);
												
												end = 1;
												btExit.setOnMouseClicked(t -> {
													window.close();
												});
											}
											
											if(end != 1) {
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
											}
										});

										
										
									}
									if(check[0] == 4 || check[0] == 5 ) {
										
										animation45(window, pane, check);
										
										animation45(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											int end = 0;
											if(check[0] == 6) {
												System.out.println("buraya girdi");
												
												
												Rectangle endRec = new Rectangle(0,0,403,403);
												endRec.setFill(Color.WHITE);									
												Button btExit = new Button("Exit Game");
												btExit.setTranslateX(170);
												btExit.setTranslateY(180);
												pane.getChildren().addAll(endRec,btExit);
												
												end = 1;
												btExit.setOnMouseClicked(t -> {
													window.close();
												});
											}
											
											if(end != 1) {
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
											}
										});

										
										
									}
									
								}
								
								
								break;
							}
							System.out.println("Node(" + i + ") " + nodes[i].getX() + "   " + nodes[i].getY());
						}
						
					}

				}
				/////////////// About RIGHT
				if ((86 < (p.getX() - e.getX()) && ((p.getX() - e.getX()) < 200))
						&& (Math.abs(p.getY() - e.getY()) < 100)) {
					System.out.println("ifin içi");
					if (iw.can_Move(iw)) {
						for (int i = 1; i < 17; i++) { // yerine geçilecek node
							int key = 0;
							if ((nodes[i].getX() == iw.getX() + 101) && (nodes[i].getY() == iw.getY()  && nodes[i].moveOnMe(nodes[i]))
									&& (p.getX() < 403)) {
								nodes[i].setX(nodes[i].getX() - 101);
								key = 1;
							}
							if ((p.getX() < 403) && key == 1) { // Saga gidemesin
								iw.setX(iw.getX() + 101);
								iw.setY(iw.getY());
								
								movement[0] = movement[0] + 1; 						
								movement(pane,movement[0]);
								//***************************************************************************************************************//	
								
								if(checkLevelCompleted(check[0], pane, nodes)) {
									if(check[0] == 1 || check[0] == 2 || check[0] == 3 ) {
										
										animation123(window, pane, check);
										
										animation123(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
										});

										
										
									}
									if(check[0] == 4 || check[0] == 5 ) {
										
										animation45(window, pane, check);
										
										animation45(window, pane, check).setOnFinished(m -> {
											try {
												check[0] = check[0] + 1;
												createLevel(check[0]);
											} catch (FileNotFoundException e1) {
												System.out.println("Can not find level"+(check[0])+".txt");
											}
											int end = 0;
											if(check[0] == 6) {
												System.out.println("buraya girdi");
												
												
												Rectangle endRec = new Rectangle(0,0,403,403);
												endRec.setFill(Color.WHITE);									
												Button btExit = new Button("Exit Game");
												btExit.setTranslateX(170);
												btExit.setTranslateY(180);
												pane.getChildren().addAll(endRec,btExit);
												
												end = 1;
												btExit.setOnMouseClicked(t -> {
													window.close();
												});
											}
											
											if(end != 1) {
											Scene scene = new Scene(printLevel(window,check[0]),403,403);
											window.setScene(scene);
											window.show();
											}
										});

										
										
									}
					
									
								}
								
								
								break;
							}
							System.out.println("Node(" + i + ") " + nodes[i].getX() + "   " + nodes[i].getY());
						}
						
					}

				}
				//////////////// About LEFT
				if ((-200 < (p.getX() - e.getX()) && ((p.getX() - e.getX()) < -86))
						&& (Math.abs(p.getY() - e.getY()) < 100)) {
					System.out.println("ifin içi");
					System.out.println(iw.can_Move(iw));
					if (iw.can_Move(iw)) {
						for (int i = 1; i < 17; i++) { // yerine geçilecek node
							int key = 0;
							if ((nodes[i].getX() == iw.getX() - 101) && (nodes[i].getY() == iw.getY())  && nodes[i].moveOnMe(nodes[i])) {
								nodes[i].setX(nodes[i].getX() + 101);
								key = 1;
							}
							if (p.getX() > 0 && key == 1) { // Sola gidemesin
								iw.setX(iw.getX() - 101);
								iw.setY(iw.getY());
								
								movement[0] = movement[0] + 1; 						
								movement(pane,movement[0]);
						//***************************************************************************************************************//	
							
							if(checkLevelCompleted(check[0], pane, nodes)) {
								if(check[0] == 1 || check[0] == 2 || check[0] == 3 ) {
									
									animation123(window, pane, check);
									
									animation123(window, pane, check).setOnFinished(m -> {
										try {
											check[0] = check[0] + 1;
											createLevel(check[0]);
										} catch (FileNotFoundException e1) {
											System.out.println("Can not find level"+(check[0])+".txt");
										}
										
										Scene scene = new Scene(printLevel(window,check[0]),403,403);
										window.setScene(scene);
										window.show();
									});

									
									
								}
								if(check[0] == 4 || check[0] == 5 ) { 
									
									animation45(window, pane, check);
									
									animation45(window, pane, check).setOnFinished(m -> {
										try {
											check[0] = check[0] + 1;
											createLevel(check[0]);
										} catch (FileNotFoundException e1) {
											System.out.println("Can not find level"+(check[0])+".txt");
										}
										int end = 0;
										if(check[0] == 6) {
											System.out.println("buraya girdi");
											
											
											Rectangle endRec = new Rectangle(0,0,403,403);
											endRec.setFill(Color.WHITE);									
											Button btExit = new Button("Exit Game");
											btExit.setTranslateX(170);
											btExit.setTranslateY(180);
											pane.getChildren().addAll(endRec,btExit);
											
											end = 1;
											btExit.setOnMouseClicked(t -> {
												window.close();
											});
										}
										
										if(end != 1) {
										Scene scene = new Scene(printLevel(window,check[0]),403,403);
										window.setScene(scene);
										window.show();
										}
									});

									
									
								}
							
								
				
								
							}
						
							
							
									
								
								break;
							}
							System.out.println("Node(" + i + ") " + nodes[i].getX() + "   " + nodes[i].getY());
						}
						
					}

				}
			});
		}));
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
