package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResultScreen extends Application {

	
	
	public void start(Stage stage)
	{
		
	ScoreBoard score=ScoreBoard.getInstance();
	Text result = new Text("Result :"+score.getScore());
	result.setId("result");
	
	VBox box=new VBox();
	Button exit= new Button("PLAY AGAIN");
	
	box.setId("background");
	box.getChildren().addAll(result,exit);
	
	result.setStroke(Color.AQUA);
	
	
	box.setAlignment(Pos.CENTER);
	box.setSpacing(40);
	
	exit.setOnAction(e->{
		
		score.setScore();
		CategoryScreen screen=new CategoryScreen();
		screen.start(stage);
		
		});;
	

	Scene scene = new Scene(box,750,600);
	scene.getStylesheets().add(CategoryScreen.class.getResource("application.css").toExternalForm());

	stage.setScene(scene);
	

	}
}
