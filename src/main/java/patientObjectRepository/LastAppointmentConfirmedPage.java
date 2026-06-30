package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastAppointmentConfirmedPage {

    //Rule-1: Finding WebElements Using @FindBy Annotations
    
	@FindBy(xpath="//div[@class='success-modal-container']")private WebElement AppointmentConfirmedTotalPage;
	
    @FindBy(xpath="//div[@class='booking-id-badge']")private WebElement BookingId;
    
    @FindBy(xpath="//button[.=' Cancel Appointment ']")private WebElement CancelAppointmentBtn;
    
    @FindBy(xpath="//button[text()='Add Notes ']")private WebElement AddNotesBtn;
    
    @FindBy(xpath="//button[text()=' Reschedule Appointment ']")private WebElement RescheduleAppointmentBtn;
    
    @FindBy(xpath="//button[text()='Upload Document ']")private WebElement UploadDocumentBtn;
    
    @FindBy(xpath="//button[text()=' Need Help? Contact Support ']")private WebElement NeedHelpContactSupportBtn;
    
    @FindBy(xpath="//button[.='Continue']")private WebElement ContinueBtn;
    
  
	//Rule-2: Create a constructor to initilise these elements    
    
	public LastAppointmentConfirmedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3: Provide getters to access these variables


	public WebElement getAppointmentConfirmedTotalPage() {
		return AppointmentConfirmedTotalPage;
	}


	public WebElement getBookingId() {
		return BookingId;
	}


	public WebElement getCancelAppointmentBtn() {
		return CancelAppointmentBtn;
	}


	public WebElement getAddNotesBtn() {
		return AddNotesBtn;
	}


	public WebElement getRescheduleAppointmentBtn() {
		return RescheduleAppointmentBtn;
	}


	public WebElement getUploadDocumentBtn() {
		return UploadDocumentBtn;
	}


	public WebElement getNeedHelpContactSupportBtn() {
		return NeedHelpContactSupportBtn;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

}
