package org.zonedabone.commandsigns;

public class CommandSignsText {
	
	private String owner;
	private String[] text = new String[10];
	
	CommandSignsText(String owner) {
		this.owner = owner;
		for (int i = 0; i < 10; i++) {
			text[i] = null;
		}
	}
	
	public CommandSignsText clone(String owner) {
		CommandSignsText cst = new CommandSignsText(owner);
		cst.setText(text.clone());
		return cst;
	}
	
	public String getLine(int index) {
		if (index < 0 || index >= 10) {
			return null;
		}
		return text[index];
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String[] getText() {
		return text;
	}
	
	public boolean setLine(int index, String line) {
		if (index < 0 || index >= 10) {
			return false;
		}
		text[index] = line;
		return true;
	}
	
	public void setText(String[] text) {
		this.text = text;
	}
	
	public String toFileString() {
		String string = "";
		String line;
		for (int i = 0; i < 10; i++) {
			line = getLine(i);
			if (line != null && !line.equals("")) {
				string = string.concat(getLine(i) + "[LINEBREAK]");
			}
		}
		return string;
	}
	
	@Override
	public String toString() {
		String string = "";
		String line;
		for (int i = 0; i < 10; i++) {
			line = getLine(i);
			if (line != null) {
				string = string.concat(getLine(i) + (i != 9 ? " " : ""));
			}
		}
		return string;
	}
}
