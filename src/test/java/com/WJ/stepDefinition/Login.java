package com.WJ.stepDefinition;

import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.WJ.pageFactory.LoginPF;
import com.WJ.resuableMethods.CommonReusableRepo;
import com.WJ.resuableMethods.DriverManager;
import com.WJ.utils.ExtentTestManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	
	WebDriver driver = DriverManager.getDriver();
    LoginPF lpf;
    CommonReusableRepo crr;
    

    @Given("User is on Login page")
    public void user_is_on_login_page() throws SQLException {
        driver = DriverManager.getDriver();
        crr = new CommonReusableRepo(driver);
        lpf = new LoginPF(driver);
        ExtentTestManager.getTest().info("Launching Application URL in a Browser");
        driver.get("https://uat-app-next.workjam.com");
        String name = crr.executeSelectQuery("Name");
        System.out.println("Database connection successful"+name);
        crr.explicitWait("lblLoginPageHeader", "Visible");
        lpf.getElement("lblLoginPageHeader").isDisplayed();
    }

	@When("^User enters (.*) in (.*) field$")
	public void user_enters_ros(String Value, String Element) throws InterruptedException {
		
		System.out.println("field name is :"+Element);
		lpf.getElement(Element).sendKeys(Value);	 
	    Thread.sleep(3000);
	}
	
	@When("User enter loginCredential details")
	public void login(DataTable table) {
		/*
		 * Map<String, String> data = table.asMap(String.class,String.class);
		 * System.out.println(data.get("username"));
		 * System.out.println(data.get("password"));
		 */
		List<Map<String, String>> data = table.asMaps(String.class,String.class);
		lpf.getElement("txtUserName").sendKeys(data.get(0).get("username"));
		//lpf.getElement("txtUserName").sendKeys(data.get("username"));
		lpf.getElement("btnContinue").click();
		lpf.getElement("btnBack").isDisplayed();
		lpf.getElement("txtPassword").sendKeys(data.get(0).get("password"));	
		//lpf.getElement("txtPassword").sendKeys(data.get("password"));	
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		lpf.getElement("btnContinue").click();
	}

	@Then("User lands on password screen")
	public void user_lands_on_password_screen() {
		lpf.getElement("btnBack").isDisplayed();
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		lpf.getElement("btnLogin").click();
	}

	@Then("User lands on Home screen")
	public void user_lands_on_home_screen() {
	   System.out.println("ALL STEPS DONE");
	}
	
	
	public Login() {
		
	}
}
