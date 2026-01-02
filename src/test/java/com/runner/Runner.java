package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/login.feature",
	    glue = "com.cucumber.bdd.login",
	    plugin = { "json:target/cucumber.json" },
	    monochrome = true
	)

public class Runner extends AbstractTestNGCucumberTests {

}
