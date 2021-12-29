package tests;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.helper;

public class TestBase {
	//public static WebDriver driver;
	protected ThreadLocal<RemoteWebDriver> driver = null;

	@BeforeSuite
	@Parameters(value={"browser","url"})
	public void startDriver (@Optional("chrome") String broswerType,@Optional("http://www.musala.com/")String Url)
	{
		driver = new ThreadLocal<>();
		DesiredCapabilities cap = new DesiredCapabilities ();
		cap.setCapability("browser", broswerType);
		cap.setCapability("url", Url);
		driver.set(new RemoteWebDriver(new URL("localhost:4444/wd/hub"),cap));
		//driver.manage().window().maximize();
		//driver.navigate().to(Url);

	}
	
	public static WebDriver getDriver()
	{
		return driver.get();	
	}

	@AfterSuite
	public void stopDriver() {
		getDriver().quit();
		driver.remove();
		//driver.quit();

	}
	
	@AfterMethod
	public static void takeScreenshotsOnfailure(ITestResult status)
	{
		if (status.getStatus() == ITestResult.FAILURE) {
			helper.screenshotsOnfailure(getDriver(), status.getName());
		}
		
	}
	public boolean IsElementPresent (By by) {
		try {
			getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	public void printList (ArrayList<String> TitleslistA,ArrayList<String> Infolist)
	{
		for (int i = 0; i < TitleslistA.size(); i++) {
			System.out.println("Postion: "+ TitleslistA.get(i));
			
			System.out.println("More Info: "+ Infolist.get(i)+"\n");
		}
		System.out.println("---------------------------------------- ");
		System.out.println("---------------------------------------- ");
	}

}
