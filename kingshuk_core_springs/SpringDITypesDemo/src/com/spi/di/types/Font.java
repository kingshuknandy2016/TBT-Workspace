package com.spi.di.types;

public class Font {
	private int id;
	private String fontname;
	private String fontstyle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFontname() {
		return fontname;
	}

	public void setFontname(String fontname) {
		this.fontname = fontname;
	}

	public String getFontstyle() {
		return fontstyle;
	}

	public void setFontstyle(String fontstyle) {
		this.fontstyle = fontstyle;
	}

	public String toString() {
		return "Font [id=" + id + ", fontname=" + fontname + ", fontstyle="
				+ fontstyle + "]";
	}
	
	

}
