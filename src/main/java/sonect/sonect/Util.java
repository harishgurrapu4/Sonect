package sonect.sonect;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util{
	
	@SuppressWarnings("unchecked")
	public static void scrollIntoView(String Text){
        ((AndroidDriver<MobileElement>) AppDriver.getDriver()).findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" +Text+ "\").instance(0))").click();
    }
	
	private WebDriver driver = null;

	public Util(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementFluently(WebElement identifyBy, int seconds) {
		int retry = 0;
		int retryCount = seconds < 25 ? 2 : 1;
		while (retry < retryCount) {
			try {
				@SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.visibilityOf((identifyBy)));
			} catch (Exception ex) {
			}
			retry++;
		}
	}

	public void waitForElementsFluently(List<WebElement> identifyBy, int seconds) {
		int retry = 0;
		int retryCount = seconds < 25 ? 2 : 1;
		while (retry < retryCount) {
			try {
				@SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.visibilityOfAllElements(identifyBy));
			} catch (Exception ex) {
			}
			retry++;
		}
	}

	public void waitForElementToBeInvisible(By locator, int seconds) {
		int retry = 0;
		int retryCount = 1;
		while (retry < retryCount) {
			try {
				@SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
			} catch (Exception ex) {
			}
			retry++;
		}
	}

	public void waitForElementToBeClickable(WebElement element, int seconds) {
		int retry = 0;
		int retryCount = 1;
		while (retry < retryCount) {
			try {
				@SuppressWarnings("deprecation")
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
						.pollingEvery(200, TimeUnit.MILLISECONDS);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			} catch (Exception ex) {
			}
			retry++;
		}
	}

	
	// Method to check if an element is preesnt on the page
	public Boolean checkElementIsPresent(By locator) {
		this.waitForElementsFluently(driver.findElements(locator), 10);
		List<WebElement> result = driver.findElements(locator);
		if (result.size() > 0) {
			return true;
		} else
			return false;
	}

	// Get current date time value for test data
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmssddMM");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void waitForElement(WebElement identifyBy, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(identifyBy));//(landingScrnPO.letsGo_BTN));
	}
	

}
