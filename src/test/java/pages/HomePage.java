package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[@title='Giriş Yap']")
	WebElement girisyap;
	
	@FindBy(id="searchData")
	WebElement searchbar;
	
	@FindBy(xpath="//*[@title='ARA']")
	WebElement searchbutton;
	
	

	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle(){
		return driver.getTitle();
		
	}
	
public LoginPage gotoLoginPage () {
	
	girisyap.click();
	return new LoginPage();
	
	
}

public SearchResultPage makeSearch(String productname) {
	waitForVisibilityOf(By.id("searchData"), 20);
	searchbar.sendKeys(productname);
	searchbutton.click();
	return new SearchResultPage();
	
	
}

	
	
}
