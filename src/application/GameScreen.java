package application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameScreen extends Application {
	
	QuizBrain category;
	
	public GameScreen(QuizBrain category) {
		this.category=category;
	}
	
	@Override
	public void start(Stage primaryStage) {
		VBox display = new VBox();
		display.setId("questionsPane");
		
		//question
		Text question = new Text(category.getQuestion());
		question.setId("questionLabel");
		HBox questionBox=new HBox();
		questionBox.getChildren().add(question);
		questionBox.setAlignment(Pos.BASELINE_LEFT);
		questionBox.setPadding(new Insets(0,0,0,120));
		
		//Score
		ScoreBoard score= ScoreBoard.getInstance();
		Text scoreLabel=new Text("Score: "+score.getScore());
		scoreLabel.setId("scoreLabel");
		HBox scoreBox=new HBox();
		scoreBox.getChildren().add(scoreLabel);
		scoreBox.setAlignment(Pos.BASELINE_RIGHT);
		scoreBox.setPadding(new Insets(20,130,40,0));
		
		//buttons
		Button correct=new Button("Correct");
		Button incorrect=new Button("Incorrect");
		VBox buttonBox=new VBox();
		buttonBox.getChildren().addAll(correct,incorrect);
		buttonBox.setPadding(new Insets(80,30,0,0));
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(20);
		
		//icon
		HBox imagePane=new HBox();
		imagePane.setPadding(new Insets(80,0,0,150));
		
		//back icon
		Image img = new Image("file:///C:/Users/user/eclipse-workspace/quizzApp/images/back.png");
		ImageView back=new ImageView(img);
		HBox backBox=new HBox();
		backBox.getChildren().add(back);
		backBox.setAlignment(Pos.BASELINE_LEFT);
		backBox.setPadding(new Insets(5,0,0,0));
		back.setPickOnBounds(true);
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
		     public void handle(MouseEvent event) {
		    	 category.setQuestionNumber();
					score.setScore();
		    	  CategoryScreen category = new CategoryScreen();
		    	  try {
					category.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
		     }
		});
		//progress bar
		ProgressBar bar = new ProgressBar();
		bar.setProgress(1);
		bar.setMaxWidth(750);
		VBox barVBox = new VBox();
		barVBox.getChildren().add(bar);
		Timeline timerAnimation = new Timeline(new KeyFrame(Duration.millis(100),
				e-> {
					if(bar.getProgress()>0) {
						bar.setProgress(bar.getProgress()-0.01);
					}
				}));
		timerAnimation.setCycleCount(100);
		timerAnimation.play();
		
		display.getChildren().addAll(barVBox,backBox,scoreBox,questionBox,buttonBox,imagePane);
		
		Scene scene = new Scene(display, 750,600);
		primaryStage.setTitle("Quizz App");
		scene.getStylesheets().add(WelcomeScreen.class.getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show(); 
		
		correct.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				//check if answer is correct
				Boolean correctAnswer=category.getAnswer();
				imagePane.getChildren().add(category.checkAnswer(true,correctAnswer));
				// refresh the score
				scoreLabel.setText("Score : "+score.getScore());
				 Boolean stop=category.nextQuestion();
			      if(stop==false) {
			    	  category.setQuestionNumber();
			    	  ResultScreen secondWindow = new ResultScreen();
			    	  secondWindow.start(primaryStage);
			      }
			      else {
			    	  question.setText(category.getQuestion());
			    	  timerAnimation.stop();
			    	  bar.setProgress(1);
			    	  timerAnimation.play();
			      }
			}
			});
		incorrect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Boolean correctAnswer=category.getAnswer();
				imagePane.getChildren().add(category.checkAnswer(false,correctAnswer));
				
				// refresh the score
				scoreLabel.setText("Score : "+score.getScore());
				
				Boolean stop=category.nextQuestion();
			      if(stop==false) {
			    	 
			    	  category.setQuestionNumber();
			    	  ResultScreen secondWindow = new ResultScreen();
			    	  secondWindow.start(primaryStage);
			    	  
			      }
			      else {
			    	  question.setText(category.getQuestion());
			    	  timerAnimation.stop();
			    	  bar.setProgress(1);
			    	  timerAnimation.play();
			      }
			}
		});
		
		timerAnimation.setOnFinished(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				imagePane.getChildren()
				.add(new ImageView("file:///C:/Users/user/eclipse-workspace/quizzApp/images/false.png"));
				
				Boolean stop=category.nextQuestion();
			      if(stop==false) {
			    	 
			    	  category.setQuestionNumber();
			    	  ResultScreen secondWindow = new ResultScreen();
			    	  secondWindow.start(primaryStage);
			    	  
			      }
			      else {
			    	  question.setText(category.getQuestion());
			    	  timerAnimation.stop();
			    	  bar.setProgress(1);
			    	  timerAnimation.play();
			      }
				
			}
	    });
	}
	
}