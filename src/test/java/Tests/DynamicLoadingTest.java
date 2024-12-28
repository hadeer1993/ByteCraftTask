package Tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.DynamicLoadingPage;

public class DynamicLoadingTest extends TestBase {

    @BeforeTest
    public void chooseDynamicLoading() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        InternetTest internetTest = new InternetTest();
        internetTest.UserCanSelectDynamicLoading();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void userCanSelectExample2() throws InterruptedException {
        DynamicLoadingPage.ClickExamble2();
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
