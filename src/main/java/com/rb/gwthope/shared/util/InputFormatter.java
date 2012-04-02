package com.rb.gwthope.shared.util;

/**
 * 
 * @author caburnar
 *
 */
public class InputFormatter {

	public float toFloat(String val) {
		float fl= 0;
		try {
			fl = Float.parseFloat(val);
		}catch(NumberFormatException nfe) {
			fl = 0;
		}
		return fl;
	}
	
	public double toDouble(String val){
		double d = 0;
		try {
			d = Double.parseDouble(val);
		}catch(NumberFormatException nfe) {
			d = 0;
		}
		return d;
	}
	
	public int toInt(String val) {
		int i = 0;
		try {
			i = Integer.parseInt(val);
		}catch(NumberFormatException nfe) {
			i = 0;
		}
		return i;
	}
}
