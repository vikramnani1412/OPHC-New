package ophc;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import adminObjectRepository.AdminDashboardPage;
import adminObjectRepository.AdminLoginPage;
import adminObjectRepository.DrIdentityProofPage;
import adminObjectRepository.DrKycManagementPage;
import adminObjectRepository.PatientHomePage;
import doctorObjectRepository.ApplicationFormPage;
import doctorObjectRepository.DocumentUploadPage;
import doctorObjectRepository.DocumentsUploadAfterKycRejecting;
import doctorObjectRepository.LoginPage;
import doctorObjectRepository.ProfileUnderVerificationPage;
import doctorObjectRepository.RegisterPage;
import doctorObjectRepository.VerifyCodePage;
import doctorObjectRepository.WelcomePage;
import genericUtilities.DataStore;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import patientObjectRepository.PatientLoginPage;
import patientObjectRepository.PatientPage;
import patientObjectRepository.PatientRegisterPage;
import patientObjectRepository.PatientVerifyCodePage;

public class Registration {

    WebDriverUtility wUtil = new WebDriverUtility();
    JavaUtility jUtil = new JavaUtility();
    ExcelFileUtility eUtil = new ExcelFileUtility();
    PropertyFileUtility pUtil = new PropertyFileUtility(); 
    
    String mobileNumber = jUtil.getRandomMobileNum();
    private String fakeName;

