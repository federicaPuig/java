package GitProject.AtumationGitProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AtumationGitProjec.PageObject.HomePage;
import resources.Base;


public class HomePageTest extends Base {
	
	public WebDriverWait wait;
	
	
	//initialize logger
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	HomePage hp;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = inittializeDriver(); //it will open the browser
		driver.get(prop.getProperty("url"));
		log.info("Navigate to homep page");
	}
	
	@Test
	public void thirdPartyFormSelected(){
		
		wait = new WebDriverWait(driver, 30);
		
		hp= new HomePage(driver);
		hp.getRadioButtonOne().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getThirdPartyText()));
		AssertJUnit.assertTrue(hp.getThirdPartyText().isDisplayed());
		log.info("Text is displayed");
	}
	
	/*@Test
	public void thirdPartyForm (){
		
		wait = new WebDriverWait(driver, 30);
		
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys("Federica");
		hp.getThirdPartyLastName().sendKeys("Puig");
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		hp.getCustomerLoanID().sendKeys("12453");
		hp.getInstallationCity().sendKeys("Cedar Rapids");
		hp.getZip().sendKeys("45215");
		hp.getSubmitButton().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getErrorMessageText()));
		AssertJUnit.assertTrue(hp.getErrorMessageText().isDisplayed());
		log.info("Form was submitted");
		
	}*/
	
	
	/*@Test
	public void thirdPartyFormIncomplete (){
		
		wait = new WebDriverWait(driver, 30);
		
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys("Federica");
		hp.getThirdPartyLastName().sendKeys("Puig");
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		AssertJUnit.assertFalse(hp.getSubmitButton().isEnabled());
		log.info("Submit button is not enable");
		
	}*/
	
	@Test
	public void thirdPartyFormFieldValidation (){
		
		wait = new WebDriverWait(driver, 30);
		
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys("Federica");
		hp.getThirdPartyLastName().sendKeys("Puig");
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		hp.getCustomerLoanID().click();
		hp.getInstallationCity().sendKeys("Cedar Rapids");
		wait.until(ExpectedConditions.visibilityOf(hp.getBlankFieldErrorMessage()));
		AssertJUnit.assertTrue(hp.getBlankFieldErrorMessage().isDisplayed());
		log.info("Error message appear sucessfully");
		
		
	}
	

	
}
   
