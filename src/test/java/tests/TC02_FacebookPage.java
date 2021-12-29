package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.Company;
import pages.Home;

public class TC02_FacebookPage extends TestBase {

	Home homepageObj ;
	Company companypageObj;

	@Test
	public void VerfiyFacebookPage() {

		homepageObj = new Home(driver);

		companypageObj = new Company(driver);

		//Click ‘Company’ tap from the top
		homepageObj.CompanyLink();

		//Verify that the correct URL (http://www.musala.com/company/) loads
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.musala.com/company/" );

		//Verify that there is ‘Leadership’ section
		if(!IsElementPresent(By.className("company-members")))
		{
			Assert.fail("there is no ‘Leadership’ section");
		}

		//Click the Facebook link from the footer
		companypageObj.facebookPage();

		//Verify that the correct URL (http://www.musala.com/company/) loads
		for ( String windID: driver.getWindowHandles())
		{
			String windURL= driver.switchTo().window(windID).getCurrentUrl();
			if (windURL.equals("https://www.facebook.com/MusalaSoft?fref=ts\""))
				Assert.assertEquals(windURL, "https://www.facebook.com/MusalaSoft?fref=ts" );
		}

		//verify if the Musala Soft profile picture appears on the Facebook page
		if(!IsElementPresent(By.className("_6tb5")))
		{
			Assert.fail("there is no ‘Leadership’ section");
		}
		else
		{
			String src = driver.findElement(By.className("_6tb5")).getAttribute("src");
			Assert.assertEquals(src, "https://scontent.fcai20-1.fna.fbcdn.net/v/t1.6435-1/p200x200/158325737_3926723744014946_1132226306152824042_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=dbb9e7&_nc_ohc=6l8ZcSeosoEAX_09rjU&_nc_ht=scontent.fcai20-1.fna&oh=00_AT9iAFwqgKYFieE7g4YYt3Bdrv6gB1hGNNDUPTbBLigbCw&oe=61F29A45" );
		}
	}

}
