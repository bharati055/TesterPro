package CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseUtils.BrowserFactory;

public class UIInteraction {
	
	public void acceptSiteCookies() {
		BrowserFactory factory  = new BrowserFactory();
		By by_acceptCookies = By.xpath("//button[contains(@class,'cookie-consent--cta-accept')]");
	
		WebElement btn_acceptCookies = factory.getDriver().findElement(by_acceptCookies);
		if(btn_acceptCookies.isDisplayed()) {
			btn_acceptCookies.click();
		}
	}
	
	
}
