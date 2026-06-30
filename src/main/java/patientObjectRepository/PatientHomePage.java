package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientHomePage {

    //Rule-1: Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='Home']")private WebElement HomeLnk;
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='About']")private WebElement AboutLnk;
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='Find Doctors']")private WebElement FindDoctorsLnk;
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='Services']")private WebElement ServicesLnk;
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='Health Hub']")private WebElement HealthHubLnk;
    
    @FindBy(xpath="//img[@alt='One Power']/../../following-sibling::nav//a[.='Reports']")private WebElement ReportsLnk;
    
    @FindBy(xpath="//button[.='Login']")private WebElement LoginBtn;
    
    @FindBy(xpath="//button[.=' Book Appointment ']")private WebElement BookAppointmentBtn;
  
    
  
	//Rule-2: Create a constructor to initilise these elements    
    
	public PatientHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3: Provide getters to access these variables
	
	public WebElement getHomeLnk() {
		return HomeLnk;
	}



	public WebElement getAboutLnk() {
		return AboutLnk;
	}



	public WebElement getFindDoctorsLnk() {
		return FindDoctorsLnk;
	}



	public WebElement getServicesLnk() {
		return ServicesLnk;
	}



	public WebElement getHealthHubLnk() {
		return HealthHubLnk;
	}



	public WebElement getReportsLnk() {
		return ReportsLnk;
	}



	public WebElement getLoginBtn() {
		return LoginBtn;
	}



	public WebElement getBookAppointmentBtn() {
		return BookAppointmentBtn;
	}
     
	// Business Library
	
	public void clickOnLoginButtom() throws Exception
	{
		Thread.sleep(2000);
		LoginBtn.click();
	}
	
}
