package tests;

import org.testng.annotations.*;

import data.ReadData;
import pages.ContactUs;
import pages.Home;

public class TC01_ContactUs extends TestBase{


	Home homepageObj ;
	ContactUs contactUspageObj ;
	String name = ReadData.userdata.getProperty("name");
	String email = ReadData.userdata.getProperty("email");
	String mobile = ReadData.userdata.getProperty("mobile");

	@Test
	public void ContactUsMsginvalidMail() {
		homepageObj = new Home(driver);
		contactUspageObj = new ContactUs(driver);
		homepageObj.ContactUs();
		contactUspageObj.SendMsg(name,  email, mobile, "test", "Hi");
		contactUspageObj.submit();
		contactUspageObj.InvalidEmailAssertion();
	}
	


}
