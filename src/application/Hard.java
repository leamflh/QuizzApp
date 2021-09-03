package application;

import java.util.ArrayList;

public class Hard implements CategoryQuestions {
ArrayList<Questions> hardQuestion= new ArrayList<Questions>();
	
private Questions q1=new Questions("HashSet internally uses HashMap.\n", true);
private Questions q2=new Questions("Hashtable permits one null key.\n", false);
private Questions q3=new Questions("LinkedHashSet implements Serializable.\n", true);
private Questions q4=new Questions("In WeakHashMap, entries are never \nremoved by garbage collector.", false);
private Questions q5=new Questions("An EnumSet can use enum and non enum \ntype keys.", false);
private Questions q6=new Questions("Iterator returned by HashSet is Fail-Safe.\n", false);
private Questions q7=new Questions("Constructor overloading is not possible in Java.\n",false);
private Questions q8=new Questions("A HashMap permits the existence of \nnull values.",true);
private Questions q9=new Questions("the number of default segments in \nConcurrent HashMap is 32.",true);
private Questions q10=new Questions("The default capacity of a Vector is 16.\n",false);


	public Hard() {
		hardQuestion.add(q1);
		hardQuestion.add(q2);
		hardQuestion.add(q3);
		hardQuestion.add(q4);
		hardQuestion.add(q5);
		hardQuestion.add(q6);
		hardQuestion.add(q7);
		hardQuestion.add(q8);
		hardQuestion.add(q9);
		hardQuestion.add(q10);
		
	}

	// bstaamela ta yrdle list l khasa fi.
	@Override
	public ArrayList<Questions> choice() {
		return hardQuestion;
		
	}
}
