package sonect.sonect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import io.appium.java_client.android.AndroidDriver;
import sonect.sonect.TestBase;
import sonect.sonect.Util;

public class OnBoardingCHTest extends TestBase{
	
	public String firstNumber;
	
	public String createFirstPhone() {
		String timeStamp = new SimpleDateFormat("ddMMyy").format(new Date());
		firstNumber= "788" + timeStamp ;
		System.out.println(firstNumber);
		return firstNumber;
	}
	
	public String increaseWithOne(String fn) {
		int intPhone = Integer.parseInt(fn) + 1;
		firstNumber = Integer.toString(intPhone);
		return firstNumber;
	}
	
	OnBoarding OnBoard;
	Util util;
	
	public OnBoardingCHTest(){
		super();
	}	
		
	
	@BeforeTest
	public void testSetup() {
		createFirstPhone();
	}
	
	@BeforeMethod
	public void setUp(){
		 
		initialization();
		OnBoard = new OnBoarding();
		util = new Util(null);
		
	}
	
	@Test(priority = 1)
	public void SonnectHomePageTest() throws Exception{
		
		Thread.sleep(3000);
		
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animation_view_tutorial").isDisplayed();
		System.out.println("Is the image present on Home Page: "+imagePresent);
		
		String Title =  driver.findElementById("ch.sonect.app.test:id/headerSlider").getText();
		Assert.assertEquals(Title, "Welcome to Sonect","Title not matched");
		System.out.println(Title);
		
		String Desc =  driver.findElementById("ch.sonect.app.test:id/subHeaderSlider").getText();
		Assert.assertEquals(Desc, "Withdrawing cash has just gotten a whole lot easier. No matter where you are, we're bringing the ATM to you.","Description not matched");
		System.out.println(Desc);
		
		String Letsgo =  OnBoard.letsGo_BTN.getText();
		Assert.assertEquals(Letsgo, "Let's go!","Text not matched");
		System.out.println(Letsgo);
		
		String Shops =  OnBoard.sonectShopBTN.getText();
		Assert.assertEquals(Shops, "Sonect shops","Text not matched");
		System.out.println(Shops);
		
		util.waitForElementToBeClickable(OnBoard.slider, 20);
			
		OnBoard.slider.click();
		
//		String Title1 =  driver.findElementById("ch.sonect.app.test:id/headerSlider").getText();
//		Assert.assertEquals(Title1, "Get Your Cash Right Here, Right Now","Title not matched");
//		System.out.println(Title1);
//		
//		String Desc1 =  driver.findElementById("ch.sonect.app.test:id/subHeaderSlider").getText();
//		Assert.assertEquals(Desc1, "At your local bar, your favourite restaurant or bakery around the corner. Withdraw cash anywhere near you.","Description not matched");
//		System.out.println(Desc1);
		
		util.waitForElementToBeClickable(OnBoard.letsGo_BTN, 20);
		
		OnBoard.letsGo_BTN.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		OnBoard.sonectShopBTN.click();
		
		Thread.sleep(3000);
		
		OnBoard.Allow.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		}
	
	@Test(priority = 2)
	public void SonnectCountryPickerScreenTest() throws Exception{
		
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
		
		Thread.sleep(3000);
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/imgHand").isDisplayed();
		System.out.println("Is the image present on countrypickerscreen: "+imagePresent);
		
		boolean backarrow = driver.findElementById("ch.sonect.app.test:id/btnBack").isDisplayed();
		System.out.println("Is the back arrow present on countrypickerscreen: "+backarrow);
		
		String Title =  driver.findElementById("ch.sonect.app.test:id/tvTitle").getText();
		Assert.assertEquals(Title, "Let's open your Sonect account","Title not matched");
		System.out.println(Title);
		
		String Desc =  driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText();
		Assert.assertEquals(Desc, "To start, tell us your country of residence so we can store your data properly.","Description not matched");
		System.out.println(Desc);
		
		Thread.sleep(3000);
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		int size= OnBoard.countryList.size();
		System.out.println("size : "+size);
		
		Util.scrollIntoView("Switzerland (CH)");
		
		Thread.sleep(3000);
//		String policy =  driver.findElementById("ch.sonect.app.test:id/termsLabel").getText();
//		Assert.assertEquals(policy, "By signing up or logging in, you accept our Terms & Conditions and our Privacy Policy.","Policy Description not matched");
//		System.out.println(policy);
	
		OnBoard.continueBTN.click();
		
		util.waitForElementToBeClickable(OnBoard.back_BTN, 20);
		
		OnBoard.back_BTN.click();
		
		String searchKey="Sw";
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		OnBoard.countrySearch.sendKeys(searchKey);
		
		boolean clearsearchbtn = driver.findElementById("ch.sonect.app.test:id/img_clear_query").isDisplayed();
		System.out.println(clearsearchbtn);
		
		for(WebElement el: OnBoard.searchResult)
	      {
	         if(el.getText().equals("Switzerland (CH)"))
	         {
	            el.click();
	            Thread.sleep(3000);
	            System.out.println("Element Clicked");
	            break;
	         }

	      }
		Thread.sleep(3000);
		
		OnBoard.continueBTN.click();
		
		util.waitForElementToBeClickable(OnBoard.back_BTN, 20);
		
		}
	
