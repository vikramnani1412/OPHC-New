package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecializationManagementPage {

	//Finding WebElements Using @FindBy Annotations

//    @FindBy(xpath="//a[@href='/dashboard']")private WebElement DashboardLnk;
//    
//    @FindBy(xpath="//a[.=' Dr. Registration. ']")private WebElement RegistrationLnk;
//    
//    @FindBy(xpath="//a[@href='/doctor/d-kyc']")private WebElement KycManagementLnk;
//    
//    @FindBy(xpath="//a[@href='/doctor/d-cons-mangement']")private WebElement ConsManagementLnk;
    
    @FindBy(xpath="//span[.='State of Council ']")private WebElement StateOfCouncilIcon;
    
    @FindBy(xpath="//span[.='Qualification']")private WebElement QualificationIcon;
    
    @FindBy(xpath="//span[.='Specialization']")private WebElement SpecializationIcon;
    
    @FindBy(xpath="(//td[contains(.,'')])[1]/following-sibling::td[.=' Active ']")private WebElement FirstSpecializationActiveBtn;
    	
    @FindBy(xpath="//p[.=' Logout ']")private WebElement LogoutLnk;
    
	//Rule-3:Create a constructor to initilise these elements
    
	public SpecializationManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	
	//Rule-4:Provide getters to access these variables

	
	public WebElement getStateOfCouncilIcon() {
		return StateOfCouncilIcon;
	}


	public WebElement getQualificationIcon() {
		return QualificationIcon;
	}


	public WebElement getSpecializationIcon() {
		return SpecializationIcon;
	}
	

	public WebElement getFirstSpecializationActiveBtn() {
		return FirstSpecializationActiveBtn;
	}
	
	
	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}
	
	//Business Library
	
	
	public void clickOnFirstSpecializationActiveBtn()
	{
		FirstSpecializationActiveBtn.click();
	}	
	
	
}
