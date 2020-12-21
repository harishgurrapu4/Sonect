package sonect.sonect;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExistingUserTest extends TestBase {

public String phoneNumber = "768111221";
	
	OnBoarding OnBoard;
	Util util;
	
	public ExistingUserTest(){
		super();
	}	
	
	@BeforeMethod
	public void setUp(){
		 
		initialization();
		OnBoard = new OnBoarding();
		util = new Util(null);
		
	}
	
	@Test(priority = 1)
	public void ExistingUserFlowTest() throws Exception{
		
		Thread.sleep(3000);
		
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animation_view_tutorial").isDisplayed();
		System.out.println("Is the image present on Home Page: "+imagePresent);
		
		String Title =  driver.findElementById("ch.sonect.app.test:id/headerSlider").getText();
		Assert.assertEquals(Title, "Welcome to Sonect","Title not matched");
		System.out.println(Title);
		
		String Desc =  driver.findElementById("ch.sonect.app.test:id/subHeaderSlider").getText();
		Assert.assertEquals(Desc, "Withdrawing cash has just gotten a whole lot easier. No matter where you are, we're bringing the ATM to you.","Description not matched");
		System.out.println(Desc);
		
		boolean SonnectShopBTN = OnBoard.sonectShopBTN.isEnabled();
		System.out.println(SonnectShopBTN);
		
		Thread.sleep(3000);
	
//		util.waitForElement(OnBoard.letsGo_BTN, 20);
		
		OnBoard.letsGo_BTN.click();
		
		Thread.sleep(3000);
		
		boolean imagePresent1 = driver.findElementById("ch.sonect.app.test:id/imgHand").isDisplayed();
		System.out.println("Is the image present on countrypickerscreen: "+imagePresent1);
		
		boolean backarrow = driver.findElementById("ch.sonect.app.test:id/btnBack").isDisplayed();
		System.out.println("Is the back arrow present on countrypickerscreen: "+backarrow);
		
		String Title1 =  driver.findElementById("ch.sonect.app.test:id/tvTitle").getText();
		Assert.assertEquals(Title1, "Let's open your Sonect account","Title not matched");
		System.out.println(Title1);
		
		String Desc1 =  driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText();
		Assert.assertEquals(Desc1, "To start, tell us your country of residence so we can store your data properly.","Description not matched");
		System.out.println(Desc1);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);
		
		boolean imagePresent2 = driver.findElementById("ch.sonect.app.test:id/imgHand").isDisplayed();
		System.out.println("Is the image present on PhoneNumberScreen: "+imagePresent2);
		
		String Title2 =  OnBoard.TextView_PhoneNoScreen.getText();
		Assert.assertEquals(Title2, "Sign up or Login with your phone number","Title not matched");
		System.out.println(Title2);
		
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(phoneNumber);
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		Thread.sleep(3000);
		
//		String Title =  driver.findElementById("ch.sonect.app.test:id/tvTitle").getText();
//		Assert.assertEquals(Title, "Well done. What is the SMS code?","Title not matched");
//		System.out.println(Title);
//		
//		String Desc =  driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText();
//		Assert.assertEquals(Desc, "Didn't receive any code to +41 55 999 66 69? Get a new one in 18 seconds","Description not matched");
//		System.out.println(Desc);
	
		Thread.sleep(3000);
				
		OnBoard.smsCodeScreenTextField.sendKeys("1234");
		
		Thread.sleep(5000);
		
		String Title3 =   driver.findElementById("ch.sonect.app.test:id/pin_code_forgot_textview").getText();
		Assert.assertEquals(Title3, "Forgot your passcode?","Title not matched");
		System.out.println(Title3);
		
		OnBoard.Key_BTN1.click();
		OnBoard.Key_BTN2.click();	
		OnBoard.Key_BTN3.click();	
		OnBoard.Key_BTN4.click();	
		OnBoard.Key_BTN5.click();	
		OnBoard.Key_BTN6.click();	
		
		Thread.sleep(5000);
		
		OnBoard.label_BTN.click();
		
		}
	
	
}
