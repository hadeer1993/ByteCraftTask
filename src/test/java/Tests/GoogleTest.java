package Tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.GooglePage;

public class GoogleTest extends TestBase {

    private GooglePage googlePage;

    // Open Chrome Page
    @BeforeTest
    public void OpenChrome() throws InterruptedException {
        // Maximize and navigate without opening a new driver
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void userCanSearchInGoogle() throws InterruptedException {
        googlePage.Search("Selenium WebDriver");
        Thread.sleep(5000);

        // Validate page title
        Assert.assertTrue(driver.getTitle().contains("Selenium"), "Title does not contain 'Selenium'");
        Thread.sleep(5000);
    }
    
    @AfterMethod
    public void captureFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot, Paths.get("screenshots/" + result.getName() + ".png").toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
