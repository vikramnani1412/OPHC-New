package doctorObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class ApplicationFormPage {

	//Finding WebElements Using @FindBy Annotations
	
    @FindBy(xpath="//button[.='Choose File']")private WebElement ChooseFileBtn;
    
    @FindBy(xpath="//input[@type='file']")private WebElement InputFile;
    
    @FindBy(xpath="//button[.=' Preview AI Look ']")private WebElement PreviewAILookBtn;
    
    @FindBy(xpath="//i[@class='fa-regular fa-trash-can']")private WebElement ProfilePicDeleteBtn;
    
    @FindBy(xpath="//h6[.='Doctor_profile_jpg']")private WebElement DrProfileNameScrolling;
    
    @FindBy(xpath="//input[@formcontrolname='fullName']")private WebElement FullNameEdt;
    
    @FindBy(xpath="//input[@formcontrolname='stateMedicalCouncilNumber']")private WebElement StateMedicalCouncilRegistrationNoEdt;
    
    @FindBy(xpath="//input[@formcontrolname='nmcNumber']")private WebElement NmcNumberEdt;
    
    @FindBy(xpath="//div[@class='custom-dropdown']/div[.=' Select Experience ']")private WebElement ExperianceDrpDwn;
    
    @FindBy(xpath="//label[.=' Post Graduation Degree ']/following-sibling::div/div[.=' Select PG ']")private WebElement PostGraduationDegreeDrpDwn;
    
    @FindBy(xpath="//div[@class='custom-dropdown']/div[.=' Select Specialization ']")private WebElement SpecializationDrpdwn;
    
    @FindBy(xpath="//label[.=' Super Specialization Degree ']/following-sibling::div/div[.=' Select Super Specialisty Qualification ']")private WebElement SuperSpecializationDegreeDwn;
    
    @FindBy(xpath="//label[.=' Super Specialization ']/following-sibling::div/div[.=' Select Super Specialization ']")private WebElement SuperSpecializationDrpdwn;
    
    @FindBy(xpath="//input[@formcontrolname='qualification']")private WebElement QualificationEdt;
    
    @FindBy(xpath="//label[.=' Languages Spoken ']/following-sibling::div/div[.=' Select Languages ']")private WebElement LanguagesDrpdwn;
    
    @FindBy(xpath="//div[@class='custom-dropdown']/div[.=' Select Year ']")private WebElement YearOfAdmissionDrpdwn;
    
    @FindBy(xpath="//input[@formcontrolname='hospital']")private WebElement CurrentHospitalOrClinicEdt;
    
    @FindBy(xpath="//input[@formcontrolname='expertise']")private WebElement ExpertiseEdt;
    
    @FindBy(xpath="//div[@data-placeholder='Enter about yourself...']")private WebElement AboutYourselfTextarea;
  
    @FindBy(xpath="//h6[.='After (AI Enhanced)']/following-sibling::img")private WebElement AiImage;
  
    @FindBy(xpath="//div[.=' Submit ']")private WebElement SubmitBtn;
    
    @FindBy(xpath="//span[.=' Close ']")private WebElement NegativeCloseBtn;
    
    @FindBy(xpath="//div[.=' NMC Number must be at least 5 characters ']")private WebElement NMCMoreThanFiveCharsError;
    
    @FindBy(xpath="//div[.=' NMC Number is required ']")private WebElement NMCnumberRequiredError;
  
  
	//Rule-3:Create a constructor to initilise these elements    
    
	public ApplicationFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-4:Provide getters to access these variables
	
	public WebElement getChooseFileBtn() {
		return ChooseFileBtn;
	}
	
	public WebElement getInputFile() {
		return InputFile;
	}


	public WebElement getPreviewAILookBtn() {
		return PreviewAILookBtn;
	}

	public WebElement getDrProfileNameScrolling() {
		return DrProfileNameScrolling;
	}
	
	public WebElement getProfilePicDeleteBtn() {
		return ProfilePicDeleteBtn;
	}

	public WebElement getFullNameEdt() {
		return FullNameEdt;
	}

	public WebElement getNmcNumberEdt() {
		return NmcNumberEdt;
	}

	public WebElement getStateMedicalCouncilRegistrationNoEdt() {
		return StateMedicalCouncilRegistrationNoEdt;
	}


	public WebElement getPostGraduationDegreeDrpDwn() {
		return PostGraduationDegreeDrpDwn;
	}


	public WebElement getSuperSpecializationDegreeDwn() {
		return SuperSpecializationDegreeDwn;
	}


	public WebElement getSuperSpecializationDrpdwn() {
		return SuperSpecializationDrpdwn;
	}


	public WebElement getLanguagesDrpdwn() {
		return LanguagesDrpdwn;
	}


	public WebElement getAboutYourselfTextarea() {
		return AboutYourselfTextarea;
	}


	public WebElement getSpecializationDrpdwn() {
		return SpecializationDrpdwn;
	}

	public WebElement getExperianceDrpDwn() {
		return ExperianceDrpDwn;
	}

	public WebElement getNegativeCloseBtn() {
		return NegativeCloseBtn;
	}


	public WebElement getQualificationEdt() {
		return QualificationEdt;
	}


	public WebElement getYearOfAdmissionDrpdwn() {
		return YearOfAdmissionDrpdwn;
	}

	public WebElement getCurrentHospitalOrClinicEdt() {
		return CurrentHospitalOrClinicEdt;
	}


	public WebElement getNMCMoreThanFiveCharsError() {
		return NMCMoreThanFiveCharsError;
	}


	public WebElement getNMCnumberRequiredError() {
		return NMCnumberRequiredError;
	}


	public WebElement getExpertiseEdt() {
		return ExpertiseEdt;
	}


	public WebElement getAiImage() {
		return AiImage;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	
	//Business Library
	
   	public void uploadDoctorDetails(WebDriver driver, String ImagePath) throws Exception
    {
    	WebDriverUtility wUtil = new WebDriverUtility();
    	ExcelFileUtility eUtil = new ExcelFileUtility();
    	JavaUtility jUtil = new JavaUtility();
    	
    	String AboutYourself = eUtil.readDataFromExcel("Doctor", 24, 1);
    	
        driver.findElement(By.xpath("//button[.='Choose File']")).click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(ImagePath);
        
        Thread.sleep(2000);
    	
    	wUtil.clickOnEscapeButton();
		
    	Thread.sleep(2000);
    	
    	wUtil.scrollToParticularWebElement(driver, DrProfileNameScrolling);
    	
    	Thread.sleep(2000);
    	
    	String smcrn = String.valueOf(jUtil.getRandomNum());
    	
    	StateMedicalCouncilRegistrationNoEdt.sendKeys(smcrn);
    	Thread.sleep(2000);
    	
    	String nmcn = String.valueOf(jUtil.getRandomNum());
    	NmcNumberEdt.sendKeys(nmcn);
    	Thread.sleep(2000);
    	
    	ExperianceDrpDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' 3 years ']")).click();
    	Thread.sleep(2000);
    	
    	PostGraduationDegreeDrpDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' MD ']")).click();
    	Thread.sleep(2000);
    	
    	SpecializationDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' Critical Care ']")).click();
    	Thread.sleep(2000);
    	
    	SuperSpecializationDegreeDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' DM ']")).click();
    	Thread.sleep(2000);
    	
    	SuperSpecializationDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' Child & Adolescent Psychiatry ']")).click();
    	Thread.sleep(2000);
    	
    	QualificationEdt.sendKeys("MBBS");
    	Thread.sleep(2000);
    	
    	LanguagesDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' English ']")).click();
    	Thread.sleep(2000);
    	
    	YearOfAdmissionDrpdwn.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//li[.=' 2020 ']")).click();
    	
    	Thread.sleep(2000);
    	CurrentHospitalOrClinicEdt.sendKeys("abcdef");
    	Thread.sleep(2000);
    	
    	ExpertiseEdt.sendKeys("Neurosurgery");
    	Thread.sleep(2000);
    	
    	AboutYourselfTextarea.sendKeys(AboutYourself);
    	
    	wUtil.scrollPageUp(2);
    	wUtil.waitUntilElementVisibleUptoThirtyMin(driver, AiImage);
    	if(AiImage.isDisplayed())
    	{
    		Thread.sleep(2000);
    		wUtil.scrollPageDown(3);
    		Thread.sleep(2000);
    		wUtil.waitUntilElementVisibleUptoThirtyMin(driver, SubmitBtn);
    		SubmitBtn.click();
    		Thread.sleep(2000);
    	}
    	    
    }
   	
   	public void UploadDoctorDetailsNegative(WebDriver driver, String ImagePath, String Name) throws Exception
   	{
   		WebDriverUtility wUtil = new WebDriverUtility();
    	ExcelFileUtility eUtil = new ExcelFileUtility();
    	JavaUtility jUtil = new JavaUtility();
    	
    	String AboutYourself = eUtil.readDataFromExcel("Doctor", 24, 1);
    	
        driver.findElement(By.xpath("//button[.='Choose File']")).click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(ImagePath);
        
        Thread.sleep(2000);
    	
    	wUtil.clickOnEscapeButton();
		
    	Thread.sleep(2000);
    	
    	wUtil.scrollToParticularWebElement(driver, DrProfileNameScrolling);
    	
    	Thread.sleep(2000);
    	
    	String smcrn = String.valueOf(jUtil.getRandomNum());
    	
    	StateMedicalCouncilRegistrationNoEdt.sendKeys(smcrn);
    	Thread.sleep(2000);
    	
    	String nmcn = String.valueOf(jUtil.getRandomNum());
    	NmcNumberEdt.sendKeys(nmcn);
    	Thread.sleep(2000);
    	
    	ExperianceDrpDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' 3 years ']")).click();
    	Thread.sleep(2000);
    	
    	PostGraduationDegreeDrpDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' MD ']")).click();
    	Thread.sleep(2000);
    	
    	SpecializationDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' Critical Care ']")).click();
    	Thread.sleep(2000);
    	
    	SuperSpecializationDegreeDwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' DM ']")).click();
    	Thread.sleep(2000);
    	
    	SuperSpecializationDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' Child & Adolescent Psychiatry ']")).click();
    	Thread.sleep(2000);
    	
    	QualificationEdt.sendKeys("MBBS");
    	Thread.sleep(2000);
    	
    	LanguagesDrpdwn.click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//li[.=' English ']")).click();
    	Thread.sleep(2000);
    	
    	YearOfAdmissionDrpdwn.click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//li[.=' 2020 ']")).click();
    	
    	Thread.sleep(2000);
    	CurrentHospitalOrClinicEdt.sendKeys("abcdef");
    	Thread.sleep(2000);
    	
    	ExpertiseEdt.sendKeys("Neurosurgery");
    	Thread.sleep(2000);
    	
    	wUtil.scrollToParticularWebElement(driver, AboutYourselfTextarea);
		Thread.sleep(2000);
    	AboutYourselfTextarea.sendKeys(AboutYourself);
    	
    	Thread.sleep(2000);
//    	wUtil.scrollPageUp(2);
//    	wUtil.waitUntilElementVisibleUptoThirtyMin(driver, AiImage);
    	wUtil.waitUntilElementVisibleUptoThirtyMin(driver, SubmitBtn);
    	
    	try 
    	{
    		if(SubmitBtn.isDisplayed())
        	{
        		Thread.sleep(2000);
        		System.out.println("Submit button Displayed");
        	}
    		AboutYourselfTextarea.clear();
    		if(SubmitBtn.isDisplayed())
    		{
    			wUtil.takeScreenShot(driver, "Submit Button Disabled without giving ABOUT YOURSELF TEXT");
    		}
    		Thread.sleep(2000);
    		AboutYourselfTextarea.sendKeys(AboutYourself);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
    		Thread.sleep(2000);
		} catch (Exception e) 
    	{
			
		}
    	
    	
    }
    	
}
