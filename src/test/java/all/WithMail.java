package all;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genericUtilities.DataStore;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WithMail {

	WebDriverUtility    wUtil = new WebDriverUtility();
    JavaUtility         jUtil = new JavaUtility();
    ExcelFileUtility    eUtil = new ExcelFileUtility();
    PropertyFileUtility pUtil = new PropertyFileUtility();

    // URLs & admin credentials
    String doctorURL;
    String adminURL;
    String adminUsername;
    String adminPassword;
    String patientURL;

    // Doctor identity
    String fakeName;
    String firstName;
    String mobileNumber;

    // Doctor document paths
    String imagePath;
    String medicalCertificate;
    String nmcCertificate;
    String aadhar;
    String pan;
    String experience;
    String affiliationProof;

    // KYC / fee / rating data
    String firstRating;
    String consultancyFee;
    String editFirstRating;
    String editConsultancyFee;
    String finalRating;
    String reasonForRejection;

    int doctorNumber = 1;

    // Patient data
    String patientFullName;
    String patientEmail;
    String patientPhoneNo;
    String patientOTP;
    String phoneNumber;
	
	@Test
	public void doctor() throws Exception
	{
		doctorURL          = pUtil.readDataFromPropertyFile("doctorurl");
        imagePath          = eUtil.readDataFromExcel("Doctor", 4,  1);
        medicalCertificate = eUtil.readDataFromExcel("Doctor", 5,  1);
        nmcCertificate     = eUtil.readDataFromExcel("Doctor", 6,  1);
        aadhar             = eUtil.readDataFromExcel("Doctor", 7,  1);
        pan                = eUtil.readDataFromExcel("Doctor", 8,  1);
        experience         = eUtil.readDataFromExcel("Doctor", 9,  1);
        affiliationProof   = eUtil.readDataFromExcel("Doctor", 10, 1);

        fakeName     = jUtil.getRandomSingleName().trim().split(" ")[0];
        firstName    = jUtil.getRandomSingleName().trim().split(" ")[0];
        mobileNumber = jUtil.getRandomMobileNum();

        DataStore.doctorName   = fakeName;
        DataStore.mobileNumber = mobileNumber;
        DataStore.email        = firstName + "@gmail.com";
		
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Disable browser notifications
        options.addArguments("--disable-notifications");

        // Start browser maximized
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(doctorURL);
//        driver.findElement(By.xpath("//input[@id='emailOrPhone']")).sendKeys("vikram.xyug@gmail.com",Keys.ENTER);
        
//        driver.get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
        
        driver.findElement(By.xpath("//input[@id='emailOrPhone']")).sendKeys("vikram.xyug@gmail.com", Keys.ENTER);

     // Store the original window handle (doctor registration page)
     String originalWindow = driver.getWindowHandle();

     // Open Gmail in a new tab using JS
     ((JavascriptExecutor) driver).executeScript("window.open('https://chatgpt.com/c/6a588afb-c3c0-83ee-9e5e-83d10b3c22f2');", Keys.ENTER);

     // Wait for the new window/tab and switch to it
     Set<String> allWindows = driver.getWindowHandles();
     for (String windowHandle : allWindows) {
         if (!windowHandle.equals(originalWindow)) {
             driver.switchTo().window(windowHandle);
             break;
         }
     }
     
     driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("vikram.xyug@gmail.com",Keys.ENTER);

     // Now driver is focused on the new Gmail tab — do your OTP/email verification steps here

//     // When done, switch back to the original doctor registration page
//     driver.switchTo().window(originalWindow);
        
	}
}
