package patientObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RazorpayOPHC {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
	
	@FindBy(xpath="//button[@data-testid='account-menu-btn']")private WebElement RazorpayProfileIcon;
	
	@FindBy(xpath="//div[@data-value='upi']")private WebElement UPILnk;
	
    @FindBy(xpath="//div[@data-value='card']")private WebElement CardsLnk;
    
    @FindBy(xpath="//div[@data-value='emi']")private WebElement EMILnk;
    
    @FindBy(xpath="//div[@data-value='netbanking']")private WebElement NetBankingLnk;
    
    @FindBy(xpath="//div[@data-value='wallet']")private WebElement WalletLnk;
    
    @FindBy(xpath="//div[@data-value='paylater']")private WebElement PayLaterLnk;
    
    @FindBy(xpath="//button[.=' Continue']")private WebElement ContinueBtn;
    
    
	//Rule-2 : Create a constructor to initilise these elements    
    
	public RazorpayOPHC(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3 : Provide getters to access these variables
    

	public WebElement getRazorpayProfileIcon() {
		return RazorpayProfileIcon;
	}


	public WebElement getUPILnk() {
		return UPILnk;
	}


	public WebElement getCardsLnk() {
		return CardsLnk;
	}


	public WebElement getEMILnk() {
		return EMILnk;
	}


	public WebElement getNetBankingLnk() {
		return NetBankingLnk;
	}


	public WebElement getWalletLnk() {
		return WalletLnk;
	}


	public WebElement getPayLaterLnk() {
		return PayLaterLnk;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
    

	
	
}
