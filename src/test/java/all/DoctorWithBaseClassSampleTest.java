package all;

import org.testng.annotations.Test;
import doctorObjectRepository.WelcomePage;
import genericUtilities.DoctorBaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

public class DoctorWithBaseClassSampleTest extends DoctorBaseClass {

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
	void all() throws Exception
	{
		WelcomePage wPage = new WelcomePage(driver);
        wPage.DoctorAddingSlot(driver);
        
        System.out.println("Doctor Availability Slot Added Successfully");
        
	}
	
}
