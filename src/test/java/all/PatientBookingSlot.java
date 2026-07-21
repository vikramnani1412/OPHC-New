package all;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PatientBaseClass;
import genericUtilities.WebDriverUtility;
import patientObjectRepository.AppointmentConfirmedPage;
import patientObjectRepository.AppointmentsPage;
import patientObjectRepository.DoctorDetailsPage;
import patientObjectRepository.FeeDetailsPage;
import patientObjectRepository.FindDoctorsPage;
import patientObjectRepository.HowDoYouWantToConsultPage;
import patientObjectRepository.PatientDetailsPage;
import patientObjectRepository.RazorpayNetBankingPage;
import patientObjectRepository.RazorpayOPHC;
import patientObjectRepository.UploadMedicalReportsAfterAppointmentConfirmPage;

//@Listeners(genericUtilities.PatientListnersImplementationClass.class)
public class PatientBookingSlot extends PatientBaseClass {

	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();
	
	@Test(priority = 2)
	void PatientBookingSlotTest() throws Exception
	{
        String patientFullName = jUtil.getRandomSingleName();
        
        FindDoctorsPage fdocPage = new FindDoctorsPage(driver);
        fdocPage.selectingDoctor();
        Thread.sleep(2000);

        DoctorDetailsPage ddPage = new DoctorDetailsPage(driver);
        ddPage.BookingAppointment();
        
        
//        FeeDetailsPage fdPage = new FeeDetailsPage(driver);
//        fdPage.clickOnFrstAvailableSlot(driver);
//        Thread.sleep(2000);
//        fdPage.clickOnBookNowBtn();
//        Thread.sleep(1000);

        // ── Consultation type ─────────────────────────────────────────────
        HowDoYouWantToConsultPage hPage = new HowDoYouWantToConsultPage(driver);
        hPage.CompleteHowDoYouWantToConsultDetailsAndClickOnContinueBtn();
        Thread.sleep(2000);

        // ── Razorpay payment ──────────────────────────────────────────────
        WebElement Frame = driver.findElement(
                By.xpath("//iframe[@class='razorpay-checkout-frame']"));
        wUtil.waitForElementToBeClickable(driver, Frame);
        driver.switchTo().frame(Frame);

        RazorpayOPHC rPage = new RazorpayOPHC(driver);
        rPage.getNetBankingLnk().click();
        Thread.sleep(2000);

        RazorpayNetBankingPage rnPage = new RazorpayNetBankingPage(driver);
        rnPage.bookSlotUsingSBIbank(driver);
        Thread.sleep(1000);

//        // ── Patient details & reports ─────────────────────────────────────
//        PatientDetailsPage pdPage = new PatientDetailsPage(driver);
//        pdPage.givingPatientDetails(patientFullName);

        UploadMedicalReportsAfterAppointmentConfirmPage umraaPage = new UploadMedicalReportsAfterAppointmentConfirmPage(driver);
        umraaPage.uploadingMedicalReports(driver);

        // ── Confirm booking ───────────────────────────────────────────────
        AppointmentConfirmedPage acPage = new AppointmentConfirmedPage(driver);
        String BookingID = acPage.getBookingId().getText();
        System.out.println("Booking id is " + BookingID);

        wUtil.scrollPageDown(1000);
        acPage.getContinueBtn().click();

        AppointmentsPage aPage = new AppointmentsPage(driver);
        aPage.checkingAppointmentBookedOrNot(BookingID);
        Thread.sleep(2000);
    }
	
	
	@Test
	public void report() throws Exception
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		eUtil.generateSampleMedicalReport(".\\src\\test\\resources\\OPHC Automation Excel.xlsx", "Medical Report", "Doctor", 4, 2);
	}
	
}
