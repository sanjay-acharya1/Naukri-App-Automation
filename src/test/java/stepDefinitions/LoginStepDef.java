package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class LoginStepDef {

	WebDriver driver;
	LoginPage lp;

	@Given("I want to land in Naukri Application")
	public void i_want_to_land_in_naukri_application() {
		lp = new LoginPage(Base.getDriver());
		lp.selectLogin();
	}

	@When("I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void i_enter_username_as_and_password_as(String un, String pass) {
		lp.enterCredentials(un, pass);
	}

	@When("clcik the Login button")
	public void clcik_the_login_button() {
		lp.clickLogin();
	}

	@Then("user should land in home page")
	public void user_should_land_in_home_page() {
		System.out.println(lp.myProfileName());
		boolean res = lp.verifyLogoIsPresent();
		assertTrue(res);
	}

}
