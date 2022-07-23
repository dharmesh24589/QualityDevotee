package com.qualitydevotee.utilities;

import java.util.HashMap;

public class Conversion {
	
	static HashMap<String, Double> hm = new HashMap<String,Double>();
	
	public static void main(String args[])
	{
		Conversion con = new Conversion();
		double meterValue = con.convertKilometerToMeter(11);
		System.out.println(meterValue);
		
		double celciousValue = con.convertKelvinToCelcious(100);
		System.out.println(celciousValue);
		
		hm.put("Meter", meterValue);
		hm.put("Temperature", celciousValue);
	}
	
	public double convertKilometerToMeter(double kilometer)
	{
		double meter = kilometer/1000;
		return meter;
	}
	
	public double convertKelvinToCelcious(double kelvin)
	{
		double celcious = kelvin - 273.15;
		return celcious;
	}

}
