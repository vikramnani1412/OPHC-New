package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNotesAfterAppointmentConformationPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//button[@class='notes-popup-close']")private WebElement CloseBtn;
    
    @FindBy(xpath="//textarea[@placeholder='Type your notes here...']")private WebElement TypeNotesEdt;
    
    @FindBy(xpath="//button[.='Cancel']")private WebElement CancelBtn;
    
    @FindBy(xpath="//button[.=' Save Notes ']")private WebElement SaveNotesBtn;
  
	//Rule-2 : Create a constructor to initilise these elements    
    
	public AddNotesAfterAppointmentConformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Rule-3 : Provide getters to access these variables
	
	public WebElement getCloseBtn() {
		return CloseBtn;
	}

	public WebElement getTypeNotesEdt() {
		return TypeNotesEdt;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public WebElement getSaveNotesBtn() {
		return SaveNotesBtn;
	}
	
	// Business Library
	
	public void addNote(String Msg) throws Exception
	{
		Thread.sleep(2000);
		TypeNotesEdt.sendKeys("Msg");
		Thread.sleep(2000);
		SaveNotesBtn.click();
	}
	

	
}
