package genericUtilities;

import org.openqa.selenium.WebDriver;import org.openqa.selenium.chrome.ChromeDriver;
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
import io.github.bonigarcia.wdm.WebDriverManager;
//import objectRepository.DashboardPage;
//import objectRepository.LoginPage;
//import objectRepository.MyProfilePage;

public class BaseClass {

	public JavaUtility jUtility=new JavaUtility();
	public WebDriverUtility wUtility=new WebDriverUtility();
	public ExcelFileUtility eUtility=new ExcelFileUtility();
	public PropertyFileUtility pUtility=new PropertyFileUtility();
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	    @BeforeSuite(alwaysRun = true)
		public void bsConfig()
		{
			System.out.println("---Database Connection Successfully---");
		}
		
	    @BeforeClass (groups={"sprint-1","Sprint-2"})
		public void bcConfig() throws Exception
		{
			String BROWSER = pUtility.readDataFromPropertyFile("browser");
			String URL = pUtility.readDataFromPropertyFile("doctorurl");
			
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				WebDriverManager.chromedriver().clearDriverCache().setup();
				WebDriverManager.chromedriver().clearResolutionCache().setup();
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				System.out.println("Chrome Browser Launched Successfully");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				FirefoxOptions options = new FirefoxOptions();

		        // Create a FirefoxProfile to manage preferences
		        FirefoxProfile profile = new FirefoxProfile();

		        // Set a preference to allow or deny location access (false to deny)
		        profile.setPreference("geo.prompt.testing", true);
		        profile.setPreference("geo.prompt.testing.allow", false);

		        // Assign the profile to the FirefoxOptions
		        options.setProfile(profile);
		        
			    WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(options); 
				System.out.println("Firefox Browser Launched Successfully");
			}
			else if(BROWSER.equalsIgnoreCase("Edge"))
			{
				EdgeOptions options = new EdgeOptions();
		        options.addArguments("--disable-settings-window");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(options);
				System.out.println("Edge Browser Launched Successfully");
			}
			else 
			{
				System.out.println("Invalid Browser");
			}
			sDriver = driver;   //To Take ScreenShot
			wUtility.maximizeTheWindow(driver);
			wUtility.waitUntilPageLoad(driver);
			driver.get(URL);
		}
		
	@BeforeMethod(groups={"sprint-1","Sprint-2"})
		public void bmConfig() throws Exception, Exception
		{
//		    String USERNAME = pUtility.readDataFromPropertyFile("username");
//		    String PASSWORD = pUtility.readDataFromPropertyFile("password");
//		    Thread.sleep(2000);
//		    LoginPage lPage = new LoginPage(driver);
//		    Thread.sleep(1000);
//		    lPage.loginToApplication(USERNAME, PASSWORD);
//		    Thread.sleep(6000);
//			System.out.println("---Login successfully---");
		}
        
	@AfterMethod(groups={"sprint-1","Sprint-2"})
		public void amConfig() throws Exception
		{
//			ExcelFileUtility eUtil = new ExcelFileUtility();
//		    String ImagePath = eUtil.readDataFromExcel("ImagePath", 0, 1);
			
//		    Thread.sleep(4000);
//		    DashboardPage dbPage = new DashboardPage(driver);
//		    dbPage.getUserNameDrpDwn().click();
//		    Thread.sleep(1000);
//		    MyProfilePage mpPage = new MyProfilePage(driver);
//		    mpPage.logoutOfApplication();
		    
		    System.out.println("Logout Successfully");
		}
        
	@AfterClass(groups={"sprint-1","Sprint-2"})
		public void acConfig() throws InterruptedException
		{
		try 
		{
			Thread.sleep(1000);
		} 
		catch (Exception e) 
		{
			Thread.sleep(1000);
		}
		finally 
		{
			driver.quit();
			System.out.println("Browser Closed Successfully");
		}
		}
        
	@AfterSuite(groups={"sprint-1","Sprint-2"})
		public void asConfig()
		{
		   System.out.println("---Database Closed Successful---");
		}


	
	
	

}
