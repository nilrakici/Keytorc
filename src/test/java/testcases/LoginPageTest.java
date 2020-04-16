package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}

	
	@BeforeClass
	public void setup() {
		initialization();
		homePage = new HomePage();
		
		
	}
	
	@Test(priority=0)
	public void gotoLoginPageTest() {
		loginPage= homePage.gotoLoginPage();
		
		// Verify Login Title.
			
		Assert.assertEquals( loginPage.VerifyLoginTitle(), "Giriş Yap - n11.com");
			
	}
	
	@Test (priority=1)
	
	public void LoginSite() throws InterruptedException {
		
		loginPage.Login("nilrakici@hotmail.com", "2121039nil");

	}
	
	@AfterClass
	public void teardown() {
	driver.quit();
		
	}
	
	
}
