package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrYourProfileIsUnderVerificationPage {
	
  //Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//p[.='Your Profile is Under Verification']")private WebElement ProfileVerificationMsg;
    
    @FindBy(xpath="//a[.='Upload Documents']")private WebElement UploadDoccumentsLnk;
    
    @FindBy(xpath="//button[.='Logout']")private WebElement LogoutBtn;
  
	//Rule-3:Create a constructor to initilise these elements
    
	public DrYourProfileIsUnderVerificationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    
	//Rule-4:Provide getters to access these variables
	
	public WebElement getProfileVerificationMsg() {
		return ProfileVerificationMsg;
	}

	public WebElement getUploadDoccumentsLnk() {
		return UploadDoccumentsLnk;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
}
