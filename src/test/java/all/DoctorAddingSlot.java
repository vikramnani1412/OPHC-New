package all;

import org.testng.annotations.Test;

import doctorObjectRepository.WelcomePage;
import genericUtilities.DoctorBaseClass;

public class DoctorAddingSlot extends DoctorBaseClass {

	@Test(priority = 1)
	public void doctorAddingSlot() throws Exception
	{
		WelcomePage wPage = new WelcomePage(driver);
        wPage.DoctorAddingSlot(driver);
        System.out.println("Doctor Availability Slot Added Successfully");
	}
	
}
