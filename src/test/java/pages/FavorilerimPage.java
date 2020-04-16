package pages;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FavorilerimPage extends TestBase {

	@FindBy(xpath = "//span[@class='deleteProFromFavorites']")
	WebElement deletebutton;

	@FindBy(xpath = "//span[@class='btn btnBlack confirm']")
	WebElement confirmbutton;

	@FindBy(xpath = "//h3[@class='productName ']")
	List<WebElement> productisim;

	public FavorilerimPage() {

		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String getPageSource() {

		String source = driver.getPageSource();
		return source;

	}

	public String getProduct() {

		String prname = productisim.get(0).getText();

		return prname;
	}

	public void DeleteFromFaves() {

		deletebutton.click();
		confirmbutton.click();
		driver.navigate().refresh();
	}

}
