package com.spi.questions.pack;

import java.util.Iterator;
import java.util.List;

public class Question {

	private int id;
	private String name;
	List<Answer> anwers;
	
	public Question() {
		// TODO Auto-generated constructor stub
		System.out.println("def.. Const...");
	}

	public Question(int id, String name, List<Answer> anwers) {
		super();
		this.id = id;
		this.name = name;
		this.anwers = anwers;
	}
	
	public void showDetails(){
		
		Iterator<Answer> it=this.anwers.iterator();
		System.out.println("Q Name\t"+name);
		while (it.hasNext()){			
			System.out.println(it.next());
		}
	}
	
	
	
}
