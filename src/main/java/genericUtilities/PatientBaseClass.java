package genericUtilities;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import patientObjectRepository.PatientLoginPage;
import patientObjectRepository.PatientProfilePage;

public class PatientBaseClass extends CommonBaseClass {

    protected WebDriver driver;

    protected PropertyFileUtility pUtil = new PropertyFileUtility();
    protected WebDriverUtility wUtil = new WebDriverUtility();
    protected JavaUtility jUtil = new JavaUtility();
    protected ExcelFileUtility eUtil = new ExcelFileUtility();

    @BeforeClass(alwaysRun = true)
    public void launchBrowser() throws IOException {

        String browser = pUtil.readDataFromPropertyFile("browser");
        String url = pUtil.readDataFromPropertyFile("patientUrl");

        // Used by Extent Report
        System.setProperty("browser", browser);
        System.setProperty("baseUrl", url);

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-notifications");
            driver = new EdgeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");
            driver = new FirefoxDriver(options);

        } else {

            throw new RuntimeException("Unsupported Browser : " + browser);
        }

        // Store WebDriver in ThreadLocal
        CommonBaseClass.setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(url);
    }

    
    @BeforeMethod
    public void loginToPatientApp() throws Throwable
    {
    	String MOBILE_NUMBER = pUtil.readDataFromPropertyFile("pmobilenumber");
        String OTP = pUtil.readDataFromPropertyFile("potp");

        PatientLoginPage lPage = new PatientLoginPage(driver);
        lPage.patientLogin(driver, MOBILE_NUMBER);
        System.out.println("Patient Login Successful");
    }
    
    @AfterMethod
    public void logoutFromPatientApp() throws Exception
    {
    	PatientProfilePage ppPage = new PatientProfilePage(driver);
        ppPage.logoutPatient();

        System.out.println("Patient Logout Successfully");
    }
    
    
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }

        CommonBaseClass.unloadDriver();
    }
}