package Tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.GooglePage;
import Pages.InternetPage;

public class InternetTest extends TestBase {

    @BeforeTest
    public void OpenChrome() throws InterruptedException {
    	driver.navigate().to("https://the-internet.herokuapp.com/");
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public static void UserCanSelectUploadFile() throws InterruptedException {
        InternetPage.SelectUploadFile();

    }
    
    
    @Test(priority = 2)
    public static void UserCanSelectDynamicLoading() throws InterruptedException {
        InternetPage.SelectDynamicLoading();

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