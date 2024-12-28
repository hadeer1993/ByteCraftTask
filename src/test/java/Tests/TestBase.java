package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    public static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "/Downloads";

    // Chrome Options
    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);

        // Specify the debugging port for WebSocket communication
        options.addArguments("--remote-debugging-port=9222");  // Debugging port

        // Optional: Run Chrome in headless mode
        // options.addArguments("--headless");

        return options;
    }

    @BeforeTest
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        // Only initialize the driver once
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().driverVersion("131.0.6778.205").setup(); // Specify the correct ChromeDriver version
                driver = new ChromeDriver(chromeOption()); // Use the global driver variable
            }
        }

        // Maximize window and set up timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterClass
    public void stopDriver() {
        if (driver != null) {
            driver.quit(); // Quit the driver after tests
        }
    }

    @AfterMethod
    public void captureFailure(ITestResult result) {
        try {
            // Ensure the 'screenshots' folder exists
            checkOrCreateScreenshotFolder();

            // Capture and save the screenshot if the test failed
            if (result.getStatus() == ITestResult.FAILURE) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path sourcePath = screenshot.toPath(); // Convert File to Path
                Path destinationPath = Paths.get("screenshots", result.getName() + ".png");

                // Use java.nio.file.Files to copy
                Files.copy(sourcePath, destinationPath);

                System.out.println("Screenshot saved for test: " + result.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to ensure the 'screenshots' folder exists
    private void checkOrCreateScreenshotFolder() {
        String folderPath = "screenshots";

        // Create a File object for the folder
        File folder = new File(folderPath);

        // Check if the folder exists
        if (!folder.exists()) {
            System.out.println("The 'screenshots' folder does NOT exist. Creating it now...");
            boolean created = folder.mkdirs(); // Create the folder
            if (created) {
                System.out.println("The 'screenshots' folder was successfully created.");
            } else {
                System.out.println("Failed to create the 'screenshots' folder.");
            }
        } else {
            System.out.println("The 'screenshots' folder already exists.");
        }
    }
}
