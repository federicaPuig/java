package tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.SecureUploadFirstPage;
import utilities.GetProperties;

public class SecureUploadTest {

    WebDriver driver;
    GetProperties properties = new GetProperties();
    String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH_76");
    String siteUrlSecureUpload = properties.getString("SITE_URL_SECURE_UPLOAD_SITE");

    SecureUploadFirstPage secureUploadFirstPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", chromeDriverUrl);
        driver = new ChromeDriver();
        secureUploadFirstPage = new SecureUploadFirstPage(driver);
    }

    @Test
    public void testSecureUploadThirdPartyPageWithInvalidCaseIdTest() {
        driver.get(siteUrlSecureUpload);

        try {
            secureUploadFirstPage.initialization("Ale", "Smith");

            Thread.sleep(12000);
        } catch ( Exception e) {
            System.out.println("ERRROR: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
