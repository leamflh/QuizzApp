package application;

import java.util.ArrayList;



public class Medium implements CategoryQuestions {
	 ArrayList<Questions> mediumQuestion= new ArrayList<Questions>();
	 private Questions q1=new Questions("TreeMap implements Abstract Map.\n", false);
		private Questions q2=new Questions("LinkedList helps insert elements at a \nspecific position in a collection.", true);
		private Questions q3=new Questions("Complexity of ArrayList get method is \nO(1).", true);
		private Questions q4=new Questions("A hashSet is sorted by default.\n", false);
		private Questions q5=new Questions("An iterator permits the removal of \nelements from a collection.", true);
		private Questions q6=new Questions("ArrayList implements Cloneable.\n", true);
		private Questions q7=new Questions("O(n)is the search time complexity of an\n ordered array.",true);
		private Questions q8=new Questions("JVM invokes the thread's run() method\n when the thread is initially executed.",true);
		private Questions q9=new Questions("LinkedList doesn't implement Deque.\n",false);
		private Questions q10=new Questions("InputStream deals with character input.\n",false);
		
	public Medium() {
		mediumQuestion.add(q1);
		mediumQuestion.add(q2);
		mediumQuestion.add(q3);
		mediumQuestion.add(q4);
		mediumQuestion.add(q5);
		mediumQuestion.add(q6);
		mediumQuestion.add(q7);
		mediumQuestion.add(q8);
		mediumQuestion.add(q9);
		mediumQuestion.add(q10);
		
	}

	// bstaamela ta yrdle list l khasa fi.
	@Override
	public ArrayList<Questions> choice() {
		return mediumQuestion;
		
	}
}
