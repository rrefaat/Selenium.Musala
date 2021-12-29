package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.awt.Robot;

public class Base {
	
	protected WebDriver diver;
	
	public Select select;
	public Robot robot;
	JavascriptExecutor js ;

	public  Base (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement Button) {
		Button.click();
	}
	
	protected static void setText(WebElement Field,String text) {
		Field.sendKeys(text);
	}
	
	public void scrollDown() {
		js.executeScript("scrollBy(0,2500)");
	}
	
	public void passRecaptcha() {
	}
	
	
}
