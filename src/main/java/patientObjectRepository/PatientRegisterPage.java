package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegisterPage {

	//Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//input[@placeholder='Enter full name']")private WebElement FullNameEdt;
    
    @FindBy(xpath="//input[@placeholder='name@example.com']")private WebElement EmailEdt;
    
    @FindBy(xpath="//label[text()='Phone Number ']/following-sibling::input[contains(@placeholder,'')]")private WebElement PhoneNumberEdt;
    
    @FindBy(xpath="//input[@formcontrolname='sameAsMobile']")private WebElement SameAsMobileChckBox;
    
    @FindBy(xpath="//label[text()='WhatsApp ']/../following-sibling::input[contains(@placeholder,'')]")private WebElement WhatsappEdt;
    
    @FindBy(xpath="//input[@id='terms']")private WebElement TermsAndConditionsChckBox;
    
    @FindBy(xpath="//button[@type='submit']")private WebElement SignUpBtn;
    
    @FindBy(xpath="//a[.='Login']")private WebElement LoginLnk;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public PatientRegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
    
	//Rule-3:Provide getters to access these variables
	
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}


	public WebElement getEmailEdt() {
		return EmailEdt;
	}


	public WebElement getPhoneNumberEdt() {
		return PhoneNumberEdt;
	}


	public WebElement getSameAsMobileChckBox() {
		return SameAsMobileChckBox;
	}


	public WebElement getWhatsappEdt() {
		return WhatsappEdt;
	}


	public WebElement getTermsAndConditionsChckBox() {
		return TermsAndConditionsChckBox;
	}


	public WebElement getSignUpBtn() {
		return SignUpBtn;
	}


	public WebElement getLoginLnk() {
		return LoginLnk;
	}
	
	
	//Business Library
	
	public void registerAsPatient(String Fullname, String Email, String PhoneNum) throws Exception
	{
		Thread.sleep(2000);
		FullNameEdt.sendKeys(Fullname);
		Thread.sleep(2000);
		EmailEdt.sendKeys(Email);
		Thread.sleep(2000);
		PhoneNumberEdt.sendKeys(PhoneNum);
		Thread.sleep(2000);
		SameAsMobileChckBox.click();
		Thread.sleep(2000);
		TermsAndConditionsChckBox.click();
		Thread.sleep(2000);
		SignUpBtn.click();
		Thread.sleep(2000);
		
	}
	
}
