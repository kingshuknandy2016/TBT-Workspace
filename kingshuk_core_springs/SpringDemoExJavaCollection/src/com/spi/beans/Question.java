package com.spi.beans;

import java.util.Iterator;
import java.util.List;

public class Question {

	private int id;
	private String name;
	private List<String> answers;
	
	public Question() {
		// TODO Auto-generated constructor stub
		System.out.println("Def const..");		
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public List<String> getAnswers() {
		return answers;
	}




	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}




	public void showAnswers(){
		Iterator<String> it= this.answers.iterator();
	
		System.out.println("Question \t"+name);
		
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
