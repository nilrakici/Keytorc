package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FavorilerimListelerimPage;
import pages.FavorilerimPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultPage;

public class AddRemoveFromFavesTest extends TestBase {


	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage result;
	ProductPage product;
	FavorilerimListelerimPage p1;
	FavorilerimPage p2;
	
	String arama= "https://www.n11.com/arama?q=samsung&pg=2";
	String getname;
	
	public AddRemoveFromFavesTest() {
		super();
	}

	
	@BeforeClass
	public void setup() throws InterruptedException {
		initialization();
		homePage= new HomePage();
		
		Assert.assertEquals(homePage.validateHomePageTitle(), "n11.com - Alışverişin Uğurlu Adresi");
		
		loginPage=homePage.gotoLoginPage();
		homePage=loginPage.Login("nilrakici@hotmail.com", "2121039nil");	
		
		
	}

	@Test(priority=0)
	public void SearchProduct() throws InterruptedException {
		
	result=	homePage.makeSearch("samsung");
	Assert.assertTrue(result.ValidatesearchResult()); // Samsung için sonuç geldiğinin verifikasyonu.
	result.goToNextPage();

	Assert.assertEquals(result.validateNextPage(), arama); // İkinci sayfada olduğunun verifikasyonu.
	product=result.clickProduct();
	
	
	
	}
	
	@Test(priority=1)
	public void AddProductToFaveList() throws InterruptedException {
		
	getname=product.getProductName();
	product.addtoFave();	
	ScrollUp();
	p1= product.DisplayFavePage();
	p2=p1.goToFavorilerim();
	
	
	Assert.assertTrue(p2.getPageSource().contains(getname)); // Ürünün favorilerim listesine eklendiğinin verifikasyonu.
		
	}
		
	@Test(priority=2)
	public void RemoveProductFromFaveList() {
		
	String dname=	p2.getProduct();
		
		p2.DeleteFromFaves();
		Assert.assertFalse(p2.getPageSource().contains(dname)); // Ürünün favorilerim listesinden kaldırıldığının verifikasyonu.
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
}
