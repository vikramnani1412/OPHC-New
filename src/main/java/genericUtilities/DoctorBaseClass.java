package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import doctorObjectRepository.DoctorProfilePage;
import doctorObjectRepository.LoginPage;
import doctorObjectRepository.LogoutPage;
import doctorObjectRepository.VerifyCodePage;
import doctorObjectRepository.WelcomePage;
//import doctorObjectRepository.DoctorDashboardPage;
//import doctorObjectRepository.DoctorLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DoctorBaseClass {

    // Utility Objects
    protected JavaUtility jUtility = new JavaUtility();
    protected WebDriverUtility wUtility = new WebDriverUtility();
    protected ExcelFileUtility eUtility = new ExcelFileUtility();
    protected PropertyFileUtility pUtility = new PropertyFileUtility();

    // Driver Objects
    protected WebDriver driver;
    public static WebDriver sDriver;

    // ============================
    // Database Setup
    // ============================

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        System.out.println("========== Database Connection Established ==========");
    }

    // ============================
    // Browser Launch
    // ============================

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {

        String browser = pUtility.readDataFromPropertyFile("browser");
        String DOCTOR_URL = pUtility.readDataFromPropertyFile("doctorurl");

        driver = initializeBrowser(browser);

        if (driver == null) {
            throw new RuntimeException("Browser Initialization Failed");
        }

        sDriver = driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get(DOCTOR_URL);

        System.out.println("Doctor Application Opened Successfully");
    }

    // ============================
    // Doctor Login
    // ============================

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {

    	String MOBILE_NUMBER = pUtility.readDataFromPropertyFile("dmobilenumber");
    	
        LoginPage lPage = new LoginPage(driver);
        lPage.loginToDoctor(MOBILE_NUMBER);

        VerifyCodePage vcPage = new VerifyCodePage(driver);
        vcPage.enteringOtpAndClickOnVerifyBtn(driver);
        System.out.println("Doctor Login Successful");
    }

    // ============================
    // Doctor Logout
    // ============================

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {

    	WelcomePage wPage = new WelcomePage(driver);
    	wPage.getProfileImg().click(); 
    	Thread.sleep(1000);
    	
    	DoctorProfilePage dpPage = new DoctorProfilePage(driver);
    	dpPage.clickOnLogoutLnk();
    	
    	
    	LogoutPage lPage = new LogoutPage(driver);
    	lPage.clickOnYesLogoutBtn();
    	
    	System.out.println("Logout Successfully");
    	
    }

    // ============================
    // Browser Close
    // ============================

    @AfterClass(alwaysRun = true)
    public void afterClass() {

        try {

            if (driver != null) {

                driver.quit();

                System.out.println("Browser Closed Successfully");
            }

        } catch (Exception e) {

            System.out.println(
                    "Error while closing browser : " + e.getMessage());
        }
    }

    // ============================
    // Database Close
    // ============================

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {

        System.out.println("========== Database Connection Closed ==========");
    }

    // ============================
    // Browser Factory Method
    // ============================

    private WebDriver initializeBrowser(String browser) {

        WebDriver driver = null;

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");

                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver(chromeOptions);

                System.out.println("Chrome Browser Launched Successfully");
                break;

            case "firefox":

                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("geo.prompt.testing", true);
                profile.setPreference("geo.prompt.testing.allow", false);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);

                WebDriverManager.firefoxdriver().setup();

                driver = new FirefoxDriver(firefoxOptions);

                System.out.println("Firefox Browser Launched Successfully");
                break;

            case "edge":

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");

                WebDriverManager.edgedriver().setup();

                driver = new EdgeDriver(edgeOptions);

                System.out.println("Edge Browser Launched Successfully");
                break;

            default:

                throw new IllegalArgumentException(
                        "Invalid Browser Name : " + browser);
        }

        return driver;
    }
}