package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrLoginPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//a[@href='/dashboard']")private WebElement DashBoardLnk;
    
    @FindBy(xpath="//a[@href='/doctor/d-kyc']")private WebElement KycManagementLnk;
	
	@FindBy(xpath="//a[.=' Specialization Mang. ']")private WebElement SpecializationManagementLnk;
	
	@FindBy(xpath="//a[@href='/doctor/d-cons-mangement']")private WebElement ConsManagementLnk;
	
    @FindBy(xpath="//input[@id='emailOrPhone']")private WebElement EmailOrPhoneEdt;
    
    @FindBy(xpath="//button[.=' Login ']")private WebElement LoginBtn;
    
    @FindBy(xpath="//a[.=' Register ']")private WebElement RegisterLnk;
    
    @FindBy(xpath="//p[.=' Logout ']")private WebElement LogoutLnk;
    
    
	//Rule-3:Create a constructor to initilise these elements
    
	public DrLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-4:Provide getters to access these variables
	
	public WebElement getEmailOrPhoneEdt() {
		return EmailOrPhoneEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getRegisterLnk() {
		return RegisterLnk;
	}

	public WebElement getDashBoardLnk() {
		return DashBoardLnk;
	}

	public WebElement getKycManagementLnk() {
		return KycManagementLnk;
	}

	public WebElement getSpecializationManagementLnk() {
		return SpecializationManagementLnk;
	}

	public WebElement getConsManagementLnk() {
		return ConsManagementLnk;
	}
    
	
}
