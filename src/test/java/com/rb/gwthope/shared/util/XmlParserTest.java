package com.rb.gwthope.shared.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;
/**
 * xml parser using sax (event based parsing)
 * @author caburnar
 *
 */
public class XmlParserTest extends DefaultHandler{
	List myEmpls;
	private String tempVal;
	File xmlFile;
	
	public XmlParserTest() {
		myEmpls = new ArrayList<String>();
	}
	
	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}
	
	
	public void runExample() {
		parseDocument();
		printData();
	}

	/**
	 * 
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

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){
		
		System.out.println("No of Employees '" + myEmpls.size() + "'.");
		
		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("Employee")) {
			//create a new instance of employee
//			tempEmp = new Employee();
//			tempEmp.setType(attributes.getValue("type"));
		}
		System.out.println("start tag :" +qName);
		
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {

		System.out.println("value :" + tempVal);
//		if(qName.equalsIgnoreCase("Employee")) {
//			//add it to the list
//			myEmpls.add(tempEmp);
//			
//		}else if (qName.equalsIgnoreCase("Name")) {
//			tempEmp.setName(tempVal);
//		}else if (qName.equalsIgnoreCase("Id")) {
//			tempEmp.setId(Integer.parseInt(tempVal));
//		}else if (qName.equalsIgnoreCase("Age")) {
//			tempEmp.setAge(Integer.parseInt(tempVal));
//		}
		System.out.println("end tag :" +qName);
	}
	
	public static void main(String[] args){
		XmlParserTest spe = new XmlParserTest();
		spe.runExample();
	}
	
	
}









