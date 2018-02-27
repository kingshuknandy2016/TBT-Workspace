package com.spi.basics;

public class TextEditor {
	 private SpellChecker spellChecker;//spellChecker is the refference variable of SpellChecker class
	   
	
	 //------------1st method by default constructor--------------------
	 
	  /* public TextEditor(SpellChecker spellChecker) {
	      this.spellChecker = spellChecker;//TextEditor should not worry about SpellChecker implementation. 
	                                      //The SpellChecker will be implemented independently and will be provided to 
	                                      //TextEditor at the time of TextEditor 
	                                       //instantiation and this entire procedure is controlled by the Spring Framework.
	      
	                                        Here, we have removed the total control from TextEditor and kept it 
	                                         * somewhere else (ie. XML configuration file) and 
	                                         * the dependency ( ie. class SpellChecker) is being injected into the class 
	                                         * TextEditor through a Class Constructor. Thus flow of control 
	                                         * has been "inverted" by Dependency Injection (DI) because you have effectively 
	                                         * delegated dependances to some external system.
	   }*/
	   
	   //----------------------------------------------------------------- 	
	   
	   
	   //2nd method:by getters and setters
	   /*Second method of injecting dependency is through Setter Methods of TextEditor class where we will create 
	    * SpellChecker instance and this instance will be used to call setter methods to initialize TextEditor's properties*/
	   
	   // a setter method to inject the dependency.
	   public void setSpellChecker(SpellChecker spellChecker) {
	      System.out.println("class:TextEditor...method:setSpellChecker(invoking object of other class--SpellChecker)." );
	      this.spellChecker = spellChecker;
	   }
	   
	   // a getter method to return spellChecker
	   public SpellChecker getSpellChecker() {
		   System.out.println("class:TextEditor...method:getSpellChecker(invoking object of other class--SpellChecker)." );
	      return spellChecker;
	   }
	   
	   public void spellCheck(){
		   spellChecker.checkSpelling();
	   }
	   
	   
	   
	   public void init() {
			// TODO Auto-generated method stub
			System.out.println("inside init methods");

		}
		public void destroy() {
			// TODO Auto-generated method stub
			System.out.println("inside  destroy");
		}




}
