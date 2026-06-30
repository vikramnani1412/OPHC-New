package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadMedicalReportsPage {

    //Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//h2[.='Upload Medical Reports']")private WebElement MedicalReportsPageHeader;
    
    @FindBy(xpath="//button[@class='back-btn']")private WebElement BackBtn;
    
    @FindBy(xpath="//i[@class='bi bi-plus-circle-fill']")private WebElement UploadBtn;
    
    @FindBy(xpath="//button[@class='submit-btn']")private WebElement SubmitBtn;
    
    @FindBy(xpath="//label[text()='WhatsApp ']/../following-sibling::input[contains(@placeholder,'')]")private WebElement WhatsappEdt;
    
    @FindBy(xpath="//input[@id='terms']")private WebElement TermsAndConditionsChckBox;
    
    @FindBy(xpath="//button[@type='submit']")private WebElement SignUpBtn;
    
    @FindBy(xpath="//a[.='Login']")private WebElement LoginLnk;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public UploadMedicalReportsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    
	//Rule-3:Provide getters to access these variables
	
	public WebElement getMedicalReportsPageHeader() {
		return MedicalReportsPageHeader;
	}


	public WebElement getBackBtn() {
		return BackBtn;
	}


	public WebElement getUploadBtn() {
		return UploadBtn;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
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
    
	
}
