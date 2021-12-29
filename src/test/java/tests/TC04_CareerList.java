package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Careers;
import pages.Home;

public class TC04_CareerList extends TestBase {

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
		careerpageObj.selectLocation("Sofia");
		System.out.println("Sofia: ");
		List<WebElement> avPositionsLinksSofia = driver.findElements(By.className("card-jobsHot__link"));
		ArrayList<String> linksSofia = new ArrayList<String>();
		for (WebElement webElement : avPositionsLinksSofia) {
			linksSofia.add(webElement.getAttribute("href"));
		}
		List<WebElement> avPositionstitleSofia = driver.findElements(By.className("card-jobsHot__title"));
		ArrayList<String> titlesSofia = new ArrayList<String>();
		for (WebElement webElement : avPositionstitleSofia) {
			titlesSofia.add(webElement.getAttribute("data-alt"));
		}
		printList(titlesSofia,linksSofia);
		
		careerpageObj.selectLocation("Skopje");
		System.out.println("Skopje: ");
		List<WebElement> avPositionsLinksSkopje = driver.findElements(By.className("card-jobsHot__link"));
		ArrayList<String> linksSkopje = new ArrayList<String>();
		for (WebElement webElement : avPositionsLinksSkopje) {
			linksSkopje.add(webElement.getAttribute("href"));
		}
		List<WebElement> avPositionstitleSkopje = driver.findElements(By.className("card-jobsHot__title"));
		ArrayList<String> titlesSkopje = new ArrayList<String>();
		for (WebElement webElement : avPositionstitleSkopje) {
			titlesSkopje.add(webElement.getAttribute("data-alt"));
		}
		printList(titlesSkopje,linksSkopje);
	}

}
