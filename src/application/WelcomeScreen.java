package application;
	


import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;





import javafx.animation.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WelcomeScreen extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane welcomePane = new Pane();
			welcomePane.setId("background");
			welcomePane.setPadding(new Insets(25, 25, 25, 25));
			VBox titleBox = new VBox();
			Text title = new Text();
			title.setId("title");
			title.setText("JAVA QUIZ");
			title.setStroke(Color.AQUA);
			titleBox.getChildren().add(title);
			titleBox.setAlignment(Pos.TOP_CENTER);
			VBox.setMargin(title, new Insets(200,300,170,170));
			
			VBox buttonVbox = new VBox();
			Button btn = new Button();
		    btn.setText("PLAY NOW");
		    btn.setVisible(false);
		    buttonVbox.getChildren().add(btn);
		    //titleBox.setAlignment(Pos.TOP_CENTER);
			VBox.setMargin(btn, new Insets(370,300,80,260));
			//title.setFill(Color.MAGENTA);
			btn.setOnAction(e->{
				
				
				
				CategoryScreen category=new CategoryScreen();
				category.start(primaryStage);
				
				});
			
			FadeTransition animation = new FadeTransition(Duration.millis(3000), title);
			
			animation.setFromValue(0.001);
		    animation.setToValue(1);
		    animation.setCycleCount(1);
		    //animation.setAutoReverse(true);
		    animation.play();
			
		    animation.setOnFinished(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent arg0) {
					btn.setVisible(true);
				}
		    });
		    welcomePane.getChildren().addAll(titleBox,buttonVbox) ;
			Scene scene = new Scene(welcomePane,750,600);
			primaryStage.setTitle("Quizz App");
			scene.getStylesheets().add(WelcomeScreen.class.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
