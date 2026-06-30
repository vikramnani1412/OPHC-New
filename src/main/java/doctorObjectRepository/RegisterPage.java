package doctorObjectRepository;

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
				SignUpBtn.click();
			}
		} catch (Exception e) {
				Thread.sleep(1000);
		}
		
		
	}
}
