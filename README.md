# HMRC-Test
Simple add to basket test, using Selenium, Cucumber and Java

Test for HMRC
Project was developed on Windows os with Java8 (IntelliJ).

env.properties (src/test/properties/env.properties)

This file contains properties for driver, timeouts and host.

Implementation

Page Objecct Model is used to implement this project

BasePage: src/main/java/utils/BasePage.java Chromedriver & report are instantiated here

Pages: src\test\java\demo\pages\*.java here, for every page form the test website, required elements are declared using page factory and the corresponding actions are imeplemented in the methods.

Runner: src\test\java\demo\runner\Runner.java this is to run the scenarios, step definition path is mentioned in glue.

Steps: src\test\java\demo\steps\HmrcSteps.java All the cucumber steps are defined in this file.

Utils: src\test\java\demo\utils this package is helper package which contains... below

configuration class to read the properties
Feature (src\test\resources\features\HMRC_Test.feature)

This contains 1 scenario, feature is tagged with @demo

** How to run tests ** We can run these tests in windows and mac. We can use the runner file TestRunner.java to test, tags are already defined.

Using IDE - Right Click on the Runner file and select Run.

Using terminal

cd {projectFolder}
mvn compile
mvn test
Very basic version of reports will be present in target folder after the run
