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
	
	@Test
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
		
	}
	
	
	@Test
	public void thirdPartyFormIncomplete (){
		
	}
	
	
	
	/*
	
	@Test
	//we need to pass what data we are going to use
	public void PageNavigationVisibility() throws IOException {
		
		//we call landingPage methods
		hp= new HomePage(driver);
		//Check if navBar is displayed
		AssertJUnit.assertTrue(hp.getNavBar().isDisplayed());
		log.info("Navigation bar is display");
	}
	
	@Test
	public void inputFormMenuElements() {
		
		hp.getInputFormMenu().click();
		
		
		/* WebElement dropdown = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]/following-sibling::ul[1]")); 
	      Ul select = new Ul(dropdown); 
	      java.util.List<WebElement> options = select.getOptions(); 
	     
	      for(WebElement item:options) { 
	      
	           System.out.println("Dropdown values are "+ item.getText());          
	         }*/
		
		
	/*	List <WebElement> elements = driver.findElements(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Input Forms')]/following-sibling::ul[1]"));
		System.out.println("La cantidad de elementos es de : " + elements.size());
		
		/*List <WebElement> elements = driver.findElements(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']"));
		
		  for (int i=0; i<elements.size(); i++){
	            log.info(elements.size());
	        }	*/
				
	//}
	
	
	/*  private int getNumberOfElements(List<WebElement> list) {
		
		  for (int i=0; i<list.size(); i++){
			  count = list.size();
	        }
		return count;
		  
		
	}*/

	/*public static int getNumberOfElements (WebDriver driver, ArrayList <Integer> list) {
		
		return list.size();
	}*/
	  
	 

		
	
	
}
   
