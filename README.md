
# BDD Selenium Framework with Java and Page Object Model

## Description
This project is a Behavior-Driven Development (BDD) framework built with Selenium, Java, Cucumber, and TestNG. It follows the Page Object Model (POM) design pattern to separate test logic from UI interactions, making the framework scalable and maintainable.


## Prerequisites and Tools
To run the framework and execute tests, ensure that the following tools and dependencies are installed:

1. Java Development Kit (JDK) 8 and more
2. Apache Maven
3. Eclipse IDE

## Installation
1. To clone the repository, use the following command: 
   ```bash
   git clone https://github.com/SDETCodeWallet/Assignment.git
2. Run below command to download all required dependency defined in POM.xml file
   ```
   bash
   Copy code
   mvn clean install

## BDD Approach

### Features
The [SampleScenarios.feature](src/test/resources/features/SampleScenarios.feature) file contains the following scenarios: 

1. **Scenario Outline: Verify user is able to calculate tax correctly**  
   This test ensures the VAT calculator correctly computes tax for different valid input values.
   Automating this scenario helps validate core functionality of the calculator, ensuring accuracy across multiple cases.
   

2. **Scenario Outline: Verify Pie chart not displayed when User enter negative value, Special Characters, or number greater than expected**  
   This test checks that the Pie chart does not appear when the user enters invalid values such as negative numbers, special characters, or values, exceeding the expected range.
   Automating this scenario ensures the system handles invalid inputs correctly.

The `@TestUI` tags in the feature file allow the execution or debugging of individual scenarios as needed.

### Step Definitions
All step definitions are located in the [Steps Definitions folder](src/test/java/stepdefinitions), which includes the following files:

1. [HomePageSteps.java](src/test/java/stepdefinitions/HomePageSteps.java)


### Cucumber Hooks
The [Hooks.java](src/test/java/stepdefinitions/Hooks.java) file is used to set up and tear down the browser. It can also be utilized to connect to and disconnect from a database.

## Application Pages
All application pages, UI objects (locators), and their corresponding UI functions are stored in the [Application Pages](src/main/java/pages) folder, which contains the following files:

1. [HomePage.java](src/main/java/pages/HomePage.java)

## Utils Folder
Utility files are located in the [Utils folder](src/main/java/utils). These files contain generic functions for Selenium and a properties reader:

1. [PropertiesReader.java](src/main/java/utils/PropertiesReader.java)
2. [UiDriverUtils.java](src/main/java/utils/UiDriverUtils.java)

## Resource Folder
The [config.properties](src/main/resources/config.properties) file contains all the configuration details required for test automation, such as browser name, application URL, and test data.

### Cucumber Runner
To run the tests, right-click on [TestRunner.java](src/test/java/runners/TestRunner.java) and select **Run As > TestNG Test**.

### Cucumber Reports
To view the execution results, open the [Reports.html](target/cucumber-reports.html) file in a web browser.

