package adminObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import genericUtilities.DataStore;
import genericUtilities.WebDriverUtility;

public class DrKycManagementPage {

	//Finding WebElements Using @FindBy Annotations

	@FindBy(xpath="//a[@href='/dashboard']")private WebElement DashBoardLnk;
	
	@FindBy(xpath="//a[.=' Dr. Registration. ']")private WebElement RegistrationLnk;
	
	@FindBy(xpath="//a[.=' Specialization Mang. ']")private WebElement SpecializationManagementLnk;
	
	@FindBy(xpath="//a[@href='/doctor/d-cons-mangement']")private WebElement ConsManagementLnk;
	
	@FindBy(xpath="//span[.='Total Requests']")private WebElement TotalRequestsIcon;
	
	@FindBy(xpath="//span[.='In Review']")private WebElement InReviewIcon;
	
	@FindBy(xpath="//span[.='Pending']")private WebElement PendingIcon;
	
	@FindBy(xpath="//span[.='Approval']")private WebElement ApprovalIcon;
	
	@FindBy(xpath="//span[.='Reject']")private WebElement RejectIcon;
	
    @FindBy(xpath="//td[contains(.,'')]/following-sibling::td[contains(.,'6666666666')]/following-sibling::td[contains(.,'')]/following-sibling::td[contains(.,'')]/following-sibling::td[.='Preview']")private WebElement DoctorIcon;
    
    @FindBy(xpath="(//td[.='1']/following-sibling::td[contains(.,'')])[1]")private WebElement FrstDoctorName;    
    
    @FindBy(xpath="//td[.='1']/following-sibling::td/button[.='Preview']")private WebElement FrstDoctorPreviewBtn;
    //td[.=' Dr. Jayant ']/following-sibling::td/button[.='Preview']
    
    @FindBy(xpath="//a[.='Prev']")private WebElement PreviousPageLnk;
    
    @FindBy(xpath="//a[.='Next']")private WebElement NextPageLnk;
    
    @FindBy(xpath="//p[.=' Logout ']")private WebElement LogoutLnk;
  
	//Rule-3:Create a constructor to initilise these elements
    
	public DrKycManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//Rule-4:Provide getters to access these variables

	public WebElement getDashBoardLnk() {
		return DashBoardLnk;
	}

    
	public WebElement getRegistrationLnk() {
		return RegistrationLnk;
	}


	public WebElement getSpecializationManagementLnk() {
		return SpecializationManagementLnk;
	}


	public WebElement getConsManagementLnk() {
		return ConsManagementLnk;
	}


	public WebElement getTotalRequestsIcon() {
		return TotalRequestsIcon;
	}


	public WebElement getInReviewIcon() {
		return InReviewIcon;
	}


	public WebElement getPendingIcon() {
		return PendingIcon;
	}


	public WebElement getApprovalIcon() {
		return ApprovalIcon;
	}


	public WebElement getRejectIcon() {
		return RejectIcon;
	}


	public WebElement getDoctorIcon() {
		return DoctorIcon;
	}

	public WebElement getFrstDoctorName() {
		return FrstDoctorName;
	}

	public WebElement getFrstDoctorPreviewBtn() {
		return FrstDoctorPreviewBtn;
	}

	public WebElement getPreviousPageLnk() {
		return PreviousPageLnk;
	}


	public WebElement getNextPageLnk() {
		return NextPageLnk;
	}


	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}
	
	//Business Library

	public void ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(WebDriver driver, String NewlyRegisteredDoctor, int DoctorNumber) throws Exception
	{
		String firstDoctorName = FrstDoctorName.getText();
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//td[.='"+DoctorNumber+"']/following-sibling::td/button[.='Preview']")).click();
	}
	
	public void clickOnFrstDoctorPreviewButton(WebDriver driver)
	{
		FrstDoctorPreviewBtn.click();
//		driver.findElement(By.xpath("(//button[.='Preview'])[1]")).click();
	}
	
	public void clickOnParticularDoctorBasedOnMobileNumPreviewBUTTON(WebDriver driver, String MobileNo)
	{
		driver.findElement(By.xpath("//td[contains(.,'"+MobileNo+"')]/following-sibling::td[.='Preview']"));
	}


	
}
