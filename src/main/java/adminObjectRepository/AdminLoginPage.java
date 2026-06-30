package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.PropertyFileUtility;

public class AdminLoginPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@name='userName']")private WebElement UserNameEdt;
    
    @FindBy(xpath="//input[@name='password']")private WebElement PasswordEdt;
    
    @FindBy(xpath="//span[.=' Login ']")private WebElement LoginBtn;
    
  
	//Rule-3:Create a constructor to initilise these elements
    
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    

	//Rule-4:Provide getters to access these variables

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}


	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}


	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Business Libraries
	
	public void loginToAdmin(String USERNAME, String PASSWORD) throws Throwable
	{		
		UserNameEdt.sendKeys(USERNAME);
		Thread.sleep(2000);
		PasswordEdt.sendKeys(PASSWORD);
		Thread.sleep(2000);
		LoginBtn.click();
		Thread.sleep(2000);
	}
	
	
}
