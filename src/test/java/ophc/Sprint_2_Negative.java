package ophc;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import doctorObjectRepository.ApplicationFormPage;
import doctorObjectRepository.LoginPage;
import doctorObjectRepository.RegisterPage;
import doctorObjectRepository.VerifyCodePage;
import genericUtilities.BaseClass;
import genericUtilities.DoctorBaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sprint_2_Negative {

	WebDriverUtility    wUtil = new WebDriverUtility();
	JavaUtility         jUtil = new JavaUtility();
    ExcelFileUtility    eUtil = new ExcelFileUtility();
    PropertyFileUtility pUtil = new PropertyFileUtility();
    
    String doctorURL;
    String adminURL;
    String adminUsername;
    String adminPassword;

    String fakeName;
    String firstName;
    String mobileNumber;

    String imagePath;
    String medicalCertificate;
    String nmcCertificate;
    String aadhar;
    String pan;
    String experience;
    String affiliationProof;

    String firstRating;
    String consultancyFee;
    String editFirstRating;
    String editConsultancyFee;
    String finalRating;
    String reasonForRejection;

    int doctorNumber = 1;
    
	@Test
	public void registerPageNegativeTest() throws Exception
	{
    	String doctorURL = pUtil.readDataFromPropertyFile("doctorurl");
    	
    	String Name = "abcfhg";
    	
    	String MobileNumber = eUtil.readDataFromExcel("Doctor", 21, 1);
    	imagePath = eUtil.readDataFromExcel("Doctor", 4,  1);
    	
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        System.out.println("Login with ");
        
        driver.get(doctorURL);
        
        LoginPage lPage = new LoginPage(driver);
        lPage.getEmailOrPhoneEdt().sendKeys(MobileNumber, Keys.ENTER);
        Thread.sleep(1000);
        wUtil.takeScreenShot(driver, "Login with Un-Registered Mobile Number Error");
        
        Thread.sleep(2000);
        wUtil.waitForElementToBeClickable(driver, lPage.getRegisterLnk());
        lPage.getRegisterLnk().click();
        
        RegisterPage rPage = new RegisterPage(driver);
        rPage.RegisterToDoctorApplicationNegative(driver);
        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtnNegative(driver);
        
        ApplicationFormPage afPage = new ApplicationFormPage(driver);
        afPage.UploadDoctorDetailsNegative(driver, imagePath, Name);
        
	}
	
}
