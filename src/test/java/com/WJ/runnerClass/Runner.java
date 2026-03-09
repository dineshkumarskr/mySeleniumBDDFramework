package com.WJ.runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.WJ.stepDefinition"},
        plugin = {
                "pretty",
                "summary",
                "com.WJ.utils.StepListener",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        tags = "@Test",
        monochrome = true,
        publish = false
)
public class Runner {
}

