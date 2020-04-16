package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;


public class LandingPageTest extends TestBase {
	
	HomePage homePage;
	

	public LandingPageTest() {
		// TODO Auto-generated constructor stub
		super();
	
	}
	
	
	
	@BeforeClass
	public void setup() {
		initialization();
		homePage= new HomePage();
		
	}
	
	@Test
	public void homePageTitleTest() {
		
		String title= homePage.validateHomePageTitle();
		Assert.assertEquals(title, "n11.com - Alışverişin Uğurlu Adresi");
		
		
	}
	
		
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
		
	
	

}
