package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepDef {
	@Given("Sample given statement")
	public void sample_given_statement() {
		System.out.println("Sample given statement");
	}
	@When("Sample when statement")
	public void sample_when_statement() {
		System.out.println("Sample when statement");
	}
	@Then("Sample then statement")
	public void sample_then_statement() {
		System.out.println("Sample then statement");
	}
}
