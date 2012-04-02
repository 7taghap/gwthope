package com.rb.gwthope.shared.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 * xml parser for creating form in xml format
 * @author caburnar
 *
 */
public class MyXmlParser extends DefaultHandler{
	
	List<String> buttons;
	List<String> labels;
	List<String> tables;
	List<String> textboxs;
	
	String tempVal;
	public MyXmlParser(String formName) {
		buttons = new ArrayList<String>();
		labels = new ArrayList<String>();
		textboxs = new ArrayList<String>();
		tables = new ArrayList<String>();
		formName = "product-frm.xml";
		this.parseDocument();
	}
	
	/**
	 * parse the document
	 */
	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			System.out.println(this.getClass().getResource("/product-frm.xml"));
			SAXParser sp = spf.newSAXParser();
			sp.parse(this.getClass().getResource("/product-frm.xml").toString(), this);
			
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	
	//Event Handlers
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			//reset
			tempVal = "";
			if(qName.equalsIgnoreCase("button")) {
				

			}
			System.out.println("start tag :" +qName);
		}
		

		public void characters(char[] ch, int start, int length) throws SAXException {
			tempVal = new String(ch,start,length);
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("button")) {
				buttons.add(tempVal);
			}
			else if (qName.equalsIgnoreCase("label")) {
				labels.add(tempVal);
			}
//			if(qName.equalsIgnoreCase("Employee")) {
//				//add it to the list
//				myEmpls.add(tempEmp);
//				
//			}else if (qName.equalsIgnoreCase("Name")) {
//				tempEmp.setName(tempVal);
//			}else if (qName.equalsIgnoreCase("Id")) {
//				tempEmp.setId(Integer.parseInt(tempVal));
//			}else if (qName.equalsIgnoreCase("Age")) {
//				tempEmp.setAge(Integer.parseInt(tempVal));
//			}
			System.out.println("end tag :" +qName);
		}

		public List<String> getButtons() {
			return buttons;
		}

		public void setButtons(List<String> buttons) {
			this.buttons = buttons;
		}

		public List<String> getLabels() {
			return labels;
		}

		public void setLabels(List<String> labels) {
			this.labels = labels;
		}

		public List<String> getTables() {
			return tables;
		}

		public void setTables(List<String> tables) {
			this.tables = tables;
		}

		public List<String> getTextboxs() {
			return textboxs;
		}

		public void setTextboxs(List<String> textboxs) {
			this.textboxs = textboxs;
		}


}
