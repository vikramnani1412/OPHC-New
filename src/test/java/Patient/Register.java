package Patient;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import adminObjectRepository.PatientHomePage;
import doctorObjectRepository.LoginPage;
import doctorObjectRepository.VerifyCodePage;
import doctorObjectRepository.WelcomePage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import patientObjectRepository.PatientLoginPage;
import patientObjectRepository.PatientPage;
import patientObjectRepository.PatientRegisterPage;
import patientObjectRepository.PatientVerifyCodePage;

public class Register {

	WebDriverUtility wUtil = new WebDriverUtility();
    ExcelFileUtility eUtil = new ExcelFileUtility();
    JavaUtility jUtil = new JavaUtility();
    PropertyFileUtility pUtil = new PropertyFileUtility();
	
    @Test(priority = 1)
	public void loginToDoctorPannelSettingDoctorAvailabilityTest() throws Throwable
	{				
		String URL = pUtil.readDataFromPropertyFile("doctorurl");
        String PHONENUMBER = pUtil.readDataFromPropertyFile("dmobilenumber");
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(PHONENUMBER);
        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();
        
        WelcomePage wPage = new WelcomePage(driver);
        wPage.DoctorAddingSlot(driver);
        
        
        
        
 }
    
   
    
	@Test(priority = 2)
	public void PatientRegisteringTest() throws Exception
	{
		WebDriverUtility wUtil = new WebDriverUtility();
        ExcelFileUtility eUtil = new ExcelFileUtility();
        JavaUtility jUtil = new JavaUtility();

        String FullName = jUtil.getRandomSingleName();
        String Email = FullName + "@gmail.com";
        String PhoneNo = jUtil.getRandomMobileNum();
        String OTP = pUtil.readDataFromPropertyFile("potp");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://stg-patient.ophc.in/landing/Homepage");

        PatientHomePage phPage = new PatientHomePage(driver);
        phPage.getLoginBtn().click();

        PatientLoginPage plPage = new PatientLoginPage(driver);
        plPage.clickOnRegisterLnk(driver);

        PatientRegisterPage prPage = new PatientRegisterPage(driver);
        prPage.registerAsPatient(FullName, Email, PhoneNo);

        PatientVerifyCodePage vcPage = new PatientVerifyCodePage(driver);
        vcPage.enterOtpAndClickVerifyBtn(OTP);

        driver.findElement(By.className("profile-avatar")).click();

        // Using framework utility instead of explicit wait
        WebElement nameElement = driver.findElement(By.xpath("//h4[contains(text(),'" + FullName + "')]"));
        wUtil.waitForElementToBeVisible(driver, nameElement);

        if (nameElement.isDisplayed()) {
            String VisibleName = nameElement.getText().trim();

            System.out.println("Expected Name : " + FullName);
            System.out.println("Visible Name  : " + VisibleName);

            Assert.assertEquals(VisibleName, FullName, "Name mismatch! Expected: " + FullName + " but got: " + VisibleName);
        }
        
        PatientPage pPage = new PatientPage(driver);
        pPage.getPageCloseBtn().click();
        
//        driver.quit();
      
	
	}
	
	@Test
	public void Test()
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		String Time = jUtil.getCurrentTimeInOPHCformat();
		System.out.println(Time);
		
		System.out.println(jUtil.getNextHalfHourSlotForOPHC());
		
	}
	
}