	@Test(priority = 3)
	public void SonnectPhoneNumberScreenTest() throws Exception{
		
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
		
		Thread.sleep(3000);
		
		OnBoard.dropdown.click();
		
		Thread.sleep(3000);
		
		Util.scrollIntoView("Switzerland (CH)");
		
		Thread.sleep(3000);
		
		OnBoard.continueBTN.click();
		
		Thread.sleep(3000);
		
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/imgHand").isDisplayed();
		System.out.println("Is the image present on the PhoneNumberScreen: "+imagePresent);
		
		String Title =  OnBoard.TextView_PhoneNoScreen.getText();
		Assert.assertEquals(Title, "Sign up or Login with your phone number","Title not matched");
		System.out.println(Title);
		
//		String Desc =  OnBoard.phoneNumScreenDescription.getText();
//		Assert.assertEquals(Desc, "We will send you an SMS code. Enter the code at the next step.","Description not matched");
//		System.out.println(Desc);
		
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		util.waitForElementToBeClickable(OnBoard.smsCodeScreenTextField, 20);
		
		Thread.sleep(3000);
		
		OnBoard.back_BTN.click();
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		int size= OnBoard.countryList.size();
		System.out.println("size : "+size);
		
		Util.scrollIntoView("Switzerland (CH)");
		
		Thread.sleep(3000);
		
		OnBoard.phoneNum.clear();
		
		OnBoard.phoneNum.sendKeys(prop.getProperty("InvalidPhoneno"));
		
		Thread.sleep(3000);
		
		if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
			
			OnBoard.BTN_Next_SignUpScreen.click();
			
			throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
		}
		
		else {
			OnBoard.phoneNum.clear();
			OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
			Thread.sleep(3000);
			OnBoard.BTN_Next_SignUpScreen.click();
		}
				
		util.waitForElementToBeClickable(OnBoard.smsCodeScreenTextField, 20);
		
		Thread.sleep(3000);
		
		}
	
	@Test(priority = 4)
	public void SonnectTanActivationScreenTest() throws Exception{
		
		Thread.sleep(3000);
	
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
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
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("InvalidSmscode"));
		
		Thread.sleep(20000);
		
		if (driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText() =="Click below to get a new code.") {
			
			OnBoard.BTN_Next_SignUpScreen.click();
			
			Thread.sleep(5000);
		}
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);				
		
		}
	
	@Test(priority = 5)
	public void SonnectPersonalInfoScreenTest() throws Exception{
		
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		Thread.sleep(3000);
		
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);
	
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animationImageView").isDisplayed();
		System.out.println("Is the image present on the personalinfoscreen: "+imagePresent);
	
		String Title =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
		Assert.assertEquals(Title, "Perfect! Please tell us a bit about yourself","Title not matched");
		System.out.println(Title);
		
		Thread.sleep(3000);
		
		if(OnBoard.nextBTN_PersonalInfo.isEnabled()) {
			
			OnBoard.nextBTN_PersonalInfo.click();
			
			throw new Exception("Continue Button shouldn't be enabled for blank entry"); 
		}
		
		else {
			
			OnBoard.firstNameField.sendKeys(prop.getProperty("FirstName"));
			Thread.sleep(3000);
				
			OnBoard.lastNameField.sendKeys(prop.getProperty("LastName"));
			Thread.sleep(3000);
			
			OnBoard.nextBTN_PersonalInfo.click();
			
			Thread.sleep(3000);
		}
		
		util.waitForElementToBeClickable(OnBoard.passCodeScreen1TextField, 20);
		
		}
	
	@Test(priority = 6)
	public void AddressScreenTest() throws Exception {
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		Thread.sleep(3000);
		
		OnBoard.smsCodeScreenTextField.sendKeys("1234");
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);

		OnBoard.firstNameField.sendKeys("Harry");
		Thread.sleep(3000);
		
		OnBoard.lastNameField.sendKeys("Gurrapu");
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
		if(OnBoard.searchAddress.isEnabled())
		{
		
		OnBoard.searchAddress.sendKeys("Zu");
		
		OnBoard.addressList.click();
		
		OnBoard.addressNext_BTN.click();
		}
		
		else
		{
			driver.quit();
		}
	}
	
	@Test(priority = 7)
	public void PasscodeScreenTest() throws Exception {
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");

		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);
	
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		Thread.sleep(3000);
		
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);

		OnBoard.firstNameField.sendKeys(prop.getProperty("FirstName"));
		Thread.sleep(3000);
		
		OnBoard.lastNameField.sendKeys(prop.getProperty("LastName"));
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
//		OnBoard.searchAddress.sendKeys("Zu");
		
