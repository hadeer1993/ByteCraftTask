package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends PageBase {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "APjFqb")
    static WebElement searchBox;

    public static void Search(String query) {
        sendText(searchBox, query);
    }
}
