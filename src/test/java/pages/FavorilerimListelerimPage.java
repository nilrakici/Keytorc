package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FavorilerimListelerimPage extends TestBase {

	@FindBy(xpath = "//h4[@class='listItemTitle']")
	WebElement favorilerim;

	public FavorilerimListelerimPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public FavorilerimPage goToFavorilerim() {

		favorilerim.click();

		return new FavorilerimPage();

	}

}
