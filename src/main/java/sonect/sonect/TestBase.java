package sonect.sonect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class TestBase 
{
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
					+"/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AppiumDriver<MobileElement> driver;

	public static void initialization(){
		
		try {
			
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Redmi");
		cap.setCapability("udid", "609834d5");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9 PKQ1.180904.001");
		cap.setCapability("appPackage", "ch.sonect.app.test");
		cap.setCapability("appActivity", "ch.sonect.app.MainActivity");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");		
		driver = new AndroidDriver<MobileElement>(url,cap);
		
		AppDriver.setDriver(driver);

		
		System.out.println("Application started.....");
		Thread.sleep(3000);		
		}
		catch(Exception e){
			System.out.println("Exception occurred.....");
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
