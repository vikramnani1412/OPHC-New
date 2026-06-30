package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrDoccumentsUploadPage {

	
	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//span[.='Medical Degree Certificate']")private WebElement UploadMedicalDegreeCertificateIcon;
    
    @FindBy(xpath="//span[.='NMC / State Medical Council Certificate']")private WebElement UploadNMCOrStateMedicalCouncilCertificateIcon;
	
	@FindBy(xpath="//span[.='Aadhaar Card']")private WebElement UploadAadhaarCardIcon;
	
    @FindBy(xpath="//span[.='PAN Card']")private WebElement UploadPanCardIcon;
	
    @FindBy(xpath="//span[.='Experience Certificate']")private WebElement UploadExperianceCertificateIcon;
    
    @FindBy(xpath="//span[.='Clinic / Hospital Affiliation Proof']")private WebElement ClinicOrHospitalAffiliationProofIcon;
    
    @FindBy(xpath="//label[@for='terms']/preceding-sibling::input[@type='checkbox']")private WebElement TermsChckBox;
    
    @FindBy(xpath="//p[contains(.,' I comply with')]/preceding-sibling::input[@type='checkbox']")private WebElement GuidelinesChckbox;
    
    @FindBy(xpath="//p[contains(.,' I declare my medical')]/preceding-sibling::input[@type='checkbox']")private WebElement MedicalRegistrationChckbox;
    
    @FindBy(xpath="//p[contains(.,' I consent')]/preceding-sibling::input[@type='checkbox']")private WebElement IconcentChckbox;
    
    @FindBy(xpath="//span[.='Submit Documents']")private WebElement SubmitDocumentsBtn;
    
    @FindBy(xpath="//img[@class='logout']")private WebElement LogoutLnk;
  
  
	//Rule-3:Create a constructor to initilise these elements
    
	public DrDoccumentsUploadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-4:Provide getters to access these variables
    
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

	public WebElement getClinicOrHospitalAffiliationProofIcon() {
		return ClinicOrHospitalAffiliationProofIcon;
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


	public WebElement getIconcentChckbox() {
		return IconcentChckbox;
	}


	public WebElement getSubmitDocumentsBtn() {
		return SubmitDocumentsBtn;
	}


	public WebElement getLogoutLnk() {
		return LogoutLnk;
	}

	
	
}


