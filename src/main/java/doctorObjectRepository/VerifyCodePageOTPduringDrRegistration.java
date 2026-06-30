package doctorObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyCodePageOTPduringDrRegistration {

	//Finding WebElements Using @FindBy Annotations
	
    @FindBy(xpath="(//input[@inputmode='numeric'])[1]")private WebElement OTPFrstBox;
    
    @FindBy(xpath="//a[.=' Resend ']")private WebElement ResendLnk;
    
    @FindBy(xpath="//button[.=' Verify ']")private WebElement VerifyBtn;
    
	//Rule-3:Create a constructor to initilise these elements
    
	public VerifyCodePageOTPduringDrRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-4:Provide getters to access these variables
	
	public WebElement getOTPFrstBox() {
		return OTPFrstBox;
	}

	public WebElement getResendLnk() {
		return ResendLnk;
	}

	public WebElement getVerifyBtn() {
		return VerifyBtn;
	}


	
	
}
