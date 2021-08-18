package tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.FlightCodeMapping;
import CommonUtils.Wait;
import baseUtils.BrowserFactory;
import baseUtils.Log;
import pages.FlightStatusPage;

public class FlightStatusPage_tester extends FlightStatusPage{
	BrowserFactory factory  = new BrowserFactory();
	WebDriver driver = factory.getDriver();
	FlightCodeMapping flightCodeMap = new FlightCodeMapping();

	
	public WebElement getDateElement(String date) {
		// date = "2021-07-28";
		String dateXpath = "//input[@value='"+date+"']";
		return driver.findElement(By.xpath(dateXpath));
	}	

	public boolean setDeparture(String departure) {
		Log.info("Inside >> FlightStatusPage >> setDeparture: Setting departure field.");
		//get full city name if Code was provided
		String cityFullName=flightCodeMap.getNameByCode(departure);
		
		this.btn_departure_initial().click();
		this.txt_departure().sendKeys(cityFullName);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.btn_selection()))
        .click();
		//Validate the field is set properly
		if(driver.findElement(By.xpath("//span[text()='"+cityFullName+"']")).isDisplayed())
			return true;
		else
			return false;

	}
	
	public boolean setDestination(String destination) {
		Log.info("Inside >> FlightStatusPage >> setDestination: Setting destination field.");
		//get full city name if Code was provided
		String cityFullName=flightCodeMap.getNameByCode(destination);
				
		this.btn_destination_initial().click();
		Wait.waitTill(3000);
		this.txt_destination().sendKeys(cityFullName);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.btn_selection()))
        .click();
		//Validate the field is set properly
		if(driver.findElement(By.xpath("//span[text()='"+cityFullName+"']")).isDisplayed())
			return true;
		else
			return false;
		
//		String xpath = "//ul[@class='o-station-select__station-list']//span[text()='"+cityFullName+"']";
//		WebElement ele_SelectedCIty = driver.findElement(By.xpath(xpath));
//
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(ele_SelectedCIty))
//        .click();
//		
//		//Validate the field is set properly
//		if(ele_SelectedCIty.isDisplayed())
//			return true;
//		else
//			return false;
			
	}
	
	public boolean setDate(String date) {
		Log.info("Inside >> FlightStatusPage >> setDate: Setting date field.");
		this.btn_datePicker().click();
		Wait.waitTill(1000);
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(this.getDateElement(date)))
//        .click();
		
		if(this.getDateElement(date).isEnabled()) {
		this.getDateElement(date).click();
			return true;
		}else {
			return false;
		}
			
	}
	
	public void clickSubmit() {
		Log.info("Inside >> FlightStatusPage >> clickSubmit: Clicking Submit button.");
		this.btn_submit().click();
	}
	
	public String get_activeSearchResultDate() {
		String date = btn_activeSearchResultDate().findElement(By.tagName("div")).getText();
		System.out.println("Tag name >> " +date);
		return date;
	}
	
	public boolean flightNotFoundMessageExist() {
		
		try{
		driver.findElement(By.xpath("//h2[text()='Unfortunately, we could not find any results for your search.']"));
		return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public String getFlightStatus(String expectedStatus) {
		
		Wait.waitTill(1);
		String returnStr = "Status not found!";
		switch(expectedStatus) {
		case "on time":
			if(this.obj_FlightStatus_onTime().isDisplayed())
				returnStr = "on time";
			break;
		case "arrived":
			if(this.obj_FlightStatus_arrived().isDisplayed())
				returnStr= "arrived";
			break;
		}
		return returnStr;
	}
}
