package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class DoctorDetailsPage {

    //Rule-1: Finding WebElements Using @FindBy Annotations
    
	@FindBy(xpath="//div[@class='back-btn']")private WebElement BackBtn;
	
    @FindBy(xpath="//button[.=' Book Appointment ']")private WebElement BookAppointmentBtn;
    
    @FindBy(xpath="//button[.=' Doctor Info ']")private WebElement DoctorInfoBtn;
	
    @FindBy(xpath="//div[@class='time-slot-card available ng-star-inserted']")private WebElement FrstAvailableSlot;
    
    @FindBy(xpath="//button[contains(.,' Book Appointment')]")private WebElement AfterSlotSelectionBookAppointmentBtn;
	
    
    
	//Rule-2: Create a constructor to initilise these elements    
    
	public DoctorDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3: Provide getters to access these variables
	
	public WebElement getBackBtn() {
		return BackBtn;
	}
	
	public WebElement getBookAppointmentBtn() {
		return BookAppointmentBtn;
	}


	public WebElement getDoctorInfoBtn() {
		return DoctorInfoBtn;
	}


	public WebElement getFrstAvailableSlot() {
		return FrstAvailableSlot;
	}


	public WebElement getAfterSlotSelectionBookAppointmentBtn() {
		return AfterSlotSelectionBookAppointmentBtn;
	}
	
	// Business Library
	
	public void BookingAppointment(WebDriver driver) throws Exception   //selectingSlotAnd
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		
		Thread.sleep(2000);
		BookAppointmentBtn.click();
		Thread.sleep(2000);
		wUtil.scrollPageDown(2);
		FrstAvailableSlot.click();
		Thread.sleep(2000);
		wUtil.scrollToParticularWebElement(driver, AfterSlotSelectionBookAppointmentBtn);
		Thread.sleep(2000);
		AfterSlotSelectionBookAppointmentBtn.click();
		Thread.sleep(2000);
	}
	
}
