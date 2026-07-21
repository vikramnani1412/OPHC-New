package patientObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelFileUtility;
import genericUtilities.WebDriverUtility;

public class UploadMedicalReportsAfterAppointmentConfirmPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//button[@class='back-btn']")private WebElement BackBtn;
    
    @FindBy(xpath="//div[@class='upload-zone']/input[@type='file']")private WebElement UploadZone;
    
    @FindBy(xpath="//button[@class='submit-btn']")private WebElement SubmitBtn;
    
  
	//Rule-2 : Create a constructor to initilise these elements    
    
	public UploadMedicalReportsAfterAppointmentConfirmPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3 : Provide getters to access these variables


	public WebElement getBackBtn() {
		return BackBtn;
	}


	public WebElement getUploadZone() {
		return UploadZone;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	// Business Library
	
	public void uploadingMedicalReports(WebDriver driver) throws Exception 
	{
//		WebDriverUtility wUtil = new WebDriverUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String medicalReportImage = eUtil.generateSampleMedicalReport("C:\\TestData\\", "MedicalReport", "Doctor", 6, 4);
		
		Thread.sleep(2000);
		UploadZone.sendKeys(medicalReportImage);
		Thread.sleep(2000);
		SubmitBtn.click();
		Thread.sleep(2000);
		
		
	}
}
