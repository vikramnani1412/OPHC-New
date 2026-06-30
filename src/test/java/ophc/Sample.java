package ophc;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

public class Sample {

    WebDriverUtility     wUtil = new WebDriverUtility();
    JavaUtility          jUtil = new JavaUtility();
    ExcelFileUtility     eUtil = new ExcelFileUtility();
    PropertyFileUtility  pUtil = new PropertyFileUtility();

    String doctorURL;
    String adminURL;
    String adminUsername;
    String adminPassword;
    String patientURL;

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

    String patientFullName;
    String patientEmail;
    String patientPhoneNo;
    String patientOTP;

    String phoneNumber;

    @Test(priority = 1)
    public void DoctorRegistrationTest() throws Exception {

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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(doctorURL);

        wUtil.takeScreenShot(driver, "Login Page");
        System.out.println("Registration Started");
        System.out.println("Doctor Name : " + DataStore.doctorName);

        LoginPage lPage = new LoginPage(driver);
        wUtil.waitForElementToBeClickable(driver, lPage.getRegisterLnk());
        lPage.getRegisterLnk().click();

        RegisterPage rPage = new RegisterPage(driver);
        rPage.RegisterToDoctorApplication(driver, fakeName, fakeName + "@gmail.com", mobileNumber);

        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();

        ApplicationFormPage afPage = new ApplicationFormPage(driver);
        afPage.uploadDoctorDetails(driver, imagePath);

        Thread.sleep(2000);
        wUtil.scrollPageUp(2);

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
        duPage.documentsUploading(driver, medicalCertificate, nmcCertificate, aadhar, pan, experience, affiliationProof);

        Thread.sleep(2000);

        ProfileUnderVerificationPage puvPage = new ProfileUnderVerificationPage(driver);
        puvPage.clickOnLogoutBtn(driver);

        System.out.println("Registration Completed");
        driver.quit();
    }

    @Test(priority = 2)
    public void LoginToAdminAndApproveNewlyAddedDoctorTest() throws Throwable {

        adminURL           = pUtil.readDataFromPropertyFile("adminurl");
        adminUsername      = pUtil.readDataFromPropertyFile("adminusername");
        adminPassword      = pUtil.readDataFromPropertyFile("adminpassword");
        firstRating        = eUtil.readDataFromExcel("Doctor", 11, 1);
        consultancyFee     = eUtil.readDataFromExcel("Doctor", 12, 1);
        editFirstRating    = eUtil.readDataFromExcel("Doctor", 11, 2);
        editConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 2);
        reasonForRejection = eUtil.readDataFromExcel("Doctor", 3,  3);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(adminURL);

        System.out.println("Admin = " + DataStore.doctorName + " Admin Started Visiting Doctor Profile");

        AdminLoginPage alPage = new AdminLoginPage(driver);
        alPage.loginToAdmin(adminUsername, adminPassword);
        Thread.sleep(2000);

        AdminDashboardPage adPage = new AdminDashboardPage(driver);
        adPage.clickOnDoctorIcon(driver);
        Thread.sleep(2000);

        DrKycManagementPage kycmngPage = new DrKycManagementPage(driver);
        kycmngPage.ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(driver, DataStore.doctorName, doctorNumber);
        Thread.sleep(2000);

        DrIdentityProofPage dipPage = new DrIdentityProofPage(driver);
        dipPage.checkingEveryDocumentDoctorUploadedAndGivingFeeAndRating(driver, firstRating, consultancyFee);
        Thread.sleep(2000);

        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        Thread.sleep(2000);
        dipPage.editDocumentDoctorUploadedAndGivingFeeAndRating(driver, editFirstRating, editConsultancyFee);
        Thread.sleep(2000);

        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        Thread.sleep(2000);
        dipPage.doctorRejecting(driver, reasonForRejection);

