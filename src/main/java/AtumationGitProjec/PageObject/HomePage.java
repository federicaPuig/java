package AtumationGitProjec.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

public class HomePage {
	
	public WebDriver driver;
	
	//RadioButtons
	private By radioButtonOne = By.xpath("//span[contains(text(),'Third Party')]");
	private By radioButtonTwo = By.xpath("//span[contains(text(),'Mosaic Customer')]");
	
	//Third Party Contact Information TEXT
	private By thirdPartyText = By.xpath("//h2[contains(text(),'Third Party Contact Information')]");
	
	//Customer Information TEXT
	private By customInfoText = By.xpath("//h2[@class='slds-text-heading_small']");
	
	
	private By thirdPartyName = By.xpath("//*[@placeholder='Representative first name']");
	private By thirdPartyLastName = By.xpath("//*[@placeholder='Representative last name']");
	private By thirdPartyPhone = By.xpath("//*[@placeholder='Representative phone number']");
	private By thirdPartyEmail = By.xpath("//*[@placeholder='Representative email']");
	
	//Mosaic Customer’s Loan Information
	
	private By customerLoanID = By.xpath("//*[@placeholder='Enter the loan ID']");
	private By installationCity = By.xpath("//*[@placeholder='Enter the installation city']");
	private By zip = By.xpath("//*[@placeholder='Enter the installation zipcode (5 digits)']");
	private By caseReference = By.name("zip");
	
	//Mosaic Customer Information
	
	private By customerEmail = By.xpath("//*[@placeholder='Enter your email']");
	private By customerFirstName = By.xpath("//*[@placeholder='Enter your first name']");
	private By customerLastName = By.xpath("//*[@placeholder='Enter your last name']");
	private By customerCity = By.xpath("//*[@placeholder='Enter your city']");
	private By customerSnn = By.xpath("//*[@placeholder='Enter your last 4 SSN numbers']");
	private By customerCaseReference = By.name("case");
	
	//Submit button
	
	private By submitButton = By.xpath("//button[@class='slds-button slds-button_brand']");
	
	private By errorMessageText = By.xpath("//div[@class='slds-text-heading_small slds-text-align_center slds-text-color_error']");
	//div[contains(text(),'An error occurred, please contact us at (855) 746-5551 or email loanservicing@joinmosaic.com')]
	
	public HomePage (WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getRadioButtonOne() {
		return driver.findElement(radioButtonOne);
	}
	
	
	public WebElement getRadioButtonTwo() {
		return driver.findElement(radioButtonTwo);
	}
	
	public WebElement getThirdPartyText() {
		return driver.findElement(thirdPartyText);
		
	}
	
	public WebElement getCustomInfoText() {
		return driver.findElement(customInfoText);
	}
	
	public WebElement getThirdPartyName() {
		return driver.findElement(thirdPartyName);
	}
	
	public WebElement getThirdPartyLastName() {
		return driver.findElement(thirdPartyLastName);
	}

	public WebElement getThirdPartyPhone() {
		return driver.findElement(thirdPartyPhone);
	}

	public WebElement getThirdPartyEmail() {
		return driver.findElement(thirdPartyEmail);
	}
	
	public WebElement getCustomerLoanID() {
		return driver.findElement(customerLoanID);
	}
	
	public WebElement getInstallationCity() {
		return driver.findElement(installationCity);
	}
	
	public WebElement getZip() {
		return driver.findElement(zip);
	}
	
	public WebElement getCaseReference() {
		return driver.findElement(caseReference);
	}
	
	public WebElement getCustomerEmail() {
		return driver.findElement(customerEmail);
	}
	
	public WebElement getCustomerFirstName() {
		return driver.findElement(customerFirstName);
	}
	
	public WebElement getCustomerLastName() {
		return driver.findElement(customerLastName);
	}
	
	
	public WebElement getCustomerCity() {
		return driver.findElement(customerCity);
	}

	public WebElement getCustomerSnn() {
		return driver.findElement(customerSnn);
	}	
	
	public WebElement getCustomerCaseReference() {
		return driver.findElement(customerCaseReference);
	}
		  
	public WebElement getSubmitButton() {
		return driver.findElement(submitButton);
	}
	
	public WebElement getErrorMessageText() {
		return driver.findElement(errorMessageText);
	}
		
		
	}
	
	
	