    @Test(priority = 1)
    public void DoctorRegistrationTest() throws Exception 
    {
        String URL = pUtil.readDataFromPropertyFile("doctorurl");

        String ImagePath = eUtil.readDataFromExcel("Doctor", 4, 1);
        String MedicalCertificate = eUtil.readDataFromExcel("Doctor", 5, 1);
        String NMCcertificate = eUtil.readDataFromExcel("Doctor", 6, 1);
        String Aadhar = eUtil.readDataFromExcel("Doctor", 7, 1);
        String Pan = eUtil.readDataFromExcel("Doctor", 8, 1);
        String Experiance = eUtil.readDataFromExcel("Doctor", 9, 1);
        String AffiliationProof = eUtil.readDataFromExcel("Doctor", 10, 1);

        fakeName = jUtil.getRandomSingleName().trim().split(" ")[0];
        String firstName = jUtil.getRandomSingleName().trim().split(" ")[0];

        String mobileNumber = jUtil.getRandomMobileNum();

        DataStore.doctorName = fakeName;
        DataStore.mobileNumber = mobileNumber;
        DataStore.email = firstName + "@gmail.com";

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(URL);

        wUtil.takeScreenShot(driver, "Login Page");
        
        System.out.println("Registration Started");
        
        LoginPage lPage = new LoginPage(driver);

        wUtil.waitForElementToBeClickable(driver, lPage.getRegisterLnk());

        lPage.getRegisterLnk().click();

        RegisterPage rPage = new RegisterPage(driver);
        rPage.RegisterToDoctorApplication(driver, fakeName, fakeName + "@gmail.com", mobileNumber);

        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();

//        driver.findElement(By.xpath("//button[.='Choose File']")).click();
//        
//        Thread.sleep(2000);
//        
//        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(ImagePath);
//        
//        Thread.sleep(1000);
//        
//        driver.close();
        
        ApplicationFormPage afPage = new ApplicationFormPage(driver);
        afPage.uploadDoctorDetails(driver, ImagePath);

        Thread.sleep(2000);

        wUtil.scrollPageUp(2);

        driver.findElement(By.xpath("//span[.='Medical Degree  Certificate']/../preceding-sibling::input")).sendKeys(MedicalCertificate);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='NMC / State Medical Council Certificate']/../preceding-sibling::input")).sendKeys(NMCcertificate);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Aadhaar Card']/../preceding-sibling::input")).sendKeys(Aadhar);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='PAN Card']/../preceding-sibling::input")).sendKeys(Pan);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Experience  Certificate']/../preceding-sibling::input")).sendKeys(Experiance);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Clinic / Hospital  Affiliation Proof']/../preceding-sibling::input")).sendKeys(AffiliationProof);

        Thread.sleep(2000);

        DocumentUploadPage duPage = new DocumentUploadPage(driver);
        duPage.documentsUploading(driver, MedicalCertificate, NMCcertificate, Aadhar, Pan, Experiance, AffiliationProof);

        Thread.sleep(2000);
        
        ProfileUnderVerificationPage puvPage = new ProfileUnderVerificationPage(driver);
        puvPage.clickOnLogoutBtn(driver);
        
        System.out.println("Registration Completed");
        
        driver.quit();
    }

    @Test(priority = 2)
    public void LoginToAdminAndApproveNewlyAddedDoctorTest() throws Throwable {

        String URL = pUtil.readDataFromPropertyFile("adminurl");
        String USERNAME = pUtil.readDataFromPropertyFile("adminusername");
        String PASSWORD = pUtil.readDataFromPropertyFile("adminpassword");
        
        String FrstRating = eUtil.readDataFromExcel("Doctor", 11, 1);
        String ConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 1);
        
        String EditFrstRating = eUtil.readDataFromExcel("Doctor", 11, 2);
        String EditConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 2);
        
        String ReasonForRejection = eUtil.readDataFromExcel("Doctor", 3, 3);
        
        int DoctorNumber=1;

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(URL);

        System.out.println("Admin Started Visiting Doctor Profile");

        AdminLoginPage alPage = new AdminLoginPage(driver);

        alPage.loginToAdmin(USERNAME, PASSWORD);

        Thread.sleep(2000);
        
        AdminDashboardPage adPage = new AdminDashboardPage(driver);

        adPage.clickOnDoctorIcon(driver);

        Thread.sleep(2000);
        
        DrKycManagementPage kycmngPage = new DrKycManagementPage(driver);
        
        kycmngPage.ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(driver, DataStore.doctorName, DoctorNumber);

        Thread.sleep(2000);
        
        DrIdentityProofPage dipPage = new DrIdentityProofPage(driver);
        dipPage.checkingEveryDocumentDoctorUploadedAndGivingFeeAndRating(driver, FrstRating, ConsultancyFee);
        
        // Editing Given Price and Rating
        Thread.sleep(2000);
        
        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        
        Thread.sleep(2000);
        
        dipPage.editDocumentDoctorUploadedAndGivingFeeAndRating(driver, EditFrstRating, EditConsultancyFee);
        
        Thread.sleep(2000);
        
        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        
        Thread.sleep(2000);
        
        dipPage.doctorRejecting(driver, ReasonForRejection);
        
        System.out.println("Admin Registration Rejected");
        
        driver.quit();
    }
    
    
    @Test(priority = 3)
    public void rejectedDoctorReSubmitingDocumentsTest() throws Exception 
    {    	
    	String URL = pUtil.readDataFromPropertyFile("doctorurl");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(URL);

        System.out.println("Doctor Re Started Registration");
        
        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(DataStore.mobileNumber);

        Thread.sleep(1000);
        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();
        
        Thread.sleep(1000);
        
        WebElement ProfileRejectMsg = driver.findElement(By.xpath("//p[.='Your Profile is Rejected']"));
        
        if(ProfileRejectMsg.isDisplayed())
        {
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("//a[.='Upload Documents']")).click();
        }
        
        String MedicalCertificate = eUtil.readDataFromExcel("Doctor", 5, 1);
        String NMCcertificate = eUtil.readDataFromExcel("Doctor", 6, 1);
        String Aadhar = eUtil.readDataFromExcel("Doctor", 7, 1);
        String Pan = eUtil.readDataFromExcel("Doctor", 8, 1);
        String Experiance = eUtil.readDataFromExcel("Doctor", 9, 1);
        String AffiliationProof = eUtil.readDataFromExcel("Doctor", 10, 1);
        
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Medical Degree  Certificate']/../preceding-sibling::input")).sendKeys(MedicalCertificate);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='NMC / State Medical Council Certificate']/../preceding-sibling::input")).sendKeys(NMCcertificate);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Aadhaar Card']/../preceding-sibling::input")).sendKeys(Aadhar);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='PAN Card']/../preceding-sibling::input")).sendKeys(Pan);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Experience  Certificate']/../preceding-sibling::input")).sendKeys(Experiance);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Clinic / Hospital  Affiliation Proof']/../preceding-sibling::input")).sendKeys(AffiliationProof);

        Thread.sleep(2000);
        
        DocumentsUploadAfterKycRejecting duPage = new DocumentsUploadAfterKycRejecting(driver);
        duPage.documentsUploadingAfterKycRejecting(driver, MedicalCertificate, NMCcertificate, Aadhar, Pan, Experiance, AffiliationProof);
        
        ProfileUnderVerificationPage puvPage = new ProfileUnderVerificationPage(driver);
        puvPage.clickOnLogoutBtn(driver);
        
        System.out.println("Re Submission Completed");
        
        driver.quit();
    }
    
    @Test(priority = 4)
    public void AdminApprovingDoctorAfterReuploadingDocs() throws Throwable
    {
//    	String Date = jUtil.getTodayExactDate();
//        String eDate = jUtil.getTodaysDateInFormat();
//        String time = jUtil.increaseTimeByPlusThirtyMin();
        
        String URL = pUtil.readDataFromPropertyFile("adminurl");
        String USERNAME = pUtil.readDataFromPropertyFile("adminusername");
        String PASSWORD = pUtil.readDataFromPropertyFile("adminpassword");
        
        
        String EditFrstRating = eUtil.readDataFromExcel("Doctor", 11, 2);
        String EditConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 2);
        
        String FinalRating = eUtil.readDataFromExcel("Doctor", 16, 2);
        
        String ReasonForRejection = eUtil.readDataFromExcel("Doctor", 3, 3);
        
        int DoctorNumber=1;

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(URL);

        System.out.println("Re Visiting Doctors Registration");
        
        AdminLoginPage alPage = new AdminLoginPage(driver);

        alPage.loginToAdmin(USERNAME, PASSWORD);

        Thread.sleep(2000);
        
        AdminDashboardPage adPage = new AdminDashboardPage(driver);

        adPage.clickOnDoctorIcon(driver);

        Thread.sleep(2000);
        
        DrKycManagementPage kycmngPage = new DrKycManagementPage(driver);
        
        kycmngPage.ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(driver, DataStore.doctorName, DoctorNumber);
        
        Thread.sleep(2000);
        
        DrIdentityProofPage dipPage = new DrIdentityProofPage(driver);
        dipPage.editDocumentDoctorUploadedAndGivingFeeAndRating(driver, FinalRating, EditConsultancyFee);
        
        Thread.sleep(2000);
        
        System.out.println("Re Visited Doctors Registration and Approved by Admin");
        
        driver.quit();
        
       
    }
    
    @Test(priority = 5)
	public void loginToDoctorPannelSettingDoctorAvailabilityTest() throws Throwable
	{				
        String URL = pUtil.readDataFromPropertyFile("doctorurl");
//        DataStore.mobileNumber
//        String Mobile = "8686184458";
        
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(DataStore.mobileNumber);
        
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();
        
        WelcomePage wPage = new WelcomePage(driver);
        wPage.DoctorAddingSlot(driver);
        
            
   }
    
    @Test(priority = 6)
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
        
        pPage.patientBookingDoctor(driver, OTP);
        
        
        
//        driver.quit();
      
	
	}
	
   
    
}
