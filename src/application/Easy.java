package application;

import java.util.ArrayList;

public class Easy implements CategoryQuestions {
	 ArrayList<Questions> easyQuestion= new ArrayList<Questions>();
	
	 private Questions q1=new Questions("Comparator interface contains the method \n compareTo().", false);
		private Questions q2=new Questions("A long variable is 64 bits.\n", true);
		private Questions q3=new Questions("When add and remove operations are more \nfrequent we use a LinkedList.", true);
		private Questions q4=new Questions("A set doesn't have an index based structure.\n", true);
		private Questions q5=new Questions("java.util.Collections is an object.\n", false);
		private Questions q6=new Questions("A set allows duplicate elements.\n", false);
		private Questions q7=new Questions("Generics guarantees type-safety in a \ncollection.",true);
		private Questions q8=new Questions("Polymorphism is the ability of an object \nto take on many forms.",true);
		private Questions q9=new Questions("java.inout is an input/output package used \nwith Java.",false);
		private Questions q10=new Questions("An immutable object can be changed once \nit is created.",false);
	public Easy() {
		easyQuestion.add(q1);
		easyQuestion.add(q2);
		easyQuestion.add(q3);
		easyQuestion.add(q4);
		easyQuestion.add(q5);
		easyQuestion.add(q6);
		easyQuestion.add(q7);
		easyQuestion.add(q8);
		easyQuestion.add(q9);
		easyQuestion.add(q10);
		
	}

	// bstaamela ta yrdle list l khasa fi.
	@Override
	public ArrayList<Questions> choice() {
		return easyQuestion;
		
	}
}
