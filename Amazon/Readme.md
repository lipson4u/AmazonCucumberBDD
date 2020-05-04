# Project Scope

1. Go to Amazon website
2.  Search for a particular item
3.  Find the cheapest available item
4.  Add the item to the basket
5.  Do the same for all items
6.  Then Click on checkout
7.  Find whether the website is redirecting to Login Page

# Highlights

1.  Supports n number of items 
2.  Supports different OS and browser by using WebdriverManager
3.  This script is capable to execute in Image disable mode.
4.  Browser and  image disable mode can be Configured using “TestRunDetails.properties”.
5.  Reports in different formats such as HTML,  XML and JSON reports.

# Things to Know

1.  Used Cucumber with BDD, to run execute the runner class in testrunner package.
2.  Automation Framework is deigned using Junit in Java using Page object model with page factory approach. 
3.  Browser client is handled by using WebdriverManager . So no need of any driver exe file.
4.  Implementation of different OS and browser without WebdriverManager is also written and commented. Please check OSPath class for details.
5. Implemented Listener class WebDriverEventListener for debugging as well as for logging the flow and its commented.

# Working Of the Program
1. Open the amazon website
2. Search the first item
3. Analyze the results of the search
4. Sort the amounts and Click on the smallest amount 
5. Go to the product details page and check whether add to basket option is available.
6. Click on add to basket button if its present else go back to previous page.
7. Click the next smallest amount 
8. Continue this loop untll add to basket button is found.
9. Add the values of the selected product 
10. Repeat the steps from step 2 for next item.

![Image description](https://github.com/lipson4u/AmazonCucumberBDD/blob/master/Amazon/src/main/resource/sampleoutput.jpg)

# Structure

1.src/main/java : contains all main functions Packages, Class and Functions

1. amazon.feature: This package contains feature file for BDD approach
   a.amazonregistration.feature : It describes feature, scenario and its steps  in Gherkin language.
   

2. amazon.util: This package contains class file for Browser configuration,  listener class and general functions used for the framework.

   a. ConvertFunctions.java: This class contains Common functions used in the application to perform basic string operations and data type conversions
   
   b. DisableImage.java: This class contains functions to disable browser image loading.
      
   c. Driver.java: This class contains function to launch browser, also to initialize Eventwebdriver listener and quit browser
   
   d. DynamicWait.java : Contains function to wait for an element to be clickable and then click on that element.
   
   e. JavascriptActions.java : Contains funtions to perform click using Javascript.
   
   f. OSPath.java : Contains function to identify the operating system and calling the respective browser exe file.
   
   g.  ReadPropertyFile.java : contains class and function to read property from property file.
   
   h. WebEventListener.java : WebdriverEvent Listener class for logging each activity during the  script execution.
  	
3. amazon.webpages: This package contains different webpages and its elements.
​	
   
   a. HomePage.java : Contains all elements related to Home Page and Methods to perform action on home Page.
   
   b. ItemDetailPage.java : Contains all elements related to Product details page and Methods to perform action on Product details page.
   
   c. ItemResultsPage.java : Contains all elements related to Search Results Page and Methods to perform action on Search Results Page 

2.src/test/java: Contains packages for step definition and runner class
    
1. amazon.stepdefinition: Package to define the stepdefinition class

   a. checkoutstepdefinition.java : It defines the different steps method mentioned in feature file.
   
2. amazon.testrunner: Package to define the runner class

   a. runner.java : It defines the runner class for Cucumber.
   
3.src/main/resource: It is used to define the config file

   a. TestRunDetails.Properties : File to input the parameters.

