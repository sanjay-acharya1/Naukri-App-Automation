package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BaseClass {
	
	String filePath = "C:\\Users\\User\\Desktop\\Sanjay_Resume_QE.pdf";

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='view-profile-wrapper']")
	WebElement viewProfileButton;
	
	@FindBy(xpath = "//span[@class='text' and text()='Career profile']")
	WebElement careerProfileLink;
	
	@FindBy(xpath = "//div[@class='desiredProfile']//span[text()='editOneTheme']")
	WebElement editCareerProfile;
	
	@FindBy(id = "desiredProfileForm")
	WebElement careerProfileForm;
	
	@FindBy(xpath = "//input[@id='locationSugg']")
	WebElement locationPreference;
	
	@FindBy(xpath = "//*[text()='Bengaluru']/i")
	WebElement locationAdd;
	
	@FindBy(xpath = "//span[@class='lbl' and contains(text(),'Preferred work location (Max 10)')]")
	WebElement clickOutside;
	
	@FindBy(id = "saveDesiredProfile") 
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='mod-date']//span[contains(text(),'Today')]")
	WebElement lastProfileUpdateStatus;
	
	@FindBy(xpath = "//a[text()='Update']")
	WebElement updateResume;
	
	@FindBy(xpath = "//div[@class='resume-name-inline']/div")
	WebElement resumeName;
	
	public void clickViewProfile() {
		viewProfileButton.click();
	}
	
	public void clickCareerProfileLink() {
		careerProfileLink.click();
	}
	
	public void editCareerProfile() {
		editCareerProfile.click();
	}
	
	public boolean verifyFormIsPresent() {
		boolean res = careerProfileForm.isDisplayed();
		return res;
	}
	
	public void clickForLocation() {
		locationPreference.click();
	}
	
	public void addLocation() {
		locationAdd.click();
	}
	
	public void clickOutSideLoc() {
		clickOutside.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String verifyProfileUpdateStatus() {
		String msg = lastProfileUpdateStatus.getText();
		return msg;
	}
	
	public void clickUpdateResumeLink() {
		updateResume.click();
	}
	
	public void uploadResume() {
		updateResume.sendKeys(filePath);
	}
	
	public String validateResumeName() {
		String name = resumeName.getText();
		return name;
	}
	
	public boolean isLocationSelected() {
		boolean isSelected = locationAdd.isSelected();
		return isSelected;
	}
	
}
