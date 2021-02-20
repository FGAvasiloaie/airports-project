Airports WebApp - 2020
This web application offers search functionality for any flight, airport or airline in the world.
The app was built with the Maven project management tool, Spring Framework, Spring Security and the Thymeleaf template engine.

Build the project
To build this project you need Maven. You can download the Maven tool by accessing the link below: https://maven.apache.org/download.cgi

Change directory to your project root folder in command line.

Clean compilation products:

 mvn clean
If you are looking to package the project, then you should run:

 mvn package
Compile:

 mvn compile
Execute:

 mvn exec:java -Dexec.mainClass=ro.siit.airports.AirportsApplication
Once started, the application should be available at:

http://localhost:8788/
