package sonect.sonect;
	
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sonect.sonect.TestBase;
import sonect.sonect.Util;
import sonect.sonect.PhoneNo;

public class OnBoardingEUTest  extends TestBase{
		
		OnBoarding OnBoard;
		Util util;
		PhoneNo phoneno;
		
		public OnBoardingEUTest(){
		super();
		}	
		
	@BeforeMethod
	public void setUp(){
		
		initialization();
		OnBoard = new OnBoarding();
		util = new Util(null);
		phoneno = new PhoneNo();
		
		}
		
	@Test(priority = 1 , enabled = false)
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

	@Test(priority = 2 , enabled = false)
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
		
		Util.scrollIntoView(prop.getProperty("EUcountryName"));
		
		Thread.sleep(3000);
//		String policy =  driver.findElementById("ch.sonect.app.test:id/termsLabel").getText();
//		Assert.assertEquals(policy, "By signing up or logging in, you accept our Terms & Conditions and our Privacy Policy.","Policy Description not matched");
//		System.out.println(policy);
	
		OnBoard.continueBTN.click();
		
		util.waitForElementToBeClickable(OnBoard.back_BTN, 20);
		
		OnBoard.back_BTN.click();
		
		String searchKey= prop.getProperty("EUcountryName").substring(0,6);
		
		OnBoard.dropdown.click();
		Thread.sleep(3000);
		
		OnBoard.countrySearch.sendKeys(searchKey);
		
		boolean clearsearchbtn = driver.findElementById("ch.sonect.app.test:id/img_clear_query").isDisplayed();
		System.out.println(clearsearchbtn);
		
