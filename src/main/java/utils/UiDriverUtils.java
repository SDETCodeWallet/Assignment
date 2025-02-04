package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;

public class UiDriverUtils {
	private static WebDriver driver;
	private static int timeout = 50;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browserName = PropertiesReader.getProperty("browsername");

			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browserName);
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void moveToElement(WebElement we) {
		Actions actions = new Actions(driver);
		actions.moveToElement(we).build().perform();
	}
	

	public static void clickOnElement(WebElement we) {
		moveToElement(we);
		waitForElementToBeClickable(we);
		we.click();
	}
	
	public static void actionClick(WebElement we) {
		moveToElement(we);
		Actions actions = new Actions(driver);
		actions.doubleClick(we).build().perform();
	}


	public static void waitForElementToBeClickable(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}


	public static void waitFor(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

	public boolean isDisplayed(WebElement we) {	
		boolean flag = false;
		try {
		    if (we.isDisplayed()) {
		        flag = true; 
		    }
		} catch (NoSuchElementException | StaleElementReferenceException e) {
		    flag = false;
		}
		
		return flag;
		
	}

	public void sendKeys(WebElement we, String valueToEnter) {
		we.sendKeys(valueToEnter);
	}
		
	public void selectByVisibleText(WebElement we, String visibleText) {
		Select select=  new Select(we);	
		select.selectByVisibleText(visibleText);
	}
	
	
	

}
