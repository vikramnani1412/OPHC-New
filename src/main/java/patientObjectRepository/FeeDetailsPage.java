package patientObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeeDetailsPage {

    //Rule-1: Finding WebElements Using @FindBy Annotations
    
    @FindBy(xpath="//img[@alt='close']")private WebElement CloseBtn;
    
    @FindBy(xpath="//span[contains(.,'')]/following-sibling::span[.='22']")private WebElement TodaysDateBasedOnDate;
    
    @FindBy(xpath="(//span[.='Available'])[1]")private WebElement FirstAvailableSlot;
    
    @FindBy(xpath="(//span[.='Available']/preceding-sibling::span[contains(.,'')])[1]")private WebElement FirstAvailableTime;
    
    @FindBy(xpath="//div[@class='time-slot-card booked ng-star-inserted']")private WebElement DaySlot;
    
    @FindBy(xpath="//span[contains(.,'9:00 AM')]/following-sibling::span[.='Available']")private WebElement DateSlot;
  
    @FindBy(xpath="//div[@class='day-item ng-star-inserted']")private WebElement AllTimeSlots;
    
    @FindBy(xpath="(//div[@class='day-item ng-star-inserted'])[1]")private WebElement FirstTimeSlot;
    
    @FindBy(xpath="(//div[@class='day-item ng-star-inserted'])[last()]")private WebElement LastTimeSlot;
    
    @FindBy(xpath="(//span[@class='day-date'])[1]")private WebElement TodaysDateBasedOnIndex;
    
    @FindBy(xpath="Available")private WebElement AvailablityBasedOnIndex;
    
    @FindBy(xpath="//div[@class='slots-legend']/following-sibling::button[contains(.,' Book Now')]")private WebElement BookNowBtn;
        
    @FindBy(xpath="//button[.='Follow up']")private WebElement BookNowBtnBasedOnIndex;
    
    @FindBy(xpath="//h6[.='Dr. jayant']/../../following-sibling::div/div/div/following-sibling::button[.='Book Now']")private WebElement BookNowBtnBasedOnDoctorName;
  
  
	//Rule-2: Create a constructor to initilise these elements    
    
	public FeeDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule-3: Provide getters to access these variables
	
	public WebElement getCloseBtn() {
		return CloseBtn;
	}


	public WebElement getTodaysDateBasedOnDate() {
		return TodaysDateBasedOnDate;
	}


	public WebElement getFirstAvailableTime() {
		return FirstAvailableTime;
	}


	public WebElement getLastTimeSlot() {
		return LastTimeSlot;
	}


	public WebElement getFirstAvailableSlot() {
		return FirstAvailableSlot;
	}


	public WebElement getFirstTimeSlot() {
		return FirstTimeSlot;
	}


	public WebElement getTodaysDateBasedOnIndex() {
		return TodaysDateBasedOnIndex;
	}


	public WebElement getAvailablityBasedOnIndex() {
		return AvailablityBasedOnIndex;
	}


	public WebElement getDaySlot() {
		return DaySlot;
	}


	public WebElement getDateSlot() {
		return DateSlot;
	}


	public WebElement getAllTimeSlots() {
		return AllTimeSlots;
	}


	public WebElement getBookNowBtn() {
		return BookNowBtn;
	}


	public WebElement getBookNowBtnBasedOnIndex() {
		return BookNowBtnBasedOnIndex;
	}


	public WebElement getBookNowBtnBasedOnDoctorName() {
		return BookNowBtnBasedOnDoctorName;
	}
	
	
	// Business Library
	
	public void bookingSlot(WebDriver driver) throws Exception {
	    
//	    List<WebElement> allSlots = driver.findElements(By.xpath("//div[@class='day-item ng-star-inserted']"));
//	    System.out.println("Total Slots: " + allSlots.size());
//        Thread.sleep(2000);
//	    for(int i=1;i<=allSlots.size();i++)
//	    {
//	    	try {
//	    		if(FirstAvailableSlot.isDisplayed())
//		    	{
////	    			driver.findElements(By.xpath("(//div[@class='day-item ng-star-inserted'])[i]"));
//		    		FirstAvailableSlot.click();
//		    		System.out.println(FirstAvailableTime.getText());
//		    	}
//	    		BookNowBtn.click();
//	    		break;
//			} catch (Exception e) {
//				
////				driver.findElements(By.xpath("(//div[@class='day-item ng-star-inserted'])["+i+"]")).click();
////				System.out.println("Checking");
//			}
//	    }
		
		
		List<WebElement> allSlots = driver.findElements(By.xpath("//div[@class='day-item ng-star-inserted']"));

		for (int i = 1; i <= allSlots.size(); i++) {

		    driver.findElement(
		            By.xpath("(//div[@class='day-item ng-star-inserted'])[" + i + "]")).click();

		    try {
		        if (FirstAvailableTime.isDisplayed()) {

		            FirstAvailableTime.click();
		            System.out.println("Available time found");
		            break;
		        }
		    } catch (Exception e) {
		        System.out.println("No available time in slot " + i);
		    }
		}

	}
	
	public void clickOnBookNowBtn() throws Exception
	{
		Thread.sleep(2000);
		BookNowBtn.click();
	}
	
	public void clickOnFrstAvailableSlot(WebDriver driver) throws Exception
	{
		for(int i=1;i<=5;i++)
		{
			try {
				Thread.sleep(2000);
				FirstAvailableSlot.click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("(//div[@class='day-item ng-star-inserted'])[" + i + "]")).click();
			}
		}
		
		
	}
	
	
}