//		OnBoard.addressList.click();
		
//		OnBoard.addressNext_BTN.click();
		
//		Thread.sleep(3000);
		
		boolean imagePresent1 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the passcodescreen1: "+imagePresent1);
		
		String Title1 =  driver.findElementById("ch.sonect.app.test:id/greetingsLabel").getText();
		Assert.assertEquals(Title1, "Enter a personal passcode and make your account bulletproof","Title not matched");
		System.out.println(Title1);
	
		OnBoard.passCodeScreen1TextField.sendKeys(prop.getProperty("ValidPasscode"));
		
		Thread.sleep(3000);
		
		boolean imagePresent2 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the passcodescreen2: "+imagePresent2);
		
		String Title2 =  driver.findElementById("ch.sonect.app.test:id/greetingsLabel").getText();
		Assert.assertEquals(Title2, "Please repeat your passcode","Title not matched");
		System.out.println(Title2);
		
		OnBoard.passCodeScreen2TextField.sendKeys(prop.getProperty("InvalidPasscode"));
		Thread.sleep(3000);
		
		OnBoard.passCodeScreen1TextField.sendKeys(prop.getProperty("ValidPasscode"));
		Thread.sleep(3000);
		OnBoard.passCodeScreen2TextField.sendKeys(prop.getProperty("ValidPasscode"));	
		Thread.sleep(3000);
		
		util.waitForElementToBeClickable(OnBoard.agree_BTN, 20);			
	}
	
	@Test(priority = 8)
	public void NotificationScreenTest() throws Exception {
		
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView("Switzerland (CH)");
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);	
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		Thread.sleep(3000);
		
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);

		OnBoard.firstNameField.sendKeys(prop.getProperty("FirstName"));
		Thread.sleep(3000);
		
		OnBoard.lastNameField.sendKeys(prop.getProperty("LastName"));
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
//		OnBoard.searchAddress.sendKeys("Zu");
//		
//		OnBoard.addressList.click();
//		
//		OnBoard.addressNext_BTN.click();
//		
//		Thread.sleep(3000);
		
		OnBoard.passCodeScreen1TextField.sendKeys(prop.getProperty("ValidPasscode"));
		
		Thread.sleep(3000);
		
		OnBoard.passCodeScreen2TextField.sendKeys(prop.getProperty("ValidPasscode"));
		
		Thread.sleep(3000);
	
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the NotificationScreen: "+imagePresent);
		
		boolean skipbtn = driver.findElementById("ch.sonect.app.test:id/animationView").isEnabled();
		System.out.println("Is the Skip button present on the NotificationScreen: "+skipbtn);
		
		String Title =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
		Assert.assertEquals(Title, "Notifications","Title not matched");
		System.out.println(Title);
		
		String Desc =  driver.findElementByClassName("android.widget.TextView").getText();
		Assert.assertEquals(Desc, "We'll send you helpful reminders about your Sonect account.","Description not matched");
		System.out.println(Desc);
		
		OnBoard.agree_BTN.click();
		
