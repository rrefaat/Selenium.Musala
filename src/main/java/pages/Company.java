package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Company extends Base {

	public Company(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/footer/div/div/a[4]/span")
	WebElement facebookIcon;
	
	public void facebookPage() {
		facebookIcon.click();
	}

}
