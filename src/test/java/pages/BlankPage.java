package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import CommonUtils.UIInteraction;
import baseUtils.BasePage;
import baseUtils.BrowserFactory;

public class BlankPage extends BasePage{
	
	static final String _flightStatusPage_URL = "https://www.eurowings.com/en/information/at-the-airport/flight-status.html";
	static final String _flightStatusPage_title = "Flight status - Information - Eurowings";
	
	static final String _searchFlightPage_URL = "https://www.eurowings.com/en.html";
	static final String _searchFlightPage_title = "Eurowings - book cheap flights";
	
	BrowserFactory factory  = new BrowserFactory();
	UIInteraction ui = new UIInteraction();
	
//	By by_acceptCookies = By.xpath("//button[contains(@class,'cookie-consent--cta-accept')]");
	
	public boolean openFlightStatusPage() {
		factory.getDriver(_flightStatusPage_URL);
		ui.acceptSiteCookies();
		
		String actualTitle = factory.getDriver().getTitle();
		if(actualTitle==_flightStatusPage_title) {
			System.out.println("Successfully launched URL");
			return true;
		}else {
			System.out.println("Failed to launch url - "+_flightStatusPage_URL);
			return false;
		}
	}
	
	public boolean openSearchFlightPage() {
		factory.getDriver(_searchFlightPage_URL);
		ui.acceptSiteCookies();
		
		String actualTitle = factory.getDriver().getTitle();
		if(actualTitle==_flightStatusPage_title) {
			System.out.println("Successfully launched URL");
			return true;
		}else {
			System.out.println("Failed to launch url - "+_searchFlightPage_title);
			return false;
		}
	}
	
	public void closeBrowser() {
		factory.closeDriver();
	}
	
	public void quitDriver() {
		factory.quitDriver();
	}

}
