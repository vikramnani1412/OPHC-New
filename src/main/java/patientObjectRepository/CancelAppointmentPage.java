package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelAppointmentPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//textarea[@placeholder='Enter cancellation reason']")private WebElement ReasonTxtArea;
    
    @FindBy(xpath="//button[@class='btn-dismiss']")private WebElement CancelBtn;
    
    @FindBy(xpath="//button[.='Confirm Cancel']")private WebElement ConfirmCancelBtn;
    
	//Rule-2 : Create a constructor to initilise these elements  
    
    
	public CancelAppointmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3 : Provide getters to access these variables
	
	public WebElement getReasonTxtArea() {
		return ReasonTxtArea;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getConfirmCancelBtn() {
		return ConfirmCancelBtn;
	}
	
	
}
