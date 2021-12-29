package pages;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class Careers extends Base {


	public Careers(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@data-alt='Check our open positions']")
	WebElement openPostionsBtn;

	@FindBy(id ="get_location")
	WebElement locationList;

	@FindBy(xpath = "//*[@data-alt='Experienced Automation QA Engineer']")
	WebElement QAPostionsBtn;

	@FindBy(name = "your-name")
	WebElement NameFld;

	@FindBy(name = "your-email")
	WebElement mailFld;

	@FindBy(name = "mobile-number")
	WebElement mobFld;

	@FindBy(id = "uploadtextfield")
	WebElement cvUploader;

	@FindBy(className ="close-form")
	WebElement closebtn;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitbtn;

	public void OpenPosition() {

		clickButton(openPostionsBtn);
	}

	public void selectLocation(String location) {
		select = new Select(locationList);
		select.selectByVisibleText(location);
	}

	public void OpenQAPositions() {

		clickButton(QAPostionsBtn);

	}

	public void applyForm(String name, String email, String mobile) {

		setText(NameFld,name);
		setText(mailFld,email);
		setText(mobFld,mobile);
	}


	public void uploadCv(String path) {
		//clickButton(cvUploader);
		try {
			robot = new Robot();
			StringSelection selection = new StringSelection(path);
			Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipBoard.setContents(selection, null);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closemsg() {

		clickButton(closebtn);

	}

	public void submitForm() {

		clickButton(submitbtn);

	}

}
