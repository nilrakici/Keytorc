package base;

import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public class TestBase {
	


	
	public static WebDriver driver;
	
	public TestBase() {
		
	}
public static void initialization ()
{
	
	        // initialization
			System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.n11.com");
}


public void waitForVisibilityOf (By locator) {
	int attempts=0;
	while (attempts<2) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), 20);
		}
	  catch (StaleElementReferenceException e) {
		
	}
	
	attempts++;
	
	}	
}

private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
	timeoutInSeconds= timeoutInSeconds != null ? timeoutInSeconds:30;
	WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds );
	wait.until(condition);
	
}

public void MouseHover(WebElement element) {
	
	Actions action= new Actions(driver);
	
	try {
	action.moveToElement(element).build().perform();
}
	
	catch(MoveTargetOutOfBoundsException e) {
		
	}
	
	

}
public void ScrollUp() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,-350)", "");
}


}
	

