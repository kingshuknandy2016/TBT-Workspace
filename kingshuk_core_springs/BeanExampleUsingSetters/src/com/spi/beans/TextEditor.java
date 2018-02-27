package com.spi.beans;

public class TextEditor {

	SpellChecker spellchecker;
	
	public TextEditor() {
		// TODO Auto-generated constructor stub
		System.out.println("Tex Editor Const.");
	}

	public SpellChecker getSpellchecker() {
		return spellchecker;
	}

	public void setSpellchecker(SpellChecker spellchecker) {
		this.spellchecker = spellchecker;
	}
	
	public void spellCheck() {
		spellchecker.checkSpelling();
	}
	
	
	
}
