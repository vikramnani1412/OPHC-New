package doctorObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//button[.='Cancel']")private WebElement CancelBtn;
    
    @FindBy(xpath="//button[.='Yes, Logout']")private WebElement LogoutBtn;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public LogoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule-3:Provide getters to access these variables

	public void clickOnCancelBtn() throws Exception
	{
		Thread.sleep(2000);
		CancelBtn.click();
	}
	
	public void clickOnYesLogoutBtn() throws Exception
	{
		Thread.sleep(2000);
		LogoutBtn.click();
	}
}
