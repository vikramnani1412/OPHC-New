package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.JavaUtility;

public class DrRegisterPage {

	//Finding WebElements Using @FindBy Annotations
	
    @FindBy(xpath="//input[@formcontrolname='fullName']")private WebElement FullNameEdt;
    
    @FindBy(xpath="//input[@formcontrolname='email']")private WebElement EmailEdt;
    
    @FindBy(xpath="//input[@formcontrolname='phone']")private WebElement PhoneEdt;
    
    @FindBy(xpath="//input[@formcontrolname='whatsapp']")private WebElement WhatsappNoEdt;
    
    @FindBy(xpath="//input[@id='sameAsMobile']")private WebElement WhatsappNumSameAsMobileChkBox;
    
    @FindBy(xpath="//input[@id='terms']")private WebElement TermsAndConditionsChkBox;
    
    @FindBy(xpath="//a[.='Terms']")private WebElement TermsLnk;
    
    @FindBy(xpath="//a[.='Privacy Policies']")private WebElement PrivacyPoliciesLnk;
    
    @FindBy(xpath="//button[.=' Sign up ']")private WebElement SignUpBtn;
    
    @FindBy(xpath="//a[.=' Login ']")private WebElement LoginLnk;
  
	//Rule-3:Create a constructor to initilise these elements
    
	public DrRegisterPage(WebDriver driver)
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

	public WebElement getWhatsappNoEdt() {
		return WhatsappNoEdt;
	}

	public WebElement getWhatsappNumSameAsMobileChkBox() {
		return WhatsappNumSameAsMobileChkBox;
	}

	public WebElement getTermsAndConditionsChkBox() {
		return TermsAndConditionsChkBox;
	}

	public WebElement getTermsLnk() {
		return TermsLnk;
	}

	public WebElement getPrivacyPoliciesLnk() {
		return PrivacyPoliciesLnk;
	}

	public WebElement getSignUpBtn() {
		return SignUpBtn;
	}

	public WebElement getLoginLnk() {
		return LoginLnk;
	}
	
	
	
	//Business Library
	
	public void DoctorRegistration()
	{
		JavaUtility jUtil = new JavaUtility();
		
		FullNameEdt.sendKeys("");
	}
	
	
	
}
