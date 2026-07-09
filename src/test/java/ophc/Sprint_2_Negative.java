package ophc;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import doctorObjectRepository.ApplicationFormPage;
import doctorObjectRepository.DocumentUploadPage;
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
    	
    	medicalCertificate = eUtil.readDataFromExcel("Doctor", 5,  1);
        nmcCertificate = eUtil.readDataFromExcel("Doctor", 6,  1);
        aadhar = eUtil.readDataFromExcel("Doctor", 7,  1);
        pan = eUtil.readDataFromExcel("Doctor", 8,  1);
        experience = eUtil.readDataFromExcel("Doctor", 9,  1);
        affiliationProof = eUtil.readDataFromExcel("Doctor", 10, 1);
    	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
        // Disable browser notifications
        options.addArguments("--disable-notifications");
        
        // Start browser maximized
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        System.out.println("Login with ");
        
        driver.get(doctorURL);
        
        LoginPage lPage = new LoginPage(driver);
        lPage.getEmailOrPhoneEdt().sendKeys(MobileNumber, Keys.ENTER);
        Thread.sleep(1000);
        wUtil.takeScreenShot(driver, "A_Login with Un-Registered Mobile Number Error");
        
        Thread.sleep(2000);
        wUtil.waitForElementToBeClickable(driver, lPage.getRegisterLnk());
        lPage.getRegisterLnk().click();
        
        RegisterPage rPage = new RegisterPage(driver);
        rPage.RegisterToDoctorApplicationNegative(driver);
        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtnNegative(driver);
        
        ApplicationFormPage afPage = new ApplicationFormPage(driver);
        afPage.UploadDoctorDetailsNegative(driver, imagePath, Name);
        
        wUtil.scrollPageUp(1);
        Thread.sleep(2000);
        
        wUtil.takeScreenShot(driver, "S_Without Documents Uploading Submit Documents Btn is Disabled Error");
        Thread.sleep(2000);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Medical Degree  Certificate']/../preceding-sibling::input")).sendKeys(medicalCertificate);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='NMC / State Medical Council Certificate']/../preceding-sibling::input")).sendKeys(nmcCertificate);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Aadhaar Card']/../preceding-sibling::input")).sendKeys(aadhar);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='PAN Card']/../preceding-sibling::input")).sendKeys(pan);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Experience  Certificate']/../preceding-sibling::input")).sendKeys(experience);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='Clinic / Hospital  Affiliation Proof']/../preceding-sibling::input")).sendKeys(affiliationProof);
        Thread.sleep(2000);
        
        DocumentUploadPage duPage = new DocumentUploadPage(driver);
        duPage.DocumentsUploadNegative(driver);
        
        
        
        
        
	}
	
}
 