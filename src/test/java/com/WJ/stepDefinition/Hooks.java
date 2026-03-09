package com.WJ.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import resuableMethods.DriverManager;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class Hooks  {

	@Before
	public void launchBrowser(Scenario scenario) {
		DriverManager.initDriver();
		ExtentTestManager.setTest(
                ExtentManager.getInstance().createTest(scenario.getName())
        );
	}
	
	 @BeforeStep
	    public void beforeStep(Scenario scenario) {
	        //ExtentTestManager.getTest().info("Starting Step → " + scenario.getName());
	    }

	 @AfterStep
	    public void afterStep(Scenario scenario) {

			/*
			 * if (scenario.isFailed()) {
			 * 
			 * String screenshot = ((TakesScreenshot) DriverManager.getDriver())
			 * .getScreenshotAs(OutputType.BASE64);
			 * 
			 * ExtentTestManager.getTest().fail("Step Failed");
			 * ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot);
			 * 
			 * } else { ExtentTestManager.getTest().pass("Step Passed"); }
			 */
		 
			 if (scenario.isFailed()) {
				 String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
			        ExtentTestManager.getTest().fail("Step failed");
			        ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot);
			    } else {
			        ExtentTestManager.getTest().pass("Step passed");
			    }
	    }

	@After
	public void closeBrowser() {
		
		DriverManager.quitDriver();
		ExtentManager.getInstance().flush();
        ExtentTestManager.unload();
	}



}
