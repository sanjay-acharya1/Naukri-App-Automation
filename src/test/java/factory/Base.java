package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

// z Z
public class Base {
	
	static WebDriver driver;
	static Properties prop;
	
	public static WebDriver initializeBrowser() throws IOException {
		
		prop = getProperties();
		String executionEnv = prop.getProperty("execution_env");
		String browser = prop.getProperty("browser").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("local")) {
			switch(browser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Git-clone-repo\\NaukriAppAutomation\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "edge":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Git-clone-repo\\NaukriAppAutomation\\driver\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			default: 
				System.out.println("Browser name is incorrect.!!!");
				driver=null;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Properties getProperties() throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
	
}