		for(WebElement el: OnBoard.searchResult)
	      {
	         if(el.getText().equals(prop.getProperty("EUcountryName")))
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
		
		Util.scrollIntoView(prop.getProperty("EUcountryName"));
		
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
		
		switch (prop.getProperty("EUcountryName")) {
		
		  case "Austria (AT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createAustriaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createAustriaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Belgium (BE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createBelgiumPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createBelgiumPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Bulgaria (BG)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createBulgariaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createBulgariaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Croatia (HR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCroatiaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createCroatiaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  
		    break;
		    
		  case "Cyprus (CY)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCyprusPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createCyprusPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Czech Republic (CZ)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCzechRepublicPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createCzechRepublicPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Denmark (DK)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createDenmarkPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createDenmarkPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Estonia (EE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createEstoniaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createEstoniaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Finland (FI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createFinlandPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createFinlandPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "France (FR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createFrancePhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createFrancePhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Germany (DE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createGermanyPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createGermanyPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Greece (GR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createGreecePhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createGreecePhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Hungary (HU)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createHungaryPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createHungaryPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Iceland (IS)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createIcelandPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createIcelandPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Ireland (IE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createIrelandPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createIrelandPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Italy (IT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createItalyPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createItalyPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Latvia (LV)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLatviaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createLatviaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Liechtenstein (LI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLiechtensteinPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createLiechtensteinPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Lithuania (LT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLithuaniaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createLithuaniaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Luxembourg (LU)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLuxembourgPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createLuxembourgPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Malta (MT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createMaltaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createMaltaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Mexico (MX)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createMexicoPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createMexicoPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Netherlands (NL)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createNetherlandsPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createNetherlandsPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Norway (NO)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createNorwayPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createNorwayPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Poland (PL)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createPolandPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createPolandPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Portugal (PT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createPortugalPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createPortugalPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Romania (RO)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createRomaniaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createRomaniaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Slovakia (SK)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSlovakiaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createSlovakiaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Slovenia (SI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSloveniaPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createSloveniaPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Spain (ES)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSpainPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createSpainPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "Sweden (SE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSwedenPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createSwedenPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		    
		  case "United Kingdom (GB)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createUKPhone());
			  Thread.sleep(3000);
	  
			  phoneRepeatMethod();
			  
			  if(OnBoard.BTN_Next_SignUpScreen.isEnabled()) {
					
				  OnBoard.BTN_Next_SignUpScreen.click();
					
				  throw new Exception("Continue Button shouldn't be enabled for incorrect phoneno"); 
				}
				
				else {
				  OnBoard.phoneNum.clear();			  
				  OnBoard.phoneNum.sendKeys(PhoneNo.createUKPhone());
				  Thread.sleep(3000);
				  OnBoard.BTN_Next_SignUpScreen.click();
				}  			  
		    break;
		}		
		
	}
	
	@Test(priority = 4)
	public void SonnectTanActivationScreenTest() throws Exception{
		
		commonMethod();
		
		OnBoard.BTN_Next_SignUpScreen.click();
		Thread.sleep(3000);
		
		boolean imagePresent = driver.findElementById("ch.sonect.app.test:id/animation_view_pv").isDisplayed();
		System.out.println("Is the image present on the TanActivationScreen: "+imagePresent);

//		String Title =  driver.findElementById("ch.sonect.app.test:id/tvTitle").getText();
//		Assert.assertEquals(Title, "Well done. What is the SMS code?","Title not matched");
//		System.out.println(Title);
//		
//		String Desc =  driver.findElementById("ch.sonect.app.test:id/tvDescrP1").getText();
//		Assert.assertEquals(Desc, "Didn't receive any code to +41 55 999 66 69? Get a new one in 18 seconds","Description not matched");
//		System.out.println(Desc);
	
		Thread.sleep(3000);
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("InvalidSmscode"));
		
		Thread.sleep(15000);
		
		if (driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]").getText() == "Click below to get a new code.") {
			
			OnBoard.BTN_Next_SignUpScreen.click();
			
			Thread.sleep(5000);
		}
				
		OnBoard.smsCodeScreenTextField.sendKeys(prop.getProperty("ValidSmscode"));
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);				
		
		}
	
	@Test(priority = 5, enabled = false)
	public void SonnectPersonalInfoScreenTest() throws Exception{
		
		commonMethod();
		
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
			
			OnBoard.emailField.sendKeys(PhoneNo.createEmail());
			Thread.sleep(3000);
			
			OnBoard.dobField.click();
			
//			System.out.println(OnBoard.datePicker.size());
			
//			OnBoard.datePicker.get(1).sendKeys(prop.getProperty("Date"));
//			Thread.sleep(3000);
//			
//			OnBoard.datePicker.get(2).sendKeys(prop.getProperty("Month"));
//			Thread.sleep(3000);
//			
//			OnBoard.datePicker.get(3).sendKeys(prop.getProperty("Year"));
//			Thread.sleep(3000);
			
			OnBoard.ok_BTN.click();
			Thread.sleep(3000);
			
			OnBoard.nextBTN_PersonalInfo.click();
			
			Thread.sleep(3000);
		}
		
		util.waitForElementToBeClickable(OnBoard.passCodeScreen1TextField, 20);
		
		}
	
	@Test(priority = 6, enabled = false)
	public void AddressScreenTest() throws Exception {
		
		commonMethod();
		
		Thread.sleep(3000);
		
		OnBoard.BTN_Next_SignUpScreen.click();
		
		Thread.sleep(3000);
		
		OnBoard.smsCodeScreenTextField.sendKeys("1234");
		
		Thread.sleep(5000);
		
		util.waitForElementToBeClickable(OnBoard.firstNameField, 20);

		OnBoard.firstNameField.sendKeys(prop.getProperty("FirstName"));
		Thread.sleep(3000);
			
		OnBoard.lastNameField.sendKeys(prop.getProperty("LastName"));
		Thread.sleep(3000);
		
		OnBoard.emailField.sendKeys(PhoneNo.createEmail());
		Thread.sleep(3000);
		
		OnBoard.dobField.click();
		Thread.sleep(3000);
		
		OnBoard.ok_BTN.click();
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
		OnBoard.searchAddress.sendKeys("Zu");
		
		OnBoard.addressList.click();
		
		Thread.sleep(3000);
		
		OnBoard.addressLine2.sendKeys("A502");
		Thread.sleep(3000);
		
		String textInsidePincodeBox = OnBoard.pinCode.getText();
		
		System.out.println(textInsidePincodeBox);
		Thread.sleep(3000);
		
		if(textInsidePincodeBox.isEmpty()) {
			
			OnBoard.pinCode.sendKeys("5505");
		}
		
		else {
		
		OnBoard.addressNext_BTN.click();
		Thread.sleep(3000);
		}
	}
	
	@Test(priority = 7, enabled = false)
	public void PasscodeScreenTest() throws Exception {
	
		commonMethod();
		
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
		
		OnBoard.emailField.sendKeys(PhoneNo.createEmail());
		Thread.sleep(3000);
		
		OnBoard.dobField.click();
		Thread.sleep(3000);
		
		OnBoard.ok_BTN.click();
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
		OnBoard.searchAddress.sendKeys("Zu");
		
		OnBoard.addressList.click();
		
		Thread.sleep(3000);
		
		OnBoard.addressLine2.sendKeys("A502");
		Thread.sleep(3000);
		
		String textInsidePincodeBox = OnBoard.pinCode.getText();
		
		System.out.println(textInsidePincodeBox);
		Thread.sleep(3000);
		
		if(textInsidePincodeBox.isEmpty()) {
			
			OnBoard.pinCode.sendKeys("5505");
		}
		
		else {
		
		OnBoard.addressNext_BTN.click();
		
		}
		Thread.sleep(3000);
		
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
	
	@Test(priority = 8, enabled = false)
	public void NotificationScreenTest() throws Exception {
		
		commonMethod();
		
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
		
		OnBoard.emailField.sendKeys(PhoneNo.createEmail());
		Thread.sleep(3000);
		
		OnBoard.dobField.click();
		Thread.sleep(3000);
		
		OnBoard.ok_BTN.click();
		Thread.sleep(3000);
		
		OnBoard.nextBTN_PersonalInfo.click();
		
		Thread.sleep(3000);
		
		OnBoard.searchAddress.sendKeys("Zu");
		
		OnBoard.addressList.click();
		
		Thread.sleep(3000);
		
		OnBoard.addressLine2.sendKeys("A502");
		Thread.sleep(3000);
		
		String textInsidePincodeBox = OnBoard.pinCode.getText();
		
		System.out.println(textInsidePincodeBox);
		Thread.sleep(3000);
		
		if(textInsidePincodeBox.isEmpty()) {
			
			OnBoard.pinCode.sendKeys("5505");
		}
		
		else {
		
		OnBoard.addressNext_BTN.click();
		
		}
		Thread.sleep(3000);
		
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
		
//		String Desc =  driver.findElementByClassName("android.widget.TextView").getText();
//		Assert.assertEquals(Desc, "We'll send you helpful reminders about your Sonect account.","Description not matched");
//		System.out.println(Desc);
		
		OnBoard.agree_BTN.click();
		
//		boolean imagePresent1 = driver.findElementById("ch.sonect.app.test:id/animationView").isDisplayed();
//		System.out.println(imagePresent1);
		
//		String Title1 =  driver.findElementById("ch.sonect.app.test:id/titleView").getText();
//		Assert.assertEquals(Title1, "Welcome on board! Let's get started...","Title not matched");
//		System.out.println(Title1);
		
		Thread.sleep(5000);
		
		OnBoard.label_BTN.click();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void phoneRepeatMethod() throws Exception {
			
		  OnBoard.BTN_Next_SignUpScreen.click();
			
		  util.waitForElementToBeClickable(OnBoard.smsCodeScreenTextField, 20);
			
		  Thread.sleep(3000);
			
		  OnBoard.back_BTN.click();
			
		  OnBoard.dropdown.click();
		  Thread.sleep(3000);
			
		  Util.scrollIntoView(prop.getProperty("EUcountryName"));
			
		  Thread.sleep(3000);
			
		  OnBoard.phoneNum.clear();
			
		  OnBoard.phoneNum.sendKeys(prop.getProperty("InvalidPhoneno"));
			
		  Thread.sleep(3000);

	}
	
	public void commonMethod() throws Exception {
		
		Thread.sleep(3000);
		
		OnBoard.letsGo_BTN.click();
	
		Thread.sleep(3000);
	
		OnBoard.dropdown.click();
	
		Thread.sleep(3000);
	
		Util.scrollIntoView(prop.getProperty("EUcountryName"));
	
		Thread.sleep(3000);
	
		OnBoard.continueBTN.click();
	
		Thread.sleep(3000);	
		
		switch (prop.getProperty("EUcountryName")) {
		
		  case "Austria (AT)":
		
			  OnBoard.phoneNum.sendKeys(PhoneNo.createAustriaPhone());
			  Thread.sleep(3000);
			  break;
		  
		  case "Belgium (BE)":
				
			  OnBoard.phoneNum.sendKeys(PhoneNo.createBelgiumPhone());
			  Thread.sleep(3000);	  
			  break;
			  
		  case "Bulgaria (BG)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createBulgariaPhone());
			  Thread.sleep(3000);  			  
		    break;
		    
		  case "Croatia (HR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCroatiaPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Cyprus (CY)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCyprusPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Czech Republic (CZ)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createCzechRepublicPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Denmark (DK)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createDenmarkPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Estonia (EE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createEstoniaPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Finland (FI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createFinlandPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "France (FR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createFrancePhone());
			  Thread.sleep(3000); 
		    break;
		    
		  case "Germany (DE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createGermanyPhone());
			  Thread.sleep(3000);  
		    break;
		    
		  case "Greece (GR)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createGreecePhone());
			  Thread.sleep(3000); 
		    break;
		    
		  case "Hungary (HU)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createHungaryPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Iceland (IS)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createIcelandPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Ireland (IE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createIrelandPhone());
			  Thread.sleep(3000); 		  
		    break;
		    
		  case "Italy (IT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createItalyPhone());
			  Thread.sleep(3000);  		  
		    break;
		    
		  case "Latvia (LV)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLatviaPhone());
			  Thread.sleep(3000);  	  
		    break;
		    
		  case "Liechtenstein (LI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLiechtensteinPhone());
			  Thread.sleep(3000); 	  
		    break;
		    
		  case "Lithuania (LT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLithuaniaPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Luxembourg (LU)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createLuxembourgPhone());
			  Thread.sleep(3000);  	  
		    break;
		    
		  case "Malta (MT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createMaltaPhone());
			  Thread.sleep(3000);		  
		    break;
		    
		  case "Mexico (MX)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createMexicoPhone());
			  Thread.sleep(3000);  
		    break;
		    
		  case "Netherlands (NL)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createNetherlandsPhone());
			  Thread.sleep(3000); 
		    break;
		    
		  case "Norway (NO)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createNorwayPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Poland (PL)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createPolandPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Portugal (PT)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createPortugalPhone());
			  Thread.sleep(3000);
		    break;
		    
		  case "Romania (RO)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createRomaniaPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Slovakia (SK)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSlovakiaPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Slovenia (SI)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSloveniaPhone());
			  Thread.sleep(3000); 			  
		    break;
		    
		  case "Spain (ES)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSpainPhone());
			  Thread.sleep(3000);	  
		    break;
		    
		  case "Sweden (SE)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createSwedenPhone());
			  Thread.sleep(3000);  
		    break;
		    
		  case "United Kingdom (GB)":
			  
			  OnBoard.phoneNum.sendKeys(PhoneNo.createUKPhone());
			  Thread.sleep(3000); 			  
		    break;
	}
		
	}
	
}
