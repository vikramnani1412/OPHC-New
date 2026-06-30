package doctorObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class ProfileUnderVerificationPage {

	//Finding WebElements Using @FindBy Annotations

	@FindBy(xpath="//div[@class='verification-box']")private WebElement ConformationMsg;
	
    @FindBy(xpath="//a[.='Upload Documents']")private WebElement UploadDocumentsLnk;
    
    @FindBy(xpath="//div[.='Logout']")private WebElement LogoutBtn;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public ProfileUnderVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-3:Provide getters to access these variables
	
	public WebElement getUploadDocumentsLnk() {
		return UploadDocumentsLnk;
	}
	

	public WebElement getConformationMsg() {
		return ConformationMsg;
	}


	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	//Business Library
	
	public void clickOnLogoutBtn(WebDriver driver) throws Exception
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		Thread.sleep(2000);
		wUtil.waitForElementToBeVisible(driver, ConformationMsg);
		if (ConformationMsg.isDisplayed())
		{
			Thread.sleep(1000);
			LogoutBtn.click();
		}
		
	}
	
}
