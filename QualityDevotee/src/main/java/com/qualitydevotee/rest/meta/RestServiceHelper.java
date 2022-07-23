package com.qualitydevotee.rest.meta;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestServiceHelper {

	public static HashMap<String, Integer> getDataFromRestService(String city){
	
		baseURI="https://api.openweathermap.org/";
		Response response = 
		given()
		.basePath("/data/2.5/weather")
		.queryParam("q", city)
		.queryParam("apikey", "7fe67bf08c80ded756e598d6f8fedaea")
		.when()
		.get().then().extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println(response.asString());
		float temperature = jsonPath.get("main.temp");
		System.out.println(temperature);
		float temp=temperature - 273.15F;
		int tempInInt=(int)temp;
		
		int humidity=jsonPath.get("main.humidity");
		int pressure=jsonPath.get("main.pressure");
		int visi=jsonPath.get("visibility");
		int visibility=visi/1000;
		
		HashMap<String, Integer> responseFieldsMap=new HashMap<String, Integer>();
		responseFieldsMap.put("temperature", tempInInt);
		responseFieldsMap.put("humidity", humidity);
		responseFieldsMap.put("pressure", pressure);
		responseFieldsMap.put("visibility", visibility);

		return responseFieldsMap;
	}

}
