package application;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class QuizBrain {
	//brain of the game , fia b sir kel l logic
	
	private int questionNumber=0;
	ArrayList<Questions> listQuestions;
	

	
	public QuizBrain(ArrayList<Questions> question) {
		this.listQuestions=question;
	}

	public ImageView checkAnswer(Boolean userAnswer,Boolean correctAnswer) {
		ScoreBoard score= ScoreBoard.getInstance();
		if(correctAnswer== userAnswer) {
			
			score.addScore();
	        return new ImageView("file:///C:/Users/user/eclipse-workspace/quizzApp/images/true.png");

		}
	      else
	        return new ImageView("file:///C:/Users/user/eclipse-workspace/quizzApp/images/false.png");

	}

	public Boolean nextQuestion (){
		    if(questionNumber<listQuestions.size() -1) {
		      questionNumber++;
		      
		      return true;
		    }
		    else
		      return false;
		  }
	
	public String getQuestion(){
		    return listQuestions.get(questionNumber).questionTest;
		  }
	
	public Boolean getAnswer(){
		    return listQuestions.get(questionNumber).questionAnswer;
		  }
	
	public void setQuestionNumber(){
		    questionNumber=0;
		  }	
	
	
}
