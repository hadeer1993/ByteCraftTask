package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Example2Page extends PageBase {

    public Example2Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "start")
    WebElement startBtn;

    @FindBy(id = "finish")
    WebElement helloWorldTxt;

    public void clickStart() {
        startBtn.click();
    }

    public String getHelloWorldText() {
        waitForElementToBeVisible(helloWorldTxt);
        return helloWorldTxt.getText();
    }

    private void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
