package sonect.sonect;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

	public class OnBoarding extends TestBase {
		
		//TestUtils elements;

		@FindBy(id ="ch.sonect.app.test:id/login")
		public WebElement letsGo_BTN;
			
		@FindBy(id = "ch.sonect.app.test:id/explore")
		public WebElement sonectShopBTN;
	
		@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]")
		public WebElement slider;
		
		@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
		public WebElement Allow;
		
		@FindBy(className = "android.view.ViewGroup")
		public WebElement nextScreen_viewGRP;
		
		@FindBy(id = "ch.sonect.app.test:id/rlClickConsumer")
		public WebElement countryDrpDwn;
		
		@FindBy(id="ch.sonect.app.test:id/editText_search")
		public WebElement countrySearch;
			
		//android.widget.TextView
		@FindAll({@FindBy(id="ch.sonect.app.test:id/textView_countryName")})
		public List<WebElement> countryList;
		
		@FindBy(id="ch.sonect.app.test:id/recycler_countryDialog")
		public WebElement CountryListLayout_Parent;
		
		@FindAll({@FindBy(id="ch.sonect.app.test:id/textView_countryName")})
		public List<WebElement> searchResult;
		
		@FindBy(id="ch.sonect.app.test:id/textView_selectedCountry")
		public WebElement selectedSearch;
		
		@FindBy(id="ch.sonect.app.test:id/imageView_arrow")
		public WebElement dropdown;
			
		@FindBy(id="ch.sonect.app.test:id/btnNext")
		public WebElement continueBTN;
		
		@FindBy(id="ch.sonect.app.test:id/btnBack")
		public WebElement back_BTN;
		
		@FindBy(id="ch.sonect.app.test:id/tvTitle")
		public WebElement TextView_PhoneNoScreen;;
		
		@FindBy(id="ch.sonect.app.test:id/etPhone")
		public WebElement phoneNum;
		
		@FindBy(id="ch.sonect.app.test:id/tvDescrP1")
		public WebElement phoneNumScreenDescription;
			
		@FindBy(id="ch.sonect.app.test:id/btnBack")
		public WebElement backBTN_PhoneNoScreen;
		
		@FindBy(id="ch.sonect.app.test:id/btnNext")
		public WebElement BTN_Next_SignUpScreen;
		
		@FindBy(id="ch.sonect.app.test:id/tvTitle")
		public WebElement smsCodeScreenTitle;
		
		@FindBy(className="android.widget.EditText")
		public WebElement smsCodeScreenTextField;
		
		@FindBy(className="ch.sonect.app.test:id/correctPinAnimation")
		public By correctPinAnnimation_smsCodeScreen;
		
		@FindBy(className="ch.sonect.app.test:id/animation_view_name")
		public WebElement personalInfoImage;
		
		@FindBy(id="ch.sonect.app.test:id/firstNameView")
		public WebElement firstNameField;
		
		@FindBy(id="ch.sonect.app.test:id/lastNameView")
		public WebElement lastNameField;
		
		@FindBy(id="ch.sonect.app.test:id/emailView")
		public WebElement emailField;
		
		@FindBy(id="ch.sonect.app.test:id/dateOfBirthView")
		public WebElement dobField;
		
		@FindAll({@FindBy(className="android.widget.NumberPicker")})
		public List<WebElement> datePicker;
		
		@FindBy(id="android:id/button1")
		public WebElement ok_BTN;
		
		@FindBy(id="ch.sonect.app.test:id/actionView")
		public WebElement nextBTN_PersonalInfo;
		
		@FindBy(id="ch.sonect.app.test:id/streetView")
		public WebElement searchAddress;
		
		@FindBy(id="ch.sonect.app.test:id/manualAdressLabel")
		public WebElement addressList;
		
		@FindBy(id="ch.sonect.app.test:id/houseNumberView")
		public WebElement addressLine2;
		
		@FindBy(id="ch.sonect.app.test:id/zipCodeView")
		public WebElement pinCode;
		
		@FindBy(id="ch.sonect.app.test:id/actionView")
		public WebElement addressNext_BTN;
		
		@FindBy(className="android.widget.EditText")
		public WebElement passCodeScreen1TextField;
		
		@FindBy(className="android.widget.EditText")
		public WebElement passCodeScreen2TextField;
		
		@FindBy(id="ch.sonect.app.test:id/yesActionView")
		public WebElement agree_BTN;
			
		@FindBy(id="ch.sonect.app.test:id/pin_hello_user")
		public WebElement personalCodeScreen;
		
		@FindBy(id="ch.sonect.app.test:id/viewPasscode")
		public WebElement passcodeField;
		
		@FindBy(id="ch.sonect.app.test:id/viewPasscode")
		public WebElement confirmPasscode;
		
		@FindBy(id="ch.sonect.app.test:id/tvGreetings")
		public WebElement dashboardWellcomeScreen;
		
		@FindBy(id="ch.sonect.app.test:id/withdrawTutorialLabel")
		public WebElement label_BTN;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN1;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN2;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN3;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN4;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN5;
		
		@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.TextView")
		public WebElement Key_BTN6;
		
		public OnBoarding(){
			PageFactory.initElements(driver, this);
		}
				
		
	}