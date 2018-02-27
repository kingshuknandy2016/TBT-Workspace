package com.spi.questions.pack;

public class Answer {
	
	private int andId;
	private String whoAnswered;
	private String Ans;
	public Answer(int andId, String whoAnswered, String ans) {
		super();
		this.andId = andId;
		this.whoAnswered = whoAnswered;
		Ans = ans;
	}
	@Override
	public String toString() {
		return "Answer [andId=" + andId + ", whoAnswered=" + whoAnswered
				+ ", Ans=" + Ans + "]";
	}		

	
}
