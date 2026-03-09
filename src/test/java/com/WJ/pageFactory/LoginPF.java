package com.WJ.pageFactory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WJ.resuableMethods.CommonReusableRepo;

public class LoginPF {
	
	public WebDriver driver;
		
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[text()='Log in to your account']")
	WebElement lblLoginPageHeader;
	
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[@id='login-username']")
	WebElement txtUserName;
	
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[text()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[@type='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[text()='Back']")
	WebElement btnBack;
	
	@FindBy(xpath="//*[@class='flex flex-col h-screen']//*[text()='Log in']")
	WebElement btnLogin;
	
	private final Map<String, WebElement> loginData = new HashMap<String, WebElement>();
	
	public LoginPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		loginData.put("lblLoginPageHeader", lblLoginPageHeader);
		loginData.put("txtUserName", txtUserName);
		loginData.put("btnContinue", btnContinue);
		loginData.put("txtPassword", txtPassword);
		loginData.put("btnBack", btnBack);
		loginData.put("btnLogin", btnLogin);
		
	}
	
	public WebElement getElement(String elementName) {
		WebElement e = loginData.get(elementName);
		if(e == null) {
			throw new IllegalArgumentException("Undefined Element:"+elementName);
		}
		return e;		
	}
	
	/*
	 * public void enterUsername(String userName) { txtUserName.sendKeys(userName);
	 * }
	 * 
	 * public void enterPassword(String password) { txtPassword.sendKeys(password);;
	 * }
	 * 
	 * public void clickContinue() { btnContinue.click(); }
	 * 
	 * public void verifyLoginPage () { lblLoginPageHeader.isDisplayed(); }
	 * 
	 * public void verifyBackButton () { btnBack.isDisplayed(); }
	 * 
	 * public void clickLogin() { btnLogin.click(); }
	 */

}
