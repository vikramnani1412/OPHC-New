package Admin;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import adminObjectRepository.AdminDashboardPage;
import adminObjectRepository.AdminLoginPage;
import adminObjectRepository.DrIdentityProofPage;
import adminObjectRepository.DrKycManagementPage;
import genericUtilities.AdminBaseClass;
import genericUtilities.DataStore;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToAdminAndApproveNewlyAddedDoctor extends AdminBaseClass {

	protected JavaUtility jUtil = new JavaUtility();
    protected WebDriverUtility wUtil = new WebDriverUtility();
    protected ExcelFileUtility eUtil = new ExcelFileUtility();
    protected PropertyFileUtility pUtil = new PropertyFileUtility();
	
    @Test(priority = 2)
	public void AdminApproveNewlyAddedDoctorr() throws Throwable
	{        
        String FrstRating = eUtil.readDataFromExcel("Doctor", 11, 1);
        String ConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 1);
        
        String EditFrstRating = eUtil.readDataFromExcel("Doctor", 11, 2);
        String EditConsultancyFee = eUtil.readDataFromExcel("Doctor", 12, 2);
        
        String ReasonForRejection = eUtil.readDataFromExcel("Doctor", 3, 3);
        
        int DoctorNumber=1;
        
        AdminDashboardPage adPage = new AdminDashboardPage(driver);

        adPage.clickOnDoctorIcon(driver);

        DrKycManagementPage kycmngPage = new DrKycManagementPage(driver);
        
        kycmngPage.ComparingNewlyRegisteredDoctorAndFirstDoctorInAdminPannelAndClickPreviewBtn(driver, DataStore.doctorName, DoctorNumber);

        DrIdentityProofPage dipPage = new DrIdentityProofPage(driver);
        dipPage.checkingEveryDocumentDoctorUploadedAndGivingFeeAndRating(driver, FrstRating, ConsultancyFee);
        
        // Editing Given Price and Rating
        Thread.sleep(3000);
        
        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        
        Thread.sleep(2000);
        
        dipPage.editDocumentDoctorUploadedAndGivingFeeAndRating(driver, EditFrstRating, EditConsultancyFee);
        
        Thread.sleep(2000);
        
        kycmngPage.clickOnFrstDoctorPreviewButton(driver);
        
        Thread.sleep(2000);
        
        dipPage.doctorRejecting(driver, ReasonForRejection);
	}
	
}
