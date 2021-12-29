package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class Home extends Base {
	
	public Home(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[1]/a")
	//@FindBy(using Text =  "Company")
	WebElement Companylnk;
	
	@FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[2]/a")
	WebElement ServicesBtn;
	
	@FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[3]/a")
	WebElement ClientsBtn;
	
	@FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[4]/a")
	WebElement CommunityBtn;
	
	@FindBy(xpath = "//*[@id=\"menu-main-nav-1\"]/li[5]/a")
	WebElement CareersBtn;
	
	@FindBy(xpath = "//span[@data-alt='Contact us']")
	WebElement ContactUsBtn;
	

	public void CompanyLink() {
		clickButton(Companylnk);
	}
	
	public void CareersLink() {
		clickButton(CareersBtn);
	}
	
	public void ContactUs() {
		scrollDown();
		clickButton(ContactUsBtn);
	}
	
}
