package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmedPage {

    //Rule-1: Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//div[@class='booking-id-badge']")private WebElement BookingId;
    
    @FindBy(xpath="//button[.=' Cancel Appointment ']")private WebElement CancelAppointmentBth;
    
    @FindBy(xpath="//button[.=' Need Help? ']")private WebElement NeedHelpBtn;
    
    @FindBy(xpath="//button[.='Continue']")private WebElement ContinueBtn;
    
  
	//Rule-2: Create a constructor to initilise these elements    
    
	public AppointmentConfirmedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3: Provide getters to access these variables
	
	public WebElement getBookingId() {
		return BookingId;
	}


	public WebElement getCancelAppointmentBth() {
		return CancelAppointmentBth;
	}


	public WebElement getNeedHelpBtn() {
		return NeedHelpBtn;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

	// Business Library
	
	public void getBookingIDandClickContinue() throws Exception
	{
		Thread.sleep(2000);
		String bookingId = BookingId.getText();
		Thread.sleep(2000);
		ContinueBtn.click();
	}
	
	public void DirectlyClickOnContinueBtn() throws Exception
	{
		Thread.sleep(2000);
		ContinueBtn.click();
	}

	
}
