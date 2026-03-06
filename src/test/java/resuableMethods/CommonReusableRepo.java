package resuableMethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigManager;
import utils.DatabaseConnection;

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
	
	public String fetchSpecificValueFromDB(String value,String tableName, String columnName, String columnValue) throws SQLException {
		String result = null;
		try {
			Statement stmt = DatabaseConnection.connectSQLServerDB().createStatement();
			String SQL = "Select "+value+" from "+tableName+"Where "+columnName+" = "+columnValue;
			ResultSet rs = stmt.executeQuery(SQL); //for select query
			while (rs.next()) {
				result = rs.getString(value);
				System.out.println("fetched value from DB is: " + rs.getString(value)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String executeSelectQuery(String value) throws SQLException {
		String result = null;
		try {
			Statement stmt = DatabaseConnection.connectSQLServerDB().createStatement();
			ResultSet rs = stmt.executeQuery(ConfigManager.get("Query")); //for select query
			while (rs.next()) {
				result = rs.getString(value);
				System.out.println("fetched value from DB is: " + rs.getString(value)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
