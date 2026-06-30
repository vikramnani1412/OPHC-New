package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(name="emailOrPhone")private WebElement EmailOrPhoneEdt;
    
    @FindBy(xpath="//button[.=' Login ']")private WebElement LoginBtn;
    
    @FindBy(xpath="//a[.='Register']")private WebElement RegisterLnk;
    
    @FindBy(xpath="//a[.='Terms & Conditions']")private WebElement TermsAndConditionsLnk;
    
    @FindBy(xpath="//a[.='Privacy & Policy']")private WebElement PrivacyAndPolicyLnk;
    
    @FindBy(xpath="//a[.='Telemedicine guidelines']")private WebElement TelemedicineGuidelinesLnk;
    
    @FindBy(xpath="//a[.='Professional conduct']")private WebElement ProfessionalConductLnk;
    
    @FindBy(xpath="//a[.='Refund Policy']")private WebElement RefundPolicyLnk;
    
    @FindBy(xpath="//a[.='Cancellation Policy']")private WebElement CancellationPolicyLnk;
    
    @FindBy(xpath="//a[.='No Show']")private WebElement NoShowLnk;
    
    @FindBy(xpath="//a[.='About Us']")private WebElement AboutUsLnk;
    
    @FindBy(xpath="//a[.='Help & Support']")private WebElement HelpAndSupportLnk;
    
    @FindBy(xpath="//a[.='FAQ']")private WebElement FAQLnk;
    
    @FindBy(xpath="//a[.='Contact']")private WebElement ContactLnk;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public PatientLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    
	//Rule-3:Provide getters to access these variables
	
	public WebElement getEmailOrPhoneEdt() {
		return EmailOrPhoneEdt;
	}


	public WebElement getLoginBtn() {
		return LoginBtn;
	}


	public WebElement getRegisterLnk() {
		return RegisterLnk;
	}


	public WebElement getTermsAndConditionsLnk() {
		return TermsAndConditionsLnk;
	}


	public WebElement getPrivacyAndPolicyLnk() {
		return PrivacyAndPolicyLnk;
	}


	public WebElement getTelemedicineGuidelinesLnk() {
		return TelemedicineGuidelinesLnk;
	}


	public WebElement getProfessionalConductLnk() {
		return ProfessionalConductLnk;
	}


	public WebElement getRefundPolicyLnk() {
		return RefundPolicyLnk;
	}


	public WebElement getCancellationPolicyLnk() {
		return CancellationPolicyLnk;
	}


	public WebElement getNoShowLnk() {
		return NoShowLnk;
	}


	public WebElement getAboutUsLnk() {
		return AboutUsLnk;
	}


	public WebElement getHelpAndSupportLnk() {
		return HelpAndSupportLnk;
	}


	public WebElement getFAQLnk() {
		return FAQLnk;
	}


	public WebElement getContactLnk() {
		return ContactLnk;
	}
	
	//Business Library
	
	public void clickOnRegisterLnk(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		RegisterLnk.click();
	}
	
	
}
