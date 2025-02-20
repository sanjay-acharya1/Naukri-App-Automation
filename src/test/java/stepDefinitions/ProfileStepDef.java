package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;

public class ProfileStepDef {
	
	WebDriver driver;
	LoginPage lp;
	ProfilePage pp;
	WebDriverWait wait=new WebDriverWait(Base.getDriver(),Duration.ofSeconds(15));
	
	
	@Given("I navigate to Naukri Application")
	public void i_navigate_to_naukri_application() {
	   lp = new LoginPage(Base.getDriver());
	   lp.selectLogin();

	}

	@Given("Enter the credentials")
	public void enter_the_credentials() {
	    lp.enterCredentials("170906461s@gmail.com", ".manipal.MIT@11");
	    lp.clickLogin();
	}

	@When("I navigate to my profile")
	public void i_navigate_to_my_profile() {
	    pp = new ProfilePage(Base.getDriver());
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("View")));
	    pp.clickViewProfile();

	}

	@When("Click on career profile")
	public void click_on_career_profile() {
		
	    pp.clickCareerProfileLink();
	    pp.editCareerProfile();
	    boolean res = pp.verifyFormIsPresent();
	    assertTrue(res);
	}

	@When("I click on {string}, select\\/deselect a {string}")
	public void i_click_on_select_deselect_a(String string, String string2) throws InterruptedException{
		Thread.sleep(2000);
	   pp.clickForLocation();
	   boolean isSelected = pp.isLocationSelected();
	   if(isSelected) {
		   pp.addLocation();
	   }else {
		   pp.addLocation();
		   pp.addLocation();
	   }
	   pp.clickOutSideLoc();
	}

	@When("Click on save button")
	public void click_on_save_button() {
	    pp.clickSaveButton();
	}

	@Then("I should see profile updated as {string}")
	public void i_should_see_profile_updated_as(String exp_msg) {
	    String msg = pp.verifyProfileUpdateStatus();
	    assertTrue(msg.contains(exp_msg));
	}

	@When("Click on update in resume")
	public void click_on_in_resume() {
	    pp.clickUpdateResumeLink();
	}

	@When("I click on resume that has to be uploaded")
	public void i_click_on_resume_that_has_to_be_uploaded() {
	    pp.uploadResume();
	}

	@Then("Resume should be uploaded successfully")
	public void resume_should_be_uploaded_successfully(){
	   String name = pp.validateResumeName();
	   assertTrue(name.contains("Sanjay_Resume_QE.pdf"));
	}

}
