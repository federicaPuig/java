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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AtumationGitProjec.PageObject.HomePage;
import resources.Base;


public class HomePageTest extends Base {
	
	public WebDriverWait wait;
	
	
	//initialize logger
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	HomePage hp;
	
	
	
	@Test
	public void thirdPartyFormSelected() throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getRadioButtonOne().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getThirdPartyText()));
		AssertJUnit.assertTrue(hp.getThirdPartyText().isDisplayed());
		log.info("Text is displayed");
	}
	
	//Calling the data provider
	@Test (dataProvider = "getData")
	public void thirdPartyForm (String username, String lastname) throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys(username);
		hp.getThirdPartyLastName().sendKeys(lastname);
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		hp.getCustomerLoanID().sendKeys("12453");
		hp.getInstallationCity().sendKeys("Cedar Rapids");
		hp.getZip().sendKeys("45215");
		hp.getSubmitButton().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getErrorMessageText()));
		AssertJUnit.assertTrue(hp.getErrorMessageText().isDisplayed());
		
		String ErrorText = hp.getErrorMessageText().getText();
		AssertJUnit.assertEquals("An error occurred, please contact us at (855) 746-5551 or email loanservicing@joinmosaic.com", ErrorText);
		log.info("Form was submitted");
		
	}
	
	
	@Test 
	public void thirdPartyFormIncomplete () throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys("Federica");
		hp.getThirdPartyLastName().sendKeys("Puig");
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		AssertJUnit.assertFalse(hp.getSubmitButton().isEnabled());
		log.info("Submit button is not enable");
		
	}
	
	@Test 
	public void thirdPartyFormFieldValidation () throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getThirdPartyName().sendKeys("Federica");
		hp.getThirdPartyLastName().sendKeys("Puig");
		hp.getThirdPartyPhone().sendKeys("55522255");
		hp.getThirdPartyEmail().sendKeys("test@gmail.com");
		hp.getCustomerLoanID().click();
		hp.getInstallationCity().sendKeys("Cedar Rapids");
		wait.until(ExpectedConditions.visibilityOf(hp.getBlankFieldErrorMessage()));
		AssertJUnit.assertTrue(hp.getBlankFieldErrorMessage().isDisplayed());
		
		String FieldErrorText = hp.getBlankFieldErrorMessage().getText();
		AssertJUnit.assertEquals("Complete this field.", FieldErrorText);
		log.info("Error message appear successfully");
		
	}
	
	
	@Test
	public void mosaicCustomerFormSelected () throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getRadioButtonTwo().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getCustomInfoText()));
		AssertJUnit.assertTrue(hp.getCustomInfoText().isDisplayed());
		
		String obtainedText = hp.getCustomInfoText().getText();
		AssertJUnit.assertEquals("Customer Information", obtainedText);
		log.info("Text for customer form is displayed");
		
	}
	
	
	//Creating the data provider
		@DataProvider
		public Object[][] getData(){
			
			Object[][] data = new Object[3][2];
			
			data[0][0] = "Federica";
			data[0][1] = "Puig";
			
			data[1][0] = "Ramón";
			data[1][1] = "Gómez";
			
			data[2][0] = "Pablo";
			data[2][1] = "Boing";
			
			return data;
			
		}
		
		
	

	
}
   
