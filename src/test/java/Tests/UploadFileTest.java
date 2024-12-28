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

import Pages.UploadFilePage;


public class UploadFileTest extends TestBase {
	@BeforeTest
	public void ChooseUploadFile() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        InternetTest internettest = new InternetTest();
        internettest.UserCanSelectUploadFile();
        Thread.sleep(5000);

    }
	
	@Test(priority = 1)
    public void userCanUploadFile() throws InterruptedException {
        UploadFilePage.ClickUploadFile();
        Thread.sleep(5000);
        
        UploadFilePage.UploadFile("file:///Users/hp/new-eclipse-workspace/task/Images/download.jpeg");
	     Thread.sleep(1000);
	

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
