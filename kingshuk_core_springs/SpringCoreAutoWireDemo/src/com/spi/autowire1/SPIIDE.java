package com.spi.autowire1;

public class SPIIDE {
	
	private SpellingChecker sp;
	private Font font;
	
	
	public SPIIDE(Font font,SpellingChecker sp) {
		// TODO Auto-generated constructor stub
		System.out.println("SPIIDE-spellChecker-Font-Const..");
	}
	
	
	
	
	
	/*
	 * public SPIIDE(Font font,SpellingChecker sp) { // TODO Auto-generated
	 * constructor stub System.out.println("SPIIDE With 2-Arg-Font.."); }
	 * 
	 * public SPIIDE() { // TODO Auto-generated constructor stub
	 * System.out.println("SPIIde-Const.."); }
	 */

	/*
	 * public Font getFont() { return font; }
	 * 
	 * public void setFont(Font font) { System.out.println("setter"); this.font
	 * = font; }
	 * 
	 * public SpellingChecker getSp() { return sp; }
	 * 
	 * public void setSp(SpellingChecker sp) { this.sp = sp; }
	 */

	public SpellingChecker getSp() {
		return sp;
	}





	public void setSp(SpellingChecker sp) {
		System.out.println("setter-sp");
		this.sp = sp;
	}





	public Font getFont() {
		return font;
	}





	public void setFont(Font font) {
		System.out.println("setter-font");
		this.font = font;
	}





	public SPIIDE() {
		// TODO Auto-generated constructor stub
		System.out.println("SPIIDE-Const..");
	}
	
	public void show() {
		System.out.println("show called..");
	}

}
