package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDetailsAfterAppointmentConformPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//input[@placeholder='Full Name']")private WebElement FullNameEdt;
    
    @FindBy(xpath="(//span[@class='checkmark'])[1]")private WebElement MaleChkbox;
    
    @FindBy(xpath="(//span[@class='checkmark'])[2]")private WebElement FemaleChkbox;
    
    @FindBy(xpath="(//span[@class='checkmark'])[3]")private WebElement OthersChkbox;
    
    @FindBy(xpath="//input[@type='date']")private WebElement DateEdt;
    
    @FindBy(xpath="//button[.='Cancel']")private WebElement CancelBtn;
    
    @FindBy(xpath="//button[.=' Continue ']")private WebElement ContinueBtn;
  
  
	//Rule-2 : Create a constructor to initilise these elements    
    
	public PatientDetailsAfterAppointmentConformPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3 : Provide getters to access these variables
	
	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}


	public WebElement getMaleChkbox() {
		return MaleChkbox;
	}


	public WebElement getFemaleChkbox() {
		return FemaleChkbox;
	}


	public WebElement getOthersChkbox() {
		return OthersChkbox;
	}


	public WebElement getDateEdt() {
		return DateEdt;
	}


	public WebElement getCancelBtn() {
		return CancelBtn;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}

	// Business Library
	
	public void givingPatientDetails(String Fullname, String Date) throws Exception
	{
		Thread.sleep(1000);
		FullNameEdt.sendKeys(Fullname);
		Thread.sleep(2000);
		MaleChkbox.click();
		Thread.sleep(2000);
		DateEdt.sendKeys(Date);
		Thread.sleep(2000);
		ContinueBtn.click();
	}
	
}
