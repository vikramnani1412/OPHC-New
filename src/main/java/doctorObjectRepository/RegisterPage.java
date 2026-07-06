package doctorObjectRepository;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class RegisterPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@formcontrolname='fullName']")private WebElement FullNameEdt;
    
    @FindBy(xpath="//input[@formcontrolname='email']")private WebElement EmailEdt;
    
    @FindBy(xpath="//input[@formcontrolname='phone']")private WebElement PhoneEdt;
    
    @FindBy(xpath="//input[@formcontrolname='whatsapp']")private WebElement WhatsappEdt;
    
    @FindBy(xpath="//input[@formcontrolname='sameAsMobile']")private WebElement SameAsMobileNumberCheckBox;
    
    @FindBy(xpath="//input[@formcontrolname='terms']")private WebElement TermsAndConditionsCheckBox;
    
    @FindBy(xpath="//span[.='Terms']")private WebElement TermsLnk;
    
    @FindBy(xpath="//span[.='Privacy Policies']")private WebElement PrivacyAndPolicyLnk;
    
    @FindBy(xpath="//button[.=' Sign up ']")private WebElement SignUpBtn;
    
    @FindBy(xpath="//a[.=' Login ']")private WebElement LoginLnk;
    
    @FindBy(xpath="//div[.=' An account with this email already exists. Please login.']")private WebElement AccountExistMsgTxt;
    
    @FindBy(xpath="//span[.=' Close ']")private WebElement CloseBtn;
    
    @FindBy(xpath="//label[.=' Full Name ']/following-sibling::div[.=' Full Name is required ']")private WebElement FullNameError;
    
    @FindBy(xpath="//label[.=' Email Address ']/following-sibling::div[.='Email is required']")private WebElement EmailRequiredError;
    
    @FindBy(xpath="//label[.=' Email Address ']/following-sibling::div[.='Invalid email format']")private WebElement InvalidEmailError;
    
    @FindBy(xpath="//label[.=' Phone Number ']/following-sibling::div[.=' Phone number is required ']")private WebElement PhoneNumberRequiredError;
    
    @FindBy(xpath="//label[.=' Phone Number ']/following-sibling::div[.=' Please enter a valid 10-digit phone number ']")private WebElement ValidPhoneNumberError;
    
    
    
    @FindBy(xpath="//div[.=' You must agree to the terms and privacy policies ']")private WebElement TermsNdConditionsError;
    
    
	//Rule-3:Create a constructor to initilise these elements    
    
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-4:Provide getters to access these variables
	
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getEmailEdt() {
		return EmailEdt;
	}

	public WebElement getPhoneEdt() {
		return PhoneEdt;
	}

	public WebElement getWhatsappEdt() {
		return WhatsappEdt;
	}

	public WebElement getSameAsMobileNumberCheckBox() {
		return SameAsMobileNumberCheckBox;
	}

	public WebElement getTermsAndConditionsCheckBox() {
		return TermsAndConditionsCheckBox;
	}

	public WebElement getTermsLnk() {
		return TermsLnk;
	}


	public WebElement getPrivacyAndPolicyLnk() {
		return PrivacyAndPolicyLnk;
	}


	public WebElement getSignUpBtn() {
		return SignUpBtn;
	}
	

	public WebElement getAccountExistMsgTxt() {
		return AccountExistMsgTxt;
	}


	public WebElement getCloseBtn() {
		return CloseBtn;
	}


	public WebElement getFullNameError() {
		return FullNameError;
	}


	public WebElement getEmailRequiredError() {
		return EmailRequiredError;
	}


	public WebElement getInvalidEmailError() {
		return InvalidEmailError;
	}


	public WebElement getPhoneNumberRequiredError() {
		return PhoneNumberRequiredError;
	}


	public WebElement getValidPhoneNumberError() {
		return ValidPhoneNumberError;
	}


	public WebElement getTermsNdConditionsError() {
		return TermsNdConditionsError;
	}


	public WebElement getLoginLnk() {
		return LoginLnk;
	}
	
	//Business Library
	
	public void RegisterToDoctorApplication(WebDriver driver, String FullName , String Email, String PhoneNumber) throws Exception
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		String name = jUtil.getRandomName().trim();
		String Name = name.split("\\s+")[1];
		//System.out.println(Name+" Doctor Registering to the App");
		Thread.sleep(2000);
		FullNameEdt.sendKeys(FullName);
		Thread.sleep(2000);
		EmailEdt.sendKeys(Email);
		Thread.sleep(2000);
		PhoneEdt.sendKeys(PhoneNumber);
		Thread.sleep(2000);
		SameAsMobileNumberCheckBox.click();
		Thread.sleep(2000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(2000);
		SignUpBtn.click();
		Thread.sleep(2000);
		try {
			if(CloseBtn.isDisplayed())
			{
				CloseBtn.click();
				FullNameEdt.clear();
				Thread.sleep(2000);
				FullNameEdt.sendKeys(Name);
				Thread.sleep(2000);
				EmailEdt.clear();
				Thread.sleep(2000);
				EmailEdt.sendKeys(Name+"@gmail.com");
				Thread.sleep(2000);
				PhoneEdt.clear();
				Thread.sleep(2000);
				PhoneEdt.sendKeys(jUtil.getRandomMobileNum());
				Thread.sleep(2000);
				SameAsMobileNumberCheckBox.click();
				Thread.sleep(2000);
				TermsAndConditionsCheckBox.click();
				Thread.sleep(2000);
				SignUpBtn.click();
			}
		} catch (Exception e) {
				Thread.sleep(1000);
		}
		
		
	}
	
	
	public void RegisterToDoctorApplicationNegative(WebDriver driver) throws Exception
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String FullName = jUtil.getRandomSingleName();
		String Email    = FullName+"@gmail.com";
		String PhoneNumber = jUtil.getRandomMobileNum();
		int n = jUtil.getRandomNum();
		
		//System.out.println(Name+" Doctor Registering to the App");
		Thread.sleep(2000);
		FullNameEdt.sendKeys(FullName);
		Thread.sleep(2000);
		EmailEdt.sendKeys(Email);
		Thread.sleep(2000);
		PhoneEdt.sendKeys(PhoneNumber);
		Thread.sleep(2000);
		SameAsMobileNumberCheckBox.click();
		Thread.sleep(2000);
		TermsAndConditionsCheckBox.click();
		Thread.sleep(2000);
		try {
			if(SignUpBtn.isDisplayed())
			{
				FullNameEdt.click();
				Robot r = new Robot();
				for(int i=1;i<=10;i++)
				{
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_BACK_SPACE);
					r.keyRelease(KeyEvent.VK_BACK_SPACE);
				}
				
				
				FullNameEdt.clear();
				Thread.sleep(2000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "B_SignUp without FullName Error");
				}
				else 
				{
					wUtil.takeScreenShot(driver, "B_Accepted without FullName");
				}
				Thread.sleep(1000);
				FullNameEdt.sendKeys("i");
				Thread.sleep(2000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "C_SignUp with Single Letter as FullName Error");
				}
				else {
					wUtil.takeScreenShot(driver, "C_Accepted Single letter as FullName");
				}
				Thread.sleep(1000);
				FullNameEdt.clear();
				Thread.sleep(2000);
				FullNameEdt.sendKeys(FullName);
				Thread.sleep(2000);
				EmailEdt.clear();
				Thread.sleep(2000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "D_SignUp without Email Error");
				}
				else {
					wUtil.takeScreenShot(driver, "D_Accepted without Email");
				}
				Thread.sleep(2000);
				EmailEdt.sendKeys(FullName);
				Thread.sleep(2000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "E_SignUp with Invalid Email Error");
				}
				else {
					wUtil.takeScreenShot(driver, "E_Accepted Invalid Email");
				}
				Thread.sleep(2000);
				EmailEdt.clear();
				Thread.sleep(2000);
				EmailEdt.sendKeys(Email);
				Thread.sleep(2000);
				PhoneEdt.clear();
				Thread.sleep(2000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "F_SignUp without Phone Number Error");
				}
				else {
					wUtil.takeScreenShot(driver, "F_Accepted Without PhoneNumber");
				}
				Thread.sleep(1000);
				PhoneEdt.sendKeys("89745");
				Thread.sleep(1000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "G_SignUp with Invalid Phone Number Error");
				}
				else {
					wUtil.takeScreenShot(driver, "G_Accepted Invalid Phone Number");
				}
				Thread.sleep(1000);
				PhoneEdt.clear();
				Thread.sleep(2000);
				PhoneEdt.sendKeys(jUtil.getRandomMobileNum());
				Thread.sleep(2000);
				SameAsMobileNumberCheckBox.click();
				Thread.sleep(1000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "H_SignUp without Whatsapp Number Error");
				}
				else {
					wUtil.takeScreenShot(driver, "H_Accepted without whatsapp Number");
				}
				Thread.sleep(2000);
				SameAsMobileNumberCheckBox.click();
				Thread.sleep(2000);
				TermsAndConditionsCheckBox.click();
				Thread.sleep(1000);
				if(SignUpBtn.isDisplayed())
				{
					wUtil.takeScreenShot(driver, "I_SignUp without Agreeing Terms and Conditions Error");
				}
				else {
					wUtil.takeScreenShot(driver, "I_Accepted without Agreeing Terms and Conditions");
				}
				Thread.sleep(2000);
				TermsAndConditionsCheckBox.click();
				Thread.sleep(2000);
				SignUpBtn.click();
				Thread.sleep(2000);
				
				try {
					if (CloseBtn.isDisplayed()) {
						EmailEdt.clear();
						String PhoneNumberr = jUtil.getRandomMobileNum();
						String Emaill    = FullName+"yugugyu"+"@gmail.com";
						Thread.sleep(2000);
						EmailEdt.sendKeys(Emaill);
						Thread.sleep(3000);
						PhoneEdt.sendKeys(PhoneNumberr);
						Thread.sleep(2000);
						SignUpBtn.click();
					}
				} catch (Exception e) {
					Thread.sleep(1000);
				}
				
			}
		} catch (Exception e) {
				Thread.sleep(1000);
		}
		
		
	}
}
