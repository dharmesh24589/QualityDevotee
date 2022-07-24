**Weather Comparison Utility**

**Theme : Smart Test Implementation**

- Phase 1
1. Used https://www.accuweather.com/ portal to search a city (configurable) for details viz. temperature, pressure, humidity and visibility

- Phase 2
1. Used the API https://openweathermap.org/current for getting weather data for city mentioned in phase 1
2. Automated the above REST API using rest assured

- Phase 3
1. Created a comparator that matches the parameter information from the UI in phase 1 against the API response
2. Built variance logic (configurable) that returns a success if parameter difference is within a specified range, else return a an error message

- Technologies used
 1. Language - Java
 2. Tools
 3. Selenium for UI automation
 4. Rest assured for API automation
 5. Extent report for report generation
 6. Testng for running test
 7. Apache Maven for build automation

- How to run?
 1. Set city name and corresponding threshold values on Appconfig.properties file
 2. Run testng.xml file

- Report: 
 1. Extent report generated can be seen at this path "..\QualityDevotee\QualityDevotee\test-output\Report\test\OpenWeatherAPIReport.html"
