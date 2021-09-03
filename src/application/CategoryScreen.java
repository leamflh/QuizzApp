package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CategoryScreen extends Application {
	

	public void start(Stage stage)
	{
	Button b1=new Button("Easy");
	Button b2=new Button("Medium");
	Button b3=new Button("Hard");
	
	VBox box=new VBox();
	
	box.setId("background");

	Text title = new Text();
	title.setId("pick");
	title.setText("PICK A LEVEL :");
	title.setStroke(Color.AQUA);
	
	
	box.setAlignment(Pos.CENTER);
	box.setSpacing(40);
	
	box.getChildren().addAll(title,b1,b2,b3);
	
	Scene scene = new Scene(box, 750,600);
	scene.getStylesheets().add(CategoryScreen.class.getResource("application.css").toExternalForm());

	stage.setTitle("Quizz App");
	stage.setScene(scene);
	stage.show(); 
	CategoryFactory factory=new CategoryFactory();
	
	b1.setOnAction(e->{
		
		CategoryQuestions choice= factory.getCategory("Easy");
		QuizBrain quiz=new QuizBrain(choice.choice());
		
		GameScreen main=new GameScreen(quiz);
		main.start(stage);
		
		});
	b2.setOnAction(e->{
		
		CategoryQuestions choice= factory.getCategory("Medium");
		QuizBrain quiz=new QuizBrain(choice.choice());
		
		GameScreen main=new GameScreen(quiz);
		main.start(stage);
		
	});
	b3.setOnAction(e->{
		CategoryQuestions choice= factory.getCategory("Hard");
		QuizBrain quiz=new QuizBrain(choice.choice());
		
		GameScreen main=new GameScreen(quiz);
		main.start(stage);
		
		});
	

	}
	
	

	
}

