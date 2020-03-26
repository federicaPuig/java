package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Base {
	
	protected WebDriver driver;
	public Properties prop;
	
	
	// create a method to return Webdriver 'driver' where this is used for test execution
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebDriver inittializeDriver() throws IOException{
		
		
		// set the System Property
		prop = new Properties();
		//System.getProperty("user.dir") this will allow anyone to access to the particular path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		
		
		//this is to control browser from maven (command) //mvn test -Dbrowser=chrome
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.out.println("Launching google chrome browser");
			System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Usuario\\chromedriver.exe ");
			//next 2 lines fix the issue: [1582906052.854][SEVERE]: Timed out receiving message from renderer: 0.100
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			driver = new ChromeDriver(options);
		}else if (browserName.equals("firefox")) {
			System.out.println("Launching firefox browser");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Usuario\\Documents\\geckodriver.exe ");
			driver = new FirefoxDriver();
		}else if (browserName.equals("ie")){
			System.out.println("Launching ie browser");
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Usuario\\Documents\\MicrosoftWebDriver.exe ");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	//Take screenshot method
	public void getScreenshot(String result) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\test\\"+result+"screenshot.png"));
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
