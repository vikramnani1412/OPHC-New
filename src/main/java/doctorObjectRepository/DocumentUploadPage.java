package doctorObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class DocumentUploadPage {

	//Finding WebElements Using @FindBy Annotations//span[.='Medical Degree Certificate']

    @FindBy(xpath="(//img[@alt='upload'])[1]")private WebElement UploadMedicalDegreeCertificateIcon;
    //span[.='Medical Degree  Certificate']/../preceding-sibling::input[@type='file']
    @FindBy(xpath="(//input[@type='file'])[2]")private WebElement UploadNMCOrStateMedicalCouncilCertificateIcon;
	
	@FindBy(xpath="(//input[@type='file'])[3]")private WebElement UploadAadhaarCardIcon;
	
    @FindBy(xpath="(//input[@type='file'])[4]")private WebElement UploadPanCardIcon;
	
    @FindBy(xpath="(//input[@type='file'])[5]")private WebElement UploadExperianceCertificateIcon;
    
    @FindBy(xpath="(//input[@type='file'])[6]")private WebElement UploadClinicOrHospitalAffiliationProofIcon;
    
    @FindBy(xpath="//label[@for='terms']/preceding-sibling::input[@type='checkbox']")private WebElement TermsChckBox;
    
    @FindBy(xpath="//p[contains(.,' I comply with')]/preceding-sibling::input[@type='checkbox']")private WebElement GuidelinesChckbox;
    
    @FindBy(xpath="//p[contains(.,' I declare my medical')]/preceding-sibling::input[@type='checkbox']")private WebElement MedicalRegistrationChckbox;
    
    @FindBy(xpath="//p[contains(.,' I consent')]/preceding-sibling::input[@type='checkbox']")private WebElement IconsentChckbox;
    
    @FindBy(xpath="//span[.=' ✗ Upload failed ']")private WebElement UploadFailedError;
    
    @FindBy(xpath="//span[.='Submit Documents']")private WebElement SubmitDocumentsBtn;
    
    @FindBy(xpath="//img[@class='logout']")private WebElement LogoutLnk;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public DocumentUploadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	//Rule-3:Provide getters to access these variables
	
	public WebElement getUploadMedicalDegreeCertificateIcon() {
		return UploadMedicalDegreeCertificateIcon;
	}




	public WebElement getUploadNMCOrStateMedicalCouncilCertificateIcon() {
		return UploadNMCOrStateMedicalCouncilCertificateIcon;
	}




	public WebElement getUploadAadhaarCardIcon() {
		return UploadAadhaarCardIcon;
	}




	public WebElement getUploadPanCardIcon() {
		return UploadPanCardIcon;
	}




	public WebElement getUploadExperianceCertificateIcon() {
		return UploadExperianceCertificateIcon;
	}




	public WebElement getUploadClinicOrHospitalAffiliationProofIcon() {
		return UploadClinicOrHospitalAffiliationProofIcon;
	}




	public WebElement getTermsChckBox() {
		return TermsChckBox;
	}



	public WebElement getGuidelinesChckbox() {
		return GuidelinesChckbox;
	}




	public WebElement getMedicalRegistrationChckbox() {
		return MedicalRegistrationChckbox;
	}




	public WebElement getIconsentChckbox() {
		return IconsentChckbox;
	}


    

	public WebElement getUploadFailedError() {
		return UploadFailedError;
	}


	public WebElement getSubmitDocumentsBtn() {
		return SubmitDocumentsBtn;
	}




	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}
	
	//Business Library
	
	public void documentsUploading(WebDriver driver, String MedicalCertificate, String NMCcertificate, String Aadhar, String Pan, String Experiance, String AffiliationProof) throws Exception
	{
		Thread.sleep(2000);
	    WebDriverUtility wUtil = new WebDriverUtility();
//	    wUtil.scrollPageUp(2);
//	    Thread.sleep(2000);
//	    UploadMedicalDegreeCertificateIcon.click();
//	    Thread.sleep(2000);
//	    UploadMedicalDegreeCertificateIcon.sendKeys(MedicalCertificate);
//	    Thread.sleep(2000);
//	    UploadNMCOrStateMedicalCouncilCertificateIcon.sendKeys(NMCcertificate);
//	    Thread.sleep(2000);
//	    UploadAadhaarCardIcon.sendKeys(Aadhar);
//	    Thread.sleep(2000);
//	    UploadPanCardIcon.sendKeys(Pan);
//	    Thread.sleep(2000);
//	    UploadExperianceCertificateIcon.sendKeys(Experiance);
//	    Thread.sleep(2000);
//	    UploadClinicOrHospitalAffiliationProofIcon.sendKeys(AffiliationProof);
	    Thread.sleep(2000);
	    TermsChckBox.click();
	    Thread.sleep(2000);
	    GuidelinesChckbox.click();
	    Thread.sleep(2000);
	    wUtil.scrollPageDown(1);
	    MedicalRegistrationChckbox.click();
	    Thread.sleep(2000);
	    IconsentChckbox.click();
	    Thread.sleep(2000);
	    try {
	    	if (UploadFailedError.isDisplayed()) 
		    {
				driver.findElement(By.xpath("//span[.=' ✗ Upload failed ']/preceding-sibling::input[@type='file']")).sendKeys("C:\\Users\\Innovatiview\\Pictures\\A\\Aadhaar.png");
			}
		} catch (Exception e) {
			Thread.sleep(10);
		}
	    
	    wUtil.waitForElementToBeVisible(driver, SubmitDocumentsBtn);
	    
	    Thread.sleep(2000);
	    
	    SubmitDocumentsBtn.click();
	    Thread.sleep(2000);
	    
	}
	
	
}
