package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResultPage extends TestBase {

	// Search result list locators
	@FindBy(xpath = "//*[contains(@href,'https://www.n11.com/urun/samsung')]")
	List<WebElement> searchResultList;

	@FindBy(id = "filterList__cat")
	WebElement searchResult;

	@FindBy(xpath = "//a[@class='next navigation']")
	WebElement nextpage;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean ValidatesearchResult() {

		return searchResult.isDisplayed();
	}

	public void goToNextPage() {
		nextpage.click();

	}

	public String validateNextPage() {

		String url = driver.getCurrentUrl();

		return url;

	}

	public ProductPage clickProduct() throws InterruptedException {

		searchResultList.get(2).click(); // 3.ürünü seçmek.
		waitForVisibilityOf(By.xpath("//a[@class='btn btnGrey addBasketUnify']"));

		return new ProductPage();
	}

}
