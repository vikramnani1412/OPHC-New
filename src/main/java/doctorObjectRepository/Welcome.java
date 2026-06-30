package doctorObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class Welcome {

	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	String Time = jUtil.getCurrentTimeInOPHCformat();
	
	
	String NextSlot = jUtil.getNextHalfHourSlotForOPHC();
	
	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//img[@class='profile-img']")private WebElement ProfileImg;
    
    @FindBy(xpath="//span[.=' View All >> ']")private WebElement ConsultationsViewAllLnk;
    
    @FindBy(xpath="//button[.='▶']")private WebElement NextMonthBtn;
    
    @FindBy(xpath="//button[.='Set Availability']")private WebElement SetAvailabitityBtn;
    
    @FindBy(xpath="//span[.=' + Add Slot ']")private WebElement AddSlotBtn;
    
    @FindBy(xpath="(//div[@class='day disabled ng-star-inserted'])[last()]")private WebElement LastDisabledDayInTheMonthEle;
    
    @FindBy(xpath="//div[@class='day today ng-star-inserted active']")private WebElement TodaysDateInTheMonthEle;
    
    @FindBy(xpath="(//div[@class='day ng-star-inserted'])[1]")private WebElement TomorrowDateEle;
    
    @FindBy(xpath="//i[@class='fa-solid fa-xmark delete-icon ng-star-inserted']")private WebElement SlotDeleteIcon;
    
    @FindBy(xpath="//button[.='Cancel']")private WebElement RemoveSlotCancelBtn;
    
    @FindBy(xpath="//button[.='Yes, Remove']")private WebElement RemoveSlotYesBtn;
    
    @FindBy(xpath="(//h5[.='Upcoming Consultations']/../following-sibling::div/div/div)")private WebElement TotalUpcomingSlots;
    
    @FindBy(xpath="//div[@class='slot booked-slot']")private WebElement TotalBookedSlots;
    
    @FindBy(xpath="//div[@class='slot']")private WebElement TotalAvailableSlots;
    
    @FindBy(xpath="//small[.='16:30']/../following-sibling::div//div[.=' Join Call ']")private WebElement AccodingCrntTimeJoinCallBtn;
    
    @FindBy(xpath="//small[.='Today ']/following-sibling::small[.='18:00']/../following-sibling::div//button[.=' Join Call ']")private WebElement AccToTodayTimeJoinCallBtn;
    
    
	//Rule-2:Create a constructor to initilise these elements
    
	public Welcome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule-3:Provide getters to access these variables
    

	public WebElement getProfileImg() {
		return ProfileImg;
	}

	public WebElement getConsultationsViewAllLnk() {
		return ConsultationsViewAllLnk;
	}

	public WebElement getAddSlotBtn() {
		return AddSlotBtn;
	}

	public WebElement getNextMonthBtn() {
		return NextMonthBtn;
	}


	public WebElement getSetAvailabitityBtn() {
		return SetAvailabitityBtn;
	}


	public WebElement getLastDisabledDayInTheMonthEle() {
		return LastDisabledDayInTheMonthEle;
	}


	public WebElement getTodaysDateInTheMonthEle() {
		return TodaysDateInTheMonthEle;
	}


	public WebElement getTomorrowDateEle() {
		return TomorrowDateEle;
	}


	public WebElement getSlotDeleteIcon() {
		return SlotDeleteIcon;
	}


	public WebElement getRemoveSlotCancelBtn() {
		return RemoveSlotCancelBtn;
	}


	public WebElement getRemoveSlotYesBtn() {
		return RemoveSlotYesBtn;
	}


	public WebElement getTotalUpcomingSlots() {
		return TotalUpcomingSlots;
	}


	public WebElement getTotalBookedSlots() {
		return TotalBookedSlots;
	}


	public WebElement getTotalAvailableSlots() {
		return TotalAvailableSlots;
	}


	public WebElement getAccodingCrntTimeJoinCallBtn() {
		return AccodingCrntTimeJoinCallBtn;
	}
	
	
	// Business Library
	
	public void DoctorAddingSlot(WebDriver driver) throws Exception
	{
//		String Time = jUtil.getCurrentTimeInOPHCformat();
//		String NextSlot = jUtil.getNextHalfHourSlotForOPHC();
		
		int Today = jUtil.getTodaysDayOfTheMonth();
		driver.findElement(By.xpath("//div[.=' "+Today+" ']")).click();
		Thread.sleep(2000);
		AddSlotBtn.click();
		Thread.sleep(2000);
		
		
		
	}
	
	public void bookingSlot(WebDriver driver)
	{
		
		driver.findElement(By.xpath("//small[.='Today ']/following-sibling::small[.='"+Time+"']/../following-sibling::div//button[.=' Join Call ']"));
	}
}
