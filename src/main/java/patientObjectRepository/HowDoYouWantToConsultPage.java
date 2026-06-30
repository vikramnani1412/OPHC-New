package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HowDoYouWantToConsultPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
    
	@FindBy(xpath="//img[@alt='close']")private WebElement CloseBtn;
	
    @FindBy(xpath="//div[@class='radio active']")private WebElement VideoCallRadioBtn;
    
    @FindBy(xpath="//input[@id='termsCheckbox']")private WebElement TermsChkbox;
    
    @FindBy(xpath="//input[@id='reportCheckbox']")private WebElement GuidelinesChkbox;
    
    @FindBy(xpath="//input[@id='recordingCheckbox']")private WebElement RefundCancellationChkbox;
    
    @FindBy(xpath="//button[.=' Continue ']")private WebElement ContinueBtn;
  
  
	//Rule-2 : Create a constructor to initilise these elements    
    
	public HowDoYouWantToConsultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3 : Provide getters to access these variables
	
	public WebElement getVideoCallRadioBtn() {
		return VideoCallRadioBtn;
	}


	public WebElement getCloseBtn() {
		return CloseBtn;
	}


	public WebElement getTermsChkbox() {
		return TermsChkbox;
	}


	public WebElement getGuidelinesChkbox() {
		return GuidelinesChkbox;
	}


	public WebElement getRefundCancellationChkbox() {
		return RefundCancellationChkbox;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	
	// Business Library
	
	public void CompleteHowDoYouWantToConsultDetailsAndClickOnContinueBtn() throws Exception
	{
		Thread.sleep(2000);
		TermsChkbox.click();
		Thread.sleep(2000);
		GuidelinesChkbox.click();
		Thread.sleep(2000);
		RefundCancellationChkbox.click();
		Thread.sleep(2000);
		ContinueBtn.click();
		Thread.sleep(2000);
	}
}
