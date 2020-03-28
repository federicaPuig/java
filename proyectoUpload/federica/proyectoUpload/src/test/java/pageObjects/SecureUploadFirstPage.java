package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GetProperties;

public class SecureUploadFirstPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public GetProperties properties = new GetProperties();

    public SecureUploadFirstPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".slds-text-heading_small.slds-text-align_center")
    public WebElement message;

    @FindBy(xpath = "//*[@placeholder='Representative first name']")
    WebElement firstNameField;


    public void initialization(String name, String lastname) {

        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));

        driver.findElement(By.xpath("//*[text() = 'Mosaic Customer']"));
        driver.findElement(By.xpath("//*[@placeholder='Representative first name']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@placeholder='Representative last name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//*[@placeholder='Enter the loan ID']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@placeholder='Enter the installation city']")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@placeholder='Enter the installation zipcode (5 digits)']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test@test.com");

        WebElement submitButton = driver.findElement(By.tagName("button"));

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(message));



    }


}
