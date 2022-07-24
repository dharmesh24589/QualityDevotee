Weather Comparison Utility
- Phase 1
1. Used https://www.accuweather.com/ portal to search a city (configurable) for details viz. temperature, pressure, humidity and visibility

- Phase 2
1. Used the API https://openweathermap.org/current for getting weather data for city mentioned in phase 1
2. Automated the above REST API using rest assured

- Phase 3
1. Created a comparator that matches the parameter information from the UI in phase 1 against the API response
2. Built variance logic (configurable) that returns a success if parameter difference is within a specified range, else return a an error message

- Technologies used
  - Language - Java
  - Tools
  - Selenium for UI automation
  - Rest assured for API automation
  - Appium for mobile web automation
  - Extent report for report generation
  - Testng for running test
  - Apache Maven for build automation
