package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPrecriptionPage {

    //Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//input[@type='checkbox']/following-sibling::label")private WebElement PrecreptionChckbox;
    
    @FindBy(xpath="//button[.=' Upload Report ']")private WebElement UploadBtn;
    
    @FindBy(xpath="//button[.=' Submit ']")private WebElement SubmitBtn;
    
    @FindBy(xpath="//button[@class='close-icon']")private WebElement PageCloseBtn;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public SelectPrecriptionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    
	//Rule-3:Provide getters to access these variables
	

	public WebElement getPrecreptionChckbox() {
		return PrecreptionChckbox;
	}


	public WebElement getUploadBtn() {
		return UploadBtn;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}


	public WebElement getPageCloseBtn() {
		return PageCloseBtn;
	}
    
	
}
