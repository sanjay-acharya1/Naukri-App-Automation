package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	WebDriver driver;
	Properties prop;

	@Before
	public void setup() throws IOException {
		driver = Base.initializeBrowser();
		prop=Base.getProperties();
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
