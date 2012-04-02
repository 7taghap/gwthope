package com.rb.gwthope.shared.util;

public class XmlTextBox {

	private String name;
	private String id;
	private String width;
	/**
	 * with button
	 */
	private String with;
	/**
	 * hidden,text
	 * default to text;
	 */
	private String type; 
	
	public XmlTextBox() {
		type = "text";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getWith() {
		return with;
	}
	public void setWith(String with) {
		this.with = with;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
