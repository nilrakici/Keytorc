package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.twilio.Twilio;

import base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
	@FindBy(id = "loginButton")
	WebElement loginButton;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	public String VerifyLoginTitle() {
		waitForVisibilityOf(By.id("loginButton"));
		return driver.getTitle();

	}

	public HomePage Login(String un, String pwd) throws InterruptedException {

		email.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();

		return new HomePage();

	}

}
