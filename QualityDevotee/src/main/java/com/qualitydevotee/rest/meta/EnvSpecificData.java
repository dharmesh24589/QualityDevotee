package com.qualitydevotee.rest.meta;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class EnvSpecificData{
	private static HashMap<String, String> appDetails=new HashMap<String, String>();
	private static Properties prop;
	public static HashMap<String, String> getConfig() {
		try {
			prop=new Properties();
			prop.load(new FileReader(new File(System.getProperty("user.dir")+"/Appconfig.properties")));
			appDetails.put("cityName", prop.getProperty("City"));
			appDetails.put("temperature", prop.getProperty("temperature"));
			appDetails.put("humidity", prop.getProperty("humidity"));
			appDetails.put("pressure", prop.getProperty("pressure"));
			appDetails.put("visibility", prop.getProperty("visibility"));
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return appDetails;
	}
}