package com.spi.di.types;

public class TextEditor {
	private int id;
	private String name;
	private Format format;
	private Font font;
	private SpellingChecker checker;

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

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public SpellingChecker getChecker() {
		return checker;
	}

	public void setChecker(SpellingChecker checker) {
		this.checker = checker;
	}

	public String toString() {
		return "TextEditor [id=" + id + ", name=" + name + ", font=" + font
				+ "]";
	}

}
