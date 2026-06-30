package patientObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientPage {

	//Finding WebElements Using @FindBy Annotations
    
	@FindBy(xpath="//img[@class='profile-avatar']")private WebElement PatientProfileIcon;
	
    @FindBy(xpath="//button[.=' ✏️ ']")private WebElement EditPatientProfileIcon;
    
    @FindBy(xpath="//span[.='My Appointment']")private WebElement MyAppointmentLnk;
    
    @FindBy(xpath="//span[.='Medical Records']")private WebElement MedicalRecordsLnk;
    
    @FindBy(xpath="//span[.='Payments']")private WebElement PaymentsLnk;
    
    @FindBy(xpath="//span[.='Notifications']")private WebElement NotificationsLnk;
    
    @FindBy(xpath="//span[.='Help & Support']")private WebElement HelpAndSupportLnk;
    
    @FindBy(xpath="//span[.='Privacy & Consent']")private WebElement PrivacyAndConsentLnk;
    
    @FindBy(xpath="//span[.='Account & Security']")private WebElement AccountAndSecurityLnk;
    
    @FindBy(xpath="//span[.='Log out']")private WebElement LogoutLnk;
    
    @FindBy(xpath="//button[@class='close-btn']")private WebElement PageCloseBtn;
  
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public PatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Rule-3:Provide getters to access these variables
	
	public WebElement getPatientProfileIcon() {
		return PatientProfileIcon;
	}
	

	public WebElement getPageCloseBtn() {
		return PageCloseBtn;
	}


	public WebElement getMyAppointmentLnk() {
		return MyAppointmentLnk;
	}


	public WebElement getMedicalRecordsLnk() {
		return MedicalRecordsLnk;
	}


	public WebElement getPaymentsLnk() {
		return PaymentsLnk;
	}


	public WebElement getNotificationsLnk() {
		return NotificationsLnk;
	}


	public WebElement getHelpAndSupportLnk() {
		return HelpAndSupportLnk;
	}


	public WebElement getPrivacyAndConsentLnk() {
		return PrivacyAndConsentLnk;
	}


	public WebElement getAccountAndSecurityLnk() {
		return AccountAndSecurityLnk;
	}


	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}

	
	// Business Library
	
	public void patientBookingDoctor(WebDriver driver, String DoctorName) throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h6[contains(.,'"+DoctorName+"')]/../../following-sibling::div//button[.='Book Now']")).click();
		System.out.println("Patient Booked Doctor");
	}
    
	
	
}
