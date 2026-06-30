package patientObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindDoctorsPage {

    // Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//input[@placeholder='Search doctors']")private WebElement SearchEdt;
    
    @FindBy(xpath="//img[@alt='filter']")private WebElement FilterIcon;
    
    @FindBy(xpath="//div[@class='header-actions']")private WebElement ProfileIcon;
    
    @FindBy(xpath="//button[.='New']")private WebElement NewBtn;
    
    @FindBy(xpath="//button[.='Follow up']")private WebElement FollowUpBtn;
    
    @FindBy(xpath="(//h6[contains(.,'Dr')])[1]")private WebElement FirstDoctor;
    
    @FindBy(xpath="//h6[contains(.,'Vicky')]/../../following-sibling::div//button[.='Book Now']")private WebElement BookNowBtnBasedOnDoctorName;
    
    @FindBy(xpath="(//h6[contains(.,'Dr')])[1]/../../following-sibling::div//button[.='Book Now']")private WebElement FirstDoctorBookNowBtn;
  
    @FindBy(xpath="(//button[.='Book Now'])[1]")private WebElement BookNowBtnBasedOnIndex;
  
        
	//Rule-3:Create a constructor to initilise these elements    
    
	public FindDoctorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-4:Provide getters to access these variables
	
	
	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getFilterIcon() {
		return FilterIcon;
	}

	public WebElement getProfileIcon() {
		return ProfileIcon;
	}

	public WebElement getNewBtn() {
		return NewBtn;
	}

	public WebElement getFollowUpBtn() {
		return FollowUpBtn;
	}

	public WebElement getBookNowBtnBasedOnIndex() {
		return BookNowBtnBasedOnIndex;
	}

	public WebElement getFirstDoctor() {
		return FirstDoctor;
	}

	public WebElement getFirstDoctorBookNowBtn() {
		return FirstDoctorBookNowBtn;
	}

	public WebElement getBookNowBtnBasedOnDoctorName() {
		return BookNowBtnBasedOnDoctorName;
	}

	
	//Business Library
	
	public void selectingDoctor() throws Exception
	{
		Thread.sleep(2000);
		String DoctorName = BookNowBtnBasedOnDoctorName.getText();
		System.out.println("Patient searching for Doctor : "+DoctorName);
		Thread.sleep(2000);
		BookNowBtnBasedOnDoctorName.click();
	}
	
}
