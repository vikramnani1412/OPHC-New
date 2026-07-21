package patientObjectRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class RazorpayNetBankingPage {

    //Rule-1 :  Finding WebElements Using @FindBy Annotations
	
	@FindBy(xpath="//div[@data-value='SBIN']")private WebElement SBILnk;
	
	@FindBy(xpath="//div[@data-value='HDFC']")private WebElement HDFCLnk;
	
    @FindBy(xpath="//div[@data-value='ICIC']")private WebElement ICICILnk;
    
    @FindBy(xpath="//div[@data-value='UTIB']")private WebElement AxisLnk;
    
    @FindBy(xpath="//div[@data-value='BARB_R']")private WebElement BOBLnk;
    
    @FindBy(xpath="//span[@data-testid='More Banks']")private WebElement MoreBanksLnk;
    
    @FindBy(xpath="//button[.=' Continue']")private WebElement ContinueBtn;
    
    @FindBy(xpath="//button[.='Success']")private WebElement SuccessBtn;
    
    @FindBy(xpath="//button[.='Failure']")private WebElement FailureBtn;
  
	//Rule-2 : Create a constructor to initilise these elements    
    
	public RazorpayNetBankingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3 : Provide getters to access these variables
	

	public WebElement getSBILnk() {
		return SBILnk;
	}


	public WebElement getHDFCLnk() {
		return HDFCLnk;
	}


	public WebElement getICICILnk() {
		return ICICILnk;
	}


	public WebElement getAxisLnk() {
		return AxisLnk;
	}


	public WebElement getBOBLnk() {
		return BOBLnk;
	}


	public WebElement getMoreBanksLnk() {
		return MoreBanksLnk;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}


	public WebElement getSuccessBtn() {
		return SuccessBtn;
	}


	public WebElement getFailureBtn() {
		return FailureBtn;
	}

	
	// Business Library
	
	public void bookSlotUsingSBIbank(WebDriver driver) throws Exception
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		
		SBILnk.click();
		Thread.sleep(2000);
        
		try 
		{
			WebElement PaymentDeclined = driver.findElement(By.xpath("//div[.='Payment could not be completed']"));
			if(PaymentDeclined.isDisplayed())
			{
				driver.findElement(By.xpath("//button[contains(@class,'absolute')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@title='Close Checkout']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[.='Yes, exit']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//h6[.='OPHC Wallet']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[.=' Continue ']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//h6[.='OPHC Wallet']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[.=' Continue ']")).click();
				Thread.sleep(2000);
				
			}
		} 
		catch (Exception e) 
		{
			String ParentWin = driver.getWindowHandle();
			
			Set<String> ChildWins = driver.getWindowHandles();
			
			for(String ChildWin : ChildWins)
			{
				if(!ChildWin.equals(ParentWin))
				{
				    driver.switchTo().window(ChildWin);
				    driver.findElement(By.xpath("//button[.='Success']")).click();
				}
			}
			
			driver.switchTo().window(ParentWin);
		}
		
        String ParentWin = driver.getWindowHandle();
		
		Set<String> ChildWins = driver.getWindowHandles();
		
		for(String ChildWin : ChildWins)
		{
			if(!ChildWin.equals(ParentWin))
			{
			    driver.switchTo().window(ChildWin);
			    driver.findElement(By.xpath("//button[.='Success']")).click();
			}
		}
		
		driver.switchTo().window(ParentWin);
        
		
	}

}
