package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected Select select;
    protected Actions action;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void clearText(WebElement textbox) {
        textbox.clear();
    }

    protected static void sendText(WebElement textbox, String text) {
        textbox.sendKeys(text);
    }

    public void scrollToBottom() {
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
