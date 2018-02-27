package com.tutorialspoint;

import org.springframework.beans.factory.DisposableBean;

public class HelloWorld  {
	 private String message;
	 private int marks;
	 
	 public HelloWorld() {
		// TODO Auto-generated constructor stub
		 System.out.println("default bean constructor");
	}

	   public void getMarks() {
		System.out.println("marks:"+marks);
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
	  //-------------------------------------------- 
	   public void abc(){
		      System.out.println("Bean is going through init.");
		   }
		   public void dka(){
		      System.out.println("Bean will destroy now.");
		   }
}
