package doctorObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class WelcomePage {

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
    
    @FindBy(xpath="//button[.='Add Slot']")private WebElement AddSlotBtn2;
    
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
    
    
    // FreshlyAdded
    
    @FindBy(xpath="(//div[@class='slot-item ng-star-inserted'])[1]")private WebElement FirstAvailableSlotInSelectTimeSlotPage;
    
    
    
    
    //Rule-2:Create a constructor to initilise these elements
    
    public WelcomePage(WebDriver driver)
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

    
    
    public WebElement getAddSlotBtn2() {
        return AddSlotBtn2;
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
    
    public WebElement getFirstAvailableSlotInSelectTimeSlotPage() {
        return FirstAvailableSlotInSelectTimeSlotPage;
    }
    
    // Business Library

    public void DoctorAddingSlot(WebDriver driver) throws Exception
    {
//        String Time = jUtil.getCurrentTimeInOPHCformat();
//        String NextSlot = jUtil.getNextHalfHourSlotForOPHC();
        
        int Today = jUtil.getTodaysDayOfTheMonth();
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card calendar-card p-3']")));

        // Then click day 20
        Thread.sleep(2000);
        WebElement Todayy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.=' "+Today+" ']")));
        Thread.sleep(2000);
        wUtil.scrollToParticularWebElement(driver, AddSlotBtn);
        Thread.sleep(2000);
        Todayy.click();
        Thread.sleep(2000);
//        wUtil.scrollToParticularWebElement(driver, AddSlotBtn);
        Thread.sleep(2000);
        AddSlotBtn.click();
        Thread.sleep(2000);
        FirstAvailableSlotInSelectTimeSlotPage.click();
        Thread.sleep(2000);
        AddSlotBtn2.click();
        
        
    }
	
}
