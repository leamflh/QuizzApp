package application;

public class ScoreBoard {
	
	private static ScoreBoard scoreBoard = new ScoreBoard(); 
	int score=0;
	private ScoreBoard() { }
	
	public static ScoreBoard getInstance() {
		if (scoreBoard == null) {
		synchronized (ScoreBoard.class) {
		if (scoreBoard == null) {
		scoreBoard = new ScoreBoard();
		System.out.println("Instance Created");
		} } }
		return scoreBoard;
		}

	public void addScore() {
		 score++;
	}
	public String getScore() {
		return String.valueOf(score);
	}
	public void setScore(){
	    score=0;
	  }	

}
