package com.WJ.resuableMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static void quitDriver() {
		driver.quit();
	}
}
