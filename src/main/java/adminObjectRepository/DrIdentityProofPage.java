package adminObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import genericUtilities.ExcelFileUtility;

public class DrIdentityProofPage {

	//Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//div[.='Aadhar card']/preceding-sibling::img[@alt='Aadhaar document']")private WebElement AadhaarImg;
  
    @FindBy(xpath="//div[.='Pan card']/preceding-sibling::img[@alt='Pan document']")private WebElement PanImg;
    
    @FindBy(xpath="//div[.='experience Certificate']/preceding-sibling::img[@alt='Pan document']")private WebElement ExperianceCertificateImg;
    
    @FindBy(xpath="//div[.='hospital Proof']/preceding-sibling::img[@alt='Pan']")private WebElement HospitalProofImg;
    
    @FindBy(xpath="//div[.='medical Certificate']/preceding-sibling::img[@alt='Pan']")private WebElement MedicalCertificateImg;
    
    @FindBy(xpath="//div[.='nmc Certificate']/preceding-sibling::img[@alt='Pan']")private WebElement NmcCertificateImg;
    
//    @FindBy(xpath="//img[@src='blob:https://stg-admin-ui.ophc.in/8ed480b1-3405-4106-a2be-1a72d550d955']")private WebElement MedicalCertificate;
    
    @FindBy(xpath="//div[.='Aadhar card']/following-sibling::div[.='Open']")private WebElement OpenAadhaarLnk;
    
    @FindBy(xpath="//div[.='Pan card']/following-sibling::div[.='Open']")private WebElement OpenPanLnk;
	
	@FindBy(xpath="//div[.='experience Certificate']/following-sibling::div[.='Open']")private WebElement OpenExperianceCertificateLnk;
	
	@FindBy(xpath="//div[.='hospital Proof']/following-sibling::div[.='Open']")private WebElement OpenHospitalProofLnk;
	
    @FindBy(xpath="//div[.='medical Certificate']/following-sibling::div[.='Open']")private WebElement OpenMedicalCertificateLnk;
    
    @FindBy(xpath="//div[.='nmc Certificate']/following-sibling::div[.='Open']")private WebElement OpenNmcCertificateLnk;
    
    @FindBy(xpath="//button[.='Approve with Rating']")private WebElement ApproveWithRatingBtn;
    
    @FindBy(xpath="//button[.='Approve KYC']")private WebElement ApproveKycBtn;
    
    @FindBy(xpath="//button[.='Reject with Reason']")private WebElement RejectWithReasonBtn;
    
    @FindBy(xpath="//textarea[@id='rejectionReason']")private WebElement ReasonForRejectionEdt;
    
    @FindBy(xpath="//button[.='Reject KYC']")private WebElement RejectKycBtn;
    
    @FindBy(xpath="//img[@alt='Close']")private WebElement ClosePageBtn;
                    
    @FindBy(xpath="(//span[.=' ★ '])[1]")private WebElement RatingStars;
    
    @FindBy(xpath="//input[@name='fee']")private WebElement ConsultationFeeEdt;
    
    @FindBy(xpath="//div[.=' Successfully processed doctor status as approved']")private WebElement SuccessfullyProcessedMsg;
    
    @FindBy(xpath="//span[.=' Close ']")private WebElement ConformationCloseBtn;
    
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public DrIdentityProofPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-:Provide getters to access these variables

	public WebElement getAadhaarImg() {
		return AadhaarImg;
	}

	public WebElement getPanImg() {
		return PanImg;
	}

	public WebElement getExperianceCertificateImg() {
		return ExperianceCertificateImg;
	}

	public WebElement getHospitalProofImg() {
		return HospitalProofImg;
	}

	public WebElement getMedicalCertificateImg() {
		return MedicalCertificateImg;
	}

	public WebElement getNmcCertificateImg() {
		return NmcCertificateImg;
	}

	public WebElement getOpenAadhaarLnk() {
		return OpenAadhaarLnk;
	}
	
	public WebElement getOpenPanLnk() {
		return OpenPanLnk;
	}

	public WebElement getOpenExperianceCertificateLnk() {
		return OpenExperianceCertificateLnk;
	}

	public WebElement getOpenHospitalProofLnk() {
		return OpenHospitalProofLnk;
	}

	public WebElement getOpenMedicalCertificateLnk() {
		return OpenMedicalCertificateLnk;
	}

