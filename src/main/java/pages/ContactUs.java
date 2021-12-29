package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class ContactUs extends Base {
	
	public ContactUs(WebDriver driver) {
		super(driver);
	}

	@FindBy(name ="your-name")
	WebElement nameFld;
	
	@FindBy(name ="your-email")
	WebElement emailFld;
	
	@FindBy(name ="mobile-number")
	WebElement mobileFld;
	
	@FindBy(name ="your-subject")
	WebElement subjectFld;
	
	@FindBy(name ="your-message")
	WebElement messageFld;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(className = "wpcf7-response-output")
	WebElement warningmsg;
	
	public void SendMsg(String name,String email,String mobile,
			String subject,String msg)
	{
		setText(nameFld,name);
		setText(emailFld,email);
		setText(mobileFld,mobile);
		setText(subjectFld,subject);
		setText(messageFld,msg);

	}
	public void submit() {
		submitBtn.click();
	}
	
	public void InvalidEmailAssertion() {
		String Actualmsg = warningmsg.getText();
		String Expectedmsg = "The e-mail address entered is invalid.";
		Assert.assertEquals(Actualmsg, Expectedmsg);
	}
}
