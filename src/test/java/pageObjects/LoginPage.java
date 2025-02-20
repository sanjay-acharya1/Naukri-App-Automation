package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "login_Layer")
	WebElement login;
	
	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='name-wrapper']")
	WebElement myName;
	
	@FindBy(xpath = "//a[@class='nI-gNb-header__logo nI-gNb-company-logo']")
	WebElement logo;
	
	
	public void selectLogin() {
		login.click();
	}
	
	public void enterCredentials(String un, String pass) {
		userName.clear();
		userName.sendKeys(un);
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public String myProfileName() {
		String name = myName.getText();
		return name;
	}
	
	public boolean verifyLogoIsPresent() {
		boolean res = logo.isDisplayed();
		return res;
	}
	
}
