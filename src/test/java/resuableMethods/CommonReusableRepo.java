package resuableMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonReusableRepo {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public CommonReusableRepo(WebDriver driver) {
		this.driver = driver;
	}
	
	public void explicitWait(WebElement Element, String Condition){
		switch (Condition) {
		case "visible":
			wait.until(ExpectedConditions.visibilityOf(Element));
			break;
		case "inivisible":
			wait.until(ExpectedConditions.invisibilityOf(Element));
			break;
		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			break;
		default:
			break;
		}
	}
		
	public void explicitWait(String elementXpath, String Condition){
		switch (Condition) {
		case "visible":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
			break;
		case "inivisible":
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
			break;
		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
			break;
		case "Presence":
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
			break;
		default:
			break;
		}
		
		
	}
}
