package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationFormPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@formcontrolname='fullName']")private WebElement FullNameEdt;
    
    @FindBy(xpath="//input[@formcontrolname='email']")private WebElement EmailEdt;
    
    @FindBy(xpath="//input[@formcontrolname='phone']")private WebElement PhoneEdt;
    
    @FindBy(xpath="//input[@formcontrolname='whatsapp']")private WebElement WhatsappEdt;
    
    @FindBy(xpath="//input[@formcontrolname='sameAsMobile']")private WebElement SameAsWhatsappNumberCheckBox;
    
    @FindBy(xpath="//input[@formcontrolname='terms']")private WebElement TermsAndConditionsCheckBox;
    
    @FindBy(xpath="//span[.='Terms']")private WebElement TermsLnk;
    
    @FindBy(xpath="//span[.='Privacy Policies']")private WebElement PrivacyAndPolicyLnk;
    
    @FindBy(xpath="//button[.=' Sign up ']")private WebElement SignUpBtn;
    
    @FindBy(xpath="//a[.=' Login ']")private WebElement LoginLnk;
  
	//Rule-3:Create a constructor to initilise these elements    
    
	public ApplicationFormPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Rule-4:Provide getters to access these variables
	
}
