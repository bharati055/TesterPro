package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlankPage;

public class SearchAndBookFlightStepDef {
	
	@Given("User has launched search flight page")
	public void user_has_launched_search_flight_page() {
		BlankPage blank = new BlankPage();
		blank.openSearchFlightPage();
	}
	
	@When("clicks on Search for flight button")
	public void clicks_on_search_for_flight_button() {
		
	}
	
	@Then("user can see the flight searched")
	public void user_can_see_the_flight_searched() {

	}
}
