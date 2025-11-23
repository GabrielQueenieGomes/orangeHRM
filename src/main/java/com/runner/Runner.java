package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/main/resources/login.feature", // Path to your feature files
glue = "com.cucumber.bdd.login", // Path to your step definition package
plugin = { "json:target/cucumber.json" }, // Reporting plugins
monochrome = true // Readable console output
)

public class Runner extends AbstractTestNGCucumberTests {

}