//		boolean imagePresent1 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
//		System.out.println(imagePresent1);
		
//		String Title1 =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
//		Assert.assertEquals(Title1, "Welcome on board! Let's get started...","Title not matched");
//		System.out.println(Title1);
		
		Thread.sleep(5000);
		
		OnBoard.label_BTN.click();
		
	}
	
	
	@Test(priority = 9)
	public void SonnectFlow() throws Exception {
		
		Thread.sleep(3000);
		
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animation_view_tutorial").isDisplayed();
		System.out.println("Is the image present on Home Page: "+imagePresent);
		
		String Title =  driver.findElementById("ch.sonect.app.test:id/headerSlider").getText();
		Assert.assertEquals(Title, "Welcome to Sonect","Title not matched");
		System.out.println(Title);
		
		String Desc =  driver.findElementById("ch.sonect.app.test:id/subHeaderSlider").getText();
		Assert.assertEquals(Desc, "Withdrawing cash has just gotten a whole lot easier. No matter where you are, we're bringing the ATM to you.","Description not matched");
		System.out.println(Desc);
		
		util.waitForElementToBeClickable(OnBoard.letsGo_BTN, 20);
		
		OnBoard.letsGo_BTN.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		OnBoard.sonectShopBTN.click();
		
		Thread.sleep(3000);
		
		OnBoard.Allow.click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		util.waitForElementToBeClickable(OnBoard.letsGo_BTN, 20);
		
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
		
		Thread.sleep(3000);
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		int size= OnBoard.countryList.size();
		System.out.println("size : "+size);
		
		Util.scrollIntoView("Switzerland (CH)");
		
		Thread.sleep(3000);
//		String policy =  driver.findElementById("ch.sonect.app.test:id/termsLabel").getText();
//		Assert.assertEquals(policy, "By signing up or logging in, you accept our Terms & Conditions and our Privacy Policy.","Policy Description not matched");
//		System.out.println(policy);
	
		OnBoard.continueBTN.click();
		
		util.waitForElementToBeClickable(OnBoard.back_BTN, 20);
		
		OnBoard.back_BTN.click();
		
		String searchKey="Sw";
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		OnBoard.countrySearch.sendKeys(searchKey);
		
		boolean clearsearchbtn = driver.findElementById("ch.sonect.app.test:id/img_clear_query").isDisplayed();
		System.out.println(clearsearchbtn);
		
		for(WebElement el: OnBoard.searchResult)
	      {
	         if(el.getText().equals("Switzerland (CH)"))
	         {
	            el.click();
	            Thread.sleep(3000);
	            System.out.println("Element Clicked");
	            break;
	         }

	      }
		Thread.sleep(3000);
		
		OnBoard.continueBTN.click();
		
		util.waitForElementToBeClickable(OnBoard.back_BTN, 20);Thread.sleep(3000);
		
		boolean imagePresent2 = driver.findElementById("ch.sonect.app.test:id/imgHand").isDisplayed();
		System.out.println("Is the image present on the PhoneNumberScreen: "+imagePresent2);
		
		String Title2 =  OnBoard.TextView_PhoneNoScreen.getText();
		Assert.assertEquals(Title2, "Sign up or Login with your phone number","Title not matched");
		System.out.println(Title2);
		
//		String Desc2 =  OnBoard.phoneNumScreenDescription.getText();
//		Assert.assertEquals(Desc2, "We will send you an SMS code. Enter the code at the next step.","Description not matched");
//		System.out.println(Desc2);
		
		Thread.sleep(3000);
		
		OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		util.waitForElementToBeClickable(OnBoard.smsCodeScreenTextField, 20);
		
		Thread.sleep(3000);
		
		OnBoard.back_BTN.click();
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		Util.scrollIntoView("Switzerland (CH)");
		
		Thread.sleep(3000);
		
		OnBoard.phoneNum.clear();
		
		OnBoard.phoneNum.sendKeys(prop.getProperty("InvalidPhoneno"));
		
		Thread.sleep(3000);
		
		if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
			
			OnBoard.BTN_Next_SignUpScreen.click();
			
			throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
		}
		
		else {
			OnBoard.phoneNum.clear();
			OnBoard.phoneNum.sendKeys(increaseWithOne(firstNumber));
			Thread.sleep(3000);
			OnBoard.BTN_Next_SignUpScreen.click();
		}
				
		util.waitForElementToBeClickable(OnBoard.smsCodeScreenTextField, 20);
		
