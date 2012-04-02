package com.rb.gwthope.client.view;

import java.util.List;

import com.rb.gwthope.shared.util.MyXmlParser;

public class FormCreator {
 MyXmlParser parser;
 List<String> labels;
 
 public FormCreator() {
	 
 }
 
 public FormCreator(String formName) {
	 parser = new MyXmlParser(formName);
	 parser.getLabels();
 
 }
 
 
}
