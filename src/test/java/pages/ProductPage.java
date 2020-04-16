package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase {

	@FindBy(id = "getWishList")
	WebElement addtofaves;

	@FindBy(id = "addToFavouriteWishListBtn")
	WebElement favoriekle;

	@FindBy(id = "nav-cart")
	WebElement favebutton;

	@FindBy(xpath = "//div[@class='myAccount']")
	WebElement myaccountbutton;

	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/a[2]")
	WebElement favelists;

	@FindBy(xpath = "//h1[@class='proName']")
	WebElement productname;

	public ProductPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productname.getText();

	}

	public void addtoFave() throws InterruptedException {

		addtofaves.click();
		waitForVisibilityOf(By.id("addToFavouriteWishListBtn"));
		favoriekle.click();
		ScrollUp();

		
	}

	public FavorilerimListelerimPage DisplayFavePage() {

		MouseHover(myaccountbutton);

		favelists.click();

		return new FavorilerimListelerimPage();

	}

}