        System.out.println("Admin Registration Rejected");
        driver.quit();
    }

    @Test(priority = 3)
    public void rejectedDoctorReSubmitingDocumentsTest() throws Exception {

        doctorURL          = pUtil.readDataFromPropertyFile("doctorurl");
        medicalCertificate = eUtil.readDataFromExcel("Doctor", 5,  1);
        nmcCertificate     = eUtil.readDataFromExcel("Doctor", 6,  1);
        aadhar             = eUtil.readDataFromExcel("Doctor", 7,  1);
        pan                = eUtil.readDataFromExcel("Doctor", 8,  1);
        experience         = eUtil.readDataFromExcel("Doctor", 9,  1);
        affiliationProof   = eUtil.readDataFromExcel("Doctor", 10, 1);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(doctorURL);

        System.out.println("Doctor Re Started Registration");

        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(DataStore.mobileNumber);
        Thread.sleep(1000);

        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();
        Thread.sleep(1000);

        WebElement profileRejectMsg = driver.findElement(By.xpath("//p[.='Your Profile is Rejected']"));
        if (profileRejectMsg.isDisplayed()) {
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[.='Upload Documents']")).click();
        }

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

        DocumentsUploadAfterKycRejecting duPage = new DocumentsUploadAfterKycRejecting(driver);
        duPage.documentsUploadingAfterKycRejecting(driver, medicalCertificate, nmcCertificate, aadhar, pan, experience, affiliationProof);

        ProfileUnderVerificationPage puvPage = new ProfileUnderVerificationPage(driver);
        puvPage.clickOnLogoutBtn(driver);

        System.out.println("Re Submission Completed");
        driver.quit();
    }

    @Test(priority = 4)
    public void AdminApprovingDoctorAfterReuploadingDocs() throws Throwable {

        adminURL           = pUtil.readDataFromPropertyFile("adminurl");
        adminUsername      = pUtil.readDataFromPropertyFile("adminusername");
        adminPassword      = pUtil.readDataFromPropertyFile("adminpassword");
        editConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 2);
        finalRating        = eUtil.readDataFromExcel("Doctor", 16, 2);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(adminURL);

        System.out.println("Re Visiting Doctors Registration");

        AdminLoginPage alPage = new AdminLoginPage(driver);
        alPage.loginToAdmin(adminUsername, adminPassword);
        Thread.sleep(2000);

        AdminDashboardPage adPage = new AdminDashboardPage(driver);
        adPage.clickOnDoctorIcon(driver);
        Thread.sleep(2000);

        DrKycManagementPage kycmngPage = new DrKycManagementPage(driver);
        kycmngPage.ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(driver, DataStore.doctorName, doctorNumber);
        Thread.sleep(2000);

        DrIdentityProofPage dipPage = new DrIdentityProofPage(driver);
        dipPage.editDocumentDoctorUploadedAndGivingFeeAndRating(driver, finalRating, editConsultancyFee);
        Thread.sleep(2000);

        System.out.println("Re Visited Doctors Registration and Approved by Admin");
        driver.quit();
    }

    @Test(priority = 5)
    public void loginToDoctorPannelSettingDoctorAvailabilityTest() throws Throwable {

        doctorURL = pUtil.readDataFromPropertyFile("doctorurl");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(doctorURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(DataStore.mobileNumber);

        Thread.sleep(2000);
        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn();

        Thread.sleep(2000);
        WelcomePage wPage = new WelcomePage(driver);
        wPage.DoctorAddingSlot(driver);

        System.out.println("Doctor Availability Slot Added Successfully");
        driver.quit();
    }

    @Test(priority = 6)
    public void PatientRegisteringTest() throws Exception {

        patientFullName = jUtil.getRandomSingleName();
        patientEmail    = patientFullName + "@gmail.com";
        patientPhoneNo  = jUtil.getRandomMobileNum();
        patientOTP      = pUtil.readDataFromPropertyFile("potp");
        patientURL      = pUtil.readDataFromPropertyFile("patienturl");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(patientURL);

        PatientHomePage phPage = new PatientHomePage(driver);
        phPage.getLoginBtn().click();

        PatientLoginPage plPage = new PatientLoginPage(driver);
        plPage.clickOnRegisterLnk(driver);

        PatientRegisterPage prPage = new PatientRegisterPage(driver);
        prPage.registerAsPatient(patientFullName, patientEmail, patientPhoneNo);

        PatientVerifyCodePage vcPage = new PatientVerifyCodePage(driver);
        vcPage.enterOtpAndClickVerifyBtn(patientOTP);

        driver.findElement(By.className("profile-avatar")).click();

        WebElement nameElement = driver.findElement(By.xpath("//h4[contains(text(),'" + patientFullName + "')]"));
        wUtil.waitForElementToBeVisible(driver, nameElement);

        if (nameElement.isDisplayed()) {
            String visibleName = nameElement.getText().trim();
            System.out.println("Expected Patient Name : " + patientFullName);
            System.out.println("Visible Patient Name  : " + visibleName);
            Assert.assertEquals(visibleName, patientFullName,
                    "Name mismatch! Expected: " + patientFullName + " but got: " + visibleName);
        }

        PatientPage pPage = new PatientPage(driver);
        pPage.getPageCloseBtn().click();

        driver.quit();
    }
}