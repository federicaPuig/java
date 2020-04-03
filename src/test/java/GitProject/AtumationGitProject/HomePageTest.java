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
	
	
	
/*	@Test
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
	@Test (dataProvider = "thirdPartyFormData")
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
		
		String ErrorTextFirstForm = hp.getErrorMessageText().getText();
		AssertJUnit.assertEquals("An error occurred, please contact us at (855) 746-5551 or email loanservicing@joinmosaic.com", ErrorTextFirstForm);
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
	
	//Creating the data provider for first form
			@DataProvider
			public Object[][] thirdPartyFormData(){
				
				Object[][] data = new Object[3][2];
				
				data[0][0] = "Federica";
				data[0][1] = "Puig";
				
				data[1][0] = "Ramón";
				data[1][1] = "Gómez";
				
				data[2][0] = "Pablo";
				data[2][1] = "Boing";
				
				return data;
				
			}*/
	
	
	@Test
	public void mosaicCustomerFormSelected () throws IOException{
		
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getRadioButtonTwo().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getCustomInfoText()));
		AssertJUnit.assertTrue(hp.getCustomInfoText().isDisplayed());
		
		String obtainedTextSecondForm = hp.getCustomInfoText().getText();
		AssertJUnit.assertEquals("Customer Information", obtainedTextSecondForm);
		log.info("Text for customer form is displayed");
		
	}
	
	
		
		
	@Test (dataProvider = "mosaicCustomerFormData")
	public void mosaicCustomerForm (String username, String lastname) throws IOException{
			
		wait = new WebDriverWait(driver, 30);
		initialize();
		log.info("Navigate to homep page");
		hp= new HomePage(driver);
		hp.getRadioButtonTwo().click();
		hp.getCustomerEmail().sendKeys("federica@test.com");
		hp.getCustomerFirstName().sendKeys(username);
		hp.getCustomerLastName().sendKeys(lastname);
		hp.getZipMosaicForm().sendKeys("45215");
		hp.getCustomerCity().sendKeys("Cedar Rapids");
		hp.getCustomerSnn().sendKeys("4452");
		hp.getCustomerCaseReference().sendKeys("1236");
		hp.getSubmitButton().click();
		wait.until(ExpectedConditions.visibilityOf(hp.getErrorMessageText()));
		AssertJUnit.assertTrue(hp.getErrorMessageText().isDisplayed());
			
		String ErrorTextSecondForm = hp.getErrorMessageText().getText();
		AssertJUnit.assertEquals("Customer not found, please contact us at (855) 746-5551 or email loanservicing@joinmosaic.com", ErrorTextSecondForm);
		log.info("Form was submitted");
			
		}	
		
		//Creating the data provider for second form
				@DataProvider
				public Object[][] mosaicCustomerFormData(){
					
					Object[][] data = new Object[2][2];
					
					data[0][0] = "Federica";
					data[0][1] = "Puig";
					
					data[1][0] = "Ramón";
					data[1][1] = "Gómez";
					
					return data;
					
			}
				
				
		
	
}
   
