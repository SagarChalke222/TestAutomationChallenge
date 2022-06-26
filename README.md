# TestAutomationChallenge

This project is focused on automating a website in order to validate login functionality and hyperlinks on a webpage.

This project is useful to validate login using different browsers in different environments.

### Answers for Basics, Test case challenge and Automation test challenge (Test case 3 only) can be read from Technical Challenge.pdf.

### Prerequisites 
1. Install Eclipse IDE for java developers
2. Java version 18
3. Maven project 3.8.6
4. Add Testng plugin in Eclipse >> Help>> Install new software

### How to run the project

1. Import project TestAutomationChallenge in Eclipse
2. Open file src/test/resources/configfiles/config.properties  
3. In config.properties file update browser for example. browser=edge
4. In config.properties file update TestURL for example testurl=https://www.mytheresa.com/ende/men.html
5. Navigate to testrunner/testing.xml - Right click and run this file as TestNG Suite

### Project Overview

**Test cases 1 & 2 are implemented in the project**

src/test/java/testcases
TestChallengeSuit.java - test cases suite where all test cases are added.Login and hyperlinks related test cases are part of this suit. Scope to add N number of test cases.

src/test/java/base 
BaseTest.java - This class is used to run specific drivers when test cases are triggered. Drivers are selected based on users selection of data.

src/test/java/utilities package
ReadpropertyFile.java - This class is used to read property file which will be helpful to pull data from centralized file.

src/test/resources/configfiles folder
Two config files are under this path. These files contains testurl,browsers & locators related data which is utilized by all other files using ReadpropertyFile.java.

Maven Dependencies
Maven utilizes pom.xml file to download all the dependencies.

testrunner folder
testing.xml - is a test suite to run multiple test cases.

**Sagar Chalke maintains and contributes to the project.**
