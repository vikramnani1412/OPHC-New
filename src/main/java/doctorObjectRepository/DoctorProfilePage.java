package doctorObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorProfilePage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//li[.='Availability']")private WebElement AvailabilityLnk;
    
    @FindBy(xpath="//li[.='Appointments']")private WebElement AppointmentsLnk;
    
    @FindBy(xpath="//li[.='Patients']")private WebElement PatientsLnk;
    
    @FindBy(xpath="//li[.='Payouts / Billing']")private WebElement PayoutsAndBillingLnk;
    
    @FindBy(xpath="//li[.='Notifications']")private WebElement NotificationsLnk;
    
    @FindBy(xpath="//li[.='Help & Support']")private WebElement HelpAndSupportLnk;
    
    @FindBy(xpath="//li[.='Privacy & Consent']")private WebElement PrivacyLnk;
    
    @FindBy(xpath="//li[.='Account & Security']")private WebElement AccountsAndSecurityLnk;
    
    @FindBy(xpath="//li[.='Logout']")private WebElement LogoutLnk;
  
    
	//Rule-2:Create a constructor to initilise these elements
    
	public DoctorProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-3:Provide getters to access these variables

	public WebElement getAvailabilityLnk() {
		return AvailabilityLnk;
	}


	public WebElement getAppointmentsLnk() {
		return AppointmentsLnk;
	}


	public WebElement getPatientsLnk() {
		return PatientsLnk;
	}


	public WebElement getPayoutsAndBillingLnk() {
		return PayoutsAndBillingLnk;
	}


	public WebElement getNotificationsLnk() {
		return NotificationsLnk;
	}


	public WebElement getHelpAndSupportLnk() {
		return HelpAndSupportLnk;
	}


	public WebElement getPrivacyLnk() {
		return PrivacyLnk;
	}


	public WebElement getAccountsAndSecurityLnk() {
		return AccountsAndSecurityLnk;
	}


	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}
	
	// Business Library
	
	public void clickOnLogoutLnk() throws Exception
	{
		Thread.sleep(2000);
		LogoutLnk.click();
	}
}