	public WebElement getOpenNmcCertificateLnk() {
		return OpenNmcCertificateLnk;
	}

	public WebElement getApproveWithRatingBtn() {
		return ApproveWithRatingBtn;
	}
	
	public WebElement getApproveKycBtn() {
		return ApproveKycBtn;
	}

	public WebElement getRejectWithReasonBtn() {
		return RejectWithReasonBtn;
	}

	public WebElement getReasonForRejectionEdt() {
		return ReasonForRejectionEdt;
	}

	public WebElement getRejectKycBtn() {
		return RejectKycBtn;
	}

	public WebElement getClosePageBtn() {
		return ClosePageBtn;
	}

	public WebElement getRatingStars() {
		return RatingStars;
	}

	public WebElement getConsultationFeeEdt() {
		return ConsultationFeeEdt;
	}
	
	public WebElement getConformationCloseBtn() {
		return ConformationCloseBtn;
	}

	public WebElement getSuccessfullyProcessedMsg() {
		return SuccessfullyProcessedMsg;
	}
	
	
	// Business Library
	
	public void checkingEveryDocumentDoctorUploadedAndGivingFeeAndRating(WebDriver driver, String NoOfStarsUpToFive, String ConsultancyFee) throws Exception
	{	
		//Soft Assert
		
		Thread.sleep(2000);
		SoftAssert soft = new SoftAssert();
	    
		soft.assertTrue(AadhaarImg.isDisplayed(), "Aadhaar image is not displayed");
		soft.assertTrue(PanImg.isDisplayed(), "PAN image is not displayed");
		soft.assertTrue(ExperianceCertificateImg.isDisplayed(), "Experience Certificate image is not displayed");
		soft.assertTrue(HospitalProofImg.isDisplayed(), "Hospital Proof image is not displayed");
		soft.assertTrue(MedicalCertificateImg.isDisplayed(), "Medical Certificate image is not displayed");
		soft.assertTrue(NmcCertificateImg.isDisplayed(), "NMC Certificate image is not displayed");
		soft.assertAll();
		
		if(AadhaarImg.isDisplayed() &&
			    PanImg.isDisplayed() &&
			    ExperianceCertificateImg.isDisplayed() &&
			    HospitalProofImg.isDisplayed() &&
			    MedicalCertificateImg.isDisplayed() &&
			    NmcCertificateImg.isDisplayed())
		{
			ApproveWithRatingBtn.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[.=' ★ '])["+NoOfStarsUpToFive+"]")).click();
			try {
				ConsultationFeeEdt.sendKeys(ConsultancyFee);
			} catch (Exception e) {
				System.out.println("Consultation Fee is Disabled");
			}
			ApproveKycBtn.click();
			Thread.sleep(2000);
			if(ConformationCloseBtn.isDisplayed())
			{
				ConformationCloseBtn.click();
			}
			else {
				System.out.println("Conformation Close Btn Didn't Found");
			}
			
		}
	}
	
	
		public void editDocumentDoctorUploadedAndGivingFeeAndRating(WebDriver driver, String NoOfStarsUpToFive, String ConsultancyFee) throws Exception
		{	
			//Soft Assert
			
			Thread.sleep(1000);
			SoftAssert soft = new SoftAssert();
		    
			soft.assertTrue(AadhaarImg.isDisplayed(), "Aadhaar image is not displayed");
			soft.assertTrue(PanImg.isDisplayed(), "PAN image is not displayed");
			soft.assertTrue(ExperianceCertificateImg.isDisplayed(), "Experience Certificate image is not displayed");
			soft.assertTrue(HospitalProofImg.isDisplayed(), "Hospital Proof image is not displayed");
			soft.assertTrue(MedicalCertificateImg.isDisplayed(), "Medical Certificate image is not displayed");
			soft.assertTrue(NmcCertificateImg.isDisplayed(), "NMC Certificate image is not displayed");
			soft.assertAll();
			
			if(AadhaarImg.isDisplayed() &&
				    PanImg.isDisplayed() &&
				    ExperianceCertificateImg.isDisplayed() &&
				    HospitalProofImg.isDisplayed() &&
				    MedicalCertificateImg.isDisplayed() &&
				    NmcCertificateImg.isDisplayed())
			{
//				ApproveWithRatingBtn.click();
				
				driver.findElement(By.xpath("(//span[.=' ★ '])["+NoOfStarsUpToFive+"]")).click();
				Thread.sleep(2000);
				try {
					ConsultationFeeEdt.clear();
					Thread.sleep(1000);
					ConsultationFeeEdt.sendKeys(ConsultancyFee);
				} catch (Exception e) {
					Thread.sleep(1000);
				}
				ApproveKycBtn.click();
				Thread.sleep(2000);
				if(ConformationCloseBtn.isDisplayed())
				{
					ConformationCloseBtn.click();
				}
				else {
					System.out.println("Conformation Close Btn Didn't Found");
				}
				
				
			}
		}
			
		public void doctorRejecting(WebDriver driver, String ReasonForRejection) throws Exception
		{	
			//Soft Assert
			ExcelFileUtility eUtil = new ExcelFileUtility();
			
			
			
			Thread.sleep(1000);
			SoftAssert soft = new SoftAssert();
		    
			soft.assertTrue(AadhaarImg.isDisplayed(), "Aadhaar image is not displayed");
			soft.assertTrue(PanImg.isDisplayed(), "PAN image is not displayed");
			soft.assertTrue(ExperianceCertificateImg.isDisplayed(), "Experience Certificate image is not displayed");
			soft.assertTrue(HospitalProofImg.isDisplayed(), "Hospital Proof image is not displayed");
			soft.assertTrue(MedicalCertificateImg.isDisplayed(), "Medical Certificate image is not displayed");
			soft.assertTrue(NmcCertificateImg.isDisplayed(), "NMC Certificate image is not displayed");
			soft.assertAll();
			
			if(AadhaarImg.isDisplayed() &&
				    PanImg.isDisplayed() &&
				    ExperianceCertificateImg.isDisplayed() &&
				    HospitalProofImg.isDisplayed() &&
				    MedicalCertificateImg.isDisplayed() &&
				    NmcCertificateImg.isDisplayed())
			{
				Thread.sleep(2000);
				RejectWithReasonBtn.click();
				Thread.sleep(2000);
				ReasonForRejectionEdt.sendKeys(ReasonForRejection);
				Thread.sleep(2000);
				RejectKycBtn.click();
				Thread.sleep(2000);
				Assert.assertTrue(
					    ConformationCloseBtn.isDisplayed(),
					    "Doctor not Rejected"
					);

					System.out.println("Doctor Rejected Successfully");
				
			}
			

	}
	
	/*		
	//Soft Assert
	
	Thread.sleep(1000);
	SoftAssert soft = new SoftAssert();
    
	soft.assertTrue(AadhaarImg.isDisplayed(), "Aadhaar image is not displayed");
	soft.assertTrue(PanImg.isDisplayed(), "PAN image is not displayed");
	soft.assertTrue(ExperianceCertificateImg.isDisplayed(), "Experience Certificate image is not displayed");
	soft.assertTrue(HospitalProofImg.isDisplayed(), "Hospital Proof image is not displayed");
	soft.assertTrue(MedicalCertificateImg.isDisplayed(), "Medical Certificate image is not displayed");
	soft.assertTrue(NmcCertificateImg.isDisplayed(), "NMC Certificate image is not displayed");
	soft.assertAll();
	
*/	
	
	
/*	   If Else
 * 
	Thread.sleep(1000);
	if(AadhaarImg.isDisplayed())
	{
		System.out.println("Aadhar OK "+AadhaarImg.getText());
	}
	else if (PanImg.isDisplayed()) 
	{
		System.out.println("Pan OK "+PanImg.getText());
	}
	else if (ExperianceCertificateImg.isDisplayed()) 
	{
		System.out.println("Experiance Certificate "+ExperianceCertificateImg.getText());
	}
	else if (HospitalProofImg.isDisplayed()) 
	{
		System.out.println("Hospital Proof "+HospitalProofImg.getText());
	}
	else if (MedicalCertificateImg.isDisplayed()) 
	{
		System.out.println("Medical Certificate "+MedicalCertificateImg.getText());
	}
	else if (NmcCertificateImg.isDisplayed()) 
	{
		System.out.println("Nmc Certificate "+NmcCertificateImg.getText());
	}
*/
	public void givingRating(WebDriver driver, String RatingStarsOutOf5)
	{
		driver.findElement(By.xpath("(//span[.=' ★ '])["+RatingStarsOutOf5+"]")).click();
		
	}

	
	
}
