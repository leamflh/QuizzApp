package application;

public class CategoryFactory {
	
	//this class will return the object i want to use , hie l 
	// btkhla2le l categories.
	
	   public CategoryQuestions getCategory(String categoryString){
		      if(categoryString == null){
		         return null;
		      }		
		      if(categoryString.equalsIgnoreCase("Easy")){
		         return new Easy();
		         
		      } else if(categoryString.equalsIgnoreCase("Medium")){
		         return new Medium();
		         
		      } else if(categoryString.equalsIgnoreCase("Hard")){
		         return new Hard();
		      }
		      
		      return null;
		   }
}
