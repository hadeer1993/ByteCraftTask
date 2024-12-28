package Tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Pages.DynamicLoadingPage;
import Pages.Example2Page;

public class Example2Test extends TestBase {

    Example2Page example2Page;

    @BeforeTest
    public void openExample2Screen() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
        dynamicLoadingPage.ClickExamble2(); // Navigate to Example 2
        Thread.sleep(5000); // Temporary sleep, replace with explicit wait if possible
        example2Page = new Example2Page(driver);
    }

    @Test(priority = 1)
    public void userCanClickStart() throws InterruptedException {
        example2Page.clickStart();
        Thread.sleep(5000); // Wait for "Hello World" to appear; prefer explicit wait if feasible
        String actualText = example2Page.getHelloWorldText();
        Assert.assertEquals(actualText, "Hello World", "The text displayed does not match 'Hello World'");
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

