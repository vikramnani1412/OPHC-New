package doctorObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@id='emailOrPhone']")private WebElement EmailOrPhoneEdt;
    
    @FindBy(xpath="//button[.=' Login ']")private WebElement LoginBtn;
    
    @FindBy(xpath="//a[.=' Register ']")private WebElement RegisterLnk;
  
    
	//Rule-2:Create a constructor to initilise these elements
    
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-3:Provide getters to access these variables
	
	public WebElement getEmailOrPhoneEdt() {
		return EmailOrPhoneEdt;
	}


	public WebElement getLoginBtn() {
		return LoginBtn;
	}


	public WebElement getRegisterLnk() {
		return RegisterLnk;
	}
    
	// Business Library
	
	public void loginToDoctor(String PhoneNum) throws Exception
	{
		Thread.sleep(2000);
		EmailOrPhoneEdt.sendKeys(PhoneNum);
		Thread.sleep(2000);
		LoginBtn.click();
		Thread.sleep(2000);
	}
	
}
