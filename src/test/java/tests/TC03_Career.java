package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Careers;
import pages.Home;

public class TC03_Career extends TestBase {

	Home homepageObj ;
	Careers careerpageObj;

	@Test(priority = 1)
	public void VerfiyMainPageSections() {

		homepageObj = new Home(driver);
		careerpageObj = new Careers(driver);

		//Navigate to Careers menu 
		homepageObj.CareersLink();

		//Click ‘Check our open positions’ button
		careerpageObj.OpenPosition();

		//Verify that  ‘Join Us’ page is opened
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://www.musala.com/careers/join-us/" );

		//From the dropdown ‘Select location’ select ‘Anywhere’
		careerpageObj.selectLocation("Anywhere");

		//Choose open position
		//careerpageObj.OpenQAPositions("Experienced Automation QA Engineer");
		careerpageObj.OpenQAPositions();

		//Verify that 4 main sections are shown
		//Verify on the General Description section
		if(!IsElementPresent(By.xpath("//*[@class='square square-requirements']")))
		{
			Assert.fail("there is no ‘General description’ section");
		}

		//Verify on the Requirements section
		if(!IsElementPresent(By.xpath("//*[@class='square square-advantages']")))
		{
			Assert.fail("there is no ‘Requirements’ section");
		}

		//Verify on the Responsibilities section
		if(!IsElementPresent(By.xpath("//*[@class='square square-expectations']")))
		{
			Assert.fail("there is no ‘Responsibilities’ section");
		}

		//Verify on the What we offer section
		if(!IsElementPresent(By.xpath("//*[@class='square square-offer']")))
		{
			Assert.fail("there is no ‘What we offer’ section");
		}
	}

	@Test
	public void applyForPostion() {
		homepageObj = new Home(driver);
		careerpageObj = new Careers(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;


		//Navigate to Careers menu 
		homepageObj.CareersLink();

		//Click ‘Check our open positions’ button
		careerpageObj.OpenPosition();

		//From the dropdown ‘Select location’ select ‘Anywhere’
		careerpageObj.selectLocation("Anywhere");

		//Choose open position
		//careerpageObj.OpenQAPositions("Experienced Automation QA Engineer");
		careerpageObj.OpenQAPositions();

		//careerpageObj.apply();
		WebElement ele = driver.findElement(By.xpath("(//input[@value='Apply'])"));		
		jse.executeScript("arguments[0].click()", ele);
	}

	@Test
	public void VerifyForm() {
		homepageObj = new Home(driver);
		careerpageObj = new Careers(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fileName = "Rawan Refaat CV_.pdf";
		String filePath = System.getProperty("user.dir")+"\\uploads\\"+fileName;

		//Navigate to Careers menu 
		homepageObj.CareersLink();

		//Click ‘Check our open positions’ button
		careerpageObj.OpenPosition();

		//From the dropdown ‘Select location’ select ‘Anywhere’
		careerpageObj.selectLocation("Anywhere");

		//Choose open position
		//careerpageObj.OpenQAPositions("Experienced Automation QA Engineer");
		careerpageObj.OpenQAPositions();
		WebElement apply = driver.findElement(By.xpath("(//input[@value='Apply'])"));
		jse.executeScript("arguments[0].click()", apply);

		careerpageObj.applyForm("rawan","x","01002909292");
		WebElement cvUploader = driver.findElement(By.xpath("(//input[@id='uploadtextfield'])"));
		jse.executeScript("arguments[0].click()", cvUploader);
		careerpageObj.uploadCv(filePath);

		WebElement submit = driver.findElement(By.xpath("(//input[@value='Send'])"));		
		jse.executeScript("arguments[0].click()", submit);
		WebElement close = driver.findElement(By.xpath("(//*[contains(text(), 'Close')])"));
		//careerpageObj.submitForm();
		if (!IsElementPresent(By.xpath("//*[@id='wpcf7-f880-o1']/form/div[4]/div/div")))
		{
			Assert.fail("no validation msg with wrong email format");
		}
		else
		{
			jse.executeScript("arguments[0].click()", close);
			//careerpageObj.closemsg();
		}

		careerpageObj.applyForm("","x@test.com","01002909292");
		jse.executeScript("arguments[0].click()", cvUploader);
		careerpageObj.uploadCv(filePath);

		jse.executeScript("arguments[0].click()", submit);

		if (!IsElementPresent(By.xpath("//*[@id='wpcf7-f880-o1']/form/div[4]/div/div")))
		{
			Assert.fail("no validation msg with emptyname");
		}
		else
		{
			jse.executeScript("arguments[0].click()", close);
			//careerpageObj.closemsg();
		}
	}

}