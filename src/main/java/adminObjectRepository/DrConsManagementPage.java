package adminObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DrConsManagementPage {

	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="")private WebElement DoctorIcon;
    
    @FindBy(xpath="")private WebElement PatientIcon;
    
    @FindBy(xpath="")private WebElement DashboardIcon;
    	
  
	//Rule-3:Create a constructor to initilise these elements
    
	public DrConsManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    

	//Rule-4:Provide getters to access these variables
	
}