//		String Title3 =  driver.findElementById("ch.sonect.app.test:id/tvTitle").getText();
//		Assert.assertEquals(Title3, "Well done. What is the SMS code?","Title not matched");
//		System.out.println(Title3);
//		
//		String Desc3 =  driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText();
//		Assert.assertEquals(Desc3, "Didn't receive any code to +41 55 999 66 69? Get a new one in 18 seconds","Description not matched");
//		System.out.println(Desc3);
	
		Thread.sleep(3000);
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("InvalidSmscode"));
		
		Thread.sleep(20000);
		
		if (driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText() =="Click below to get a new code.") {
			
			OnBoard.BTN_Next_SignUpScreen.click();
			
			Thread.sleep(5000);
		}
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);	
		
		boolean imagePresent4 = driver.findElementById("ch.sonect.app.test:id/animationImageView").isDisplayed();
		System.out.println("Is the image present on the personalinfoscreen: "+imagePresent4);
	
		String Title4 =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
		Assert.assertEquals(Title4, "Perfect! Please tell us a bit about yourself","Title not matched");
		System.out.println(Title4);
		
		Thread.sleep(3000);
		
		if(OnBoard.nextBTN_PersonalInfo.isEnabled()) {
			
			OnBoard.nextBTN_PersonalInfo.click();
			
			throw new Exception("Continue Button shouldn't be enabled for blank entry"); 
		}
		
		else {
			
			OnBoard.firstNameField.sendKeys(prop.getProperty("FirstName"));
			Thread.sleep(3000);
				
			OnBoard.lastNameField.sendKeys(prop.getProperty("LastName"));
			Thread.sleep(3000);
			
			OnBoard.nextBTN_PersonalInfo.click();
			
			Thread.sleep(3000);
		}
		
		util.waitForElementToBeClickable(OnBoard.passCodeScreen1TextField, 20);
		
		boolean imagePresent5 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the passcodescreen1: "+imagePresent5);
		
		String Title5 =  driver.findElementById("ch.sonect.app.test:id/greetingsLabel").getText();
		Assert.assertEquals(Title5, "Enter a personal passcode and make your account bulletproof","Title not matched");
		System.out.println(Title5);
	
		OnBoard.passCodeScreen1TextField.sendKeys(prop.getProperty("ValidPasscode"));
		
		Thread.sleep(3000);
		
		boolean imagePresent6 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the passcodescreen2: "+imagePresent6);
		
		String Title6 =  driver.findElementById("ch.sonect.app.test:id/greetingsLabel").getText();
		Assert.assertEquals(Title6, "Please repeat your passcode","Title not matched");
		System.out.println(Title6);
		
		OnBoard.passCodeScreen2TextField.sendKeys(prop.getProperty("InvalidPasscode"));
		Thread.sleep(3000);
		
		OnBoard.passCodeScreen1TextField.sendKeys(prop.getProperty("ValidPasscode"));
		Thread.sleep(3000);
		OnBoard.passCodeScreen2TextField.sendKeys(prop.getProperty("ValidPasscode"));	
		Thread.sleep(3000);
		
		util.waitForElementToBeClickable(OnBoard.agree_BTN, 20);
		
		boolean imagePresent7 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
		System.out.println("Is the image present on the NotificationScreen: "+imagePresent7);
		
		boolean skipbtn = driver.findElementById("ch.sonect.app.test:id/animationView").isEnabled();
		System.out.println("Is the Skip button present on the NotificationScreen: "+skipbtn);
		
		String Title7 =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
		Assert.assertEquals(Title7, "Notifications","Title not matched");
		System.out.println(Title7);
		
		String Desc7 =  driver.findElementByClassName("android.widget.TextView").getText();
		Assert.assertEquals(Desc7, "We'll send you helpful reminders about your Sonect account.","Description not matched");
		System.out.println(Desc7);
		
		OnBoard.agree_BTN.click();
		
//		boolean imagePresent8 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
//		System.out.println(imagePresent1);
		
//		String Title8 =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
//		Assert.assertEquals(Title8, "Welcome on board! Let's get started...","Title not matched");
//		System.out.println(Title8);
		
		Thread.sleep(5000);
		
		OnBoard.label_BTN.click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

  }
	