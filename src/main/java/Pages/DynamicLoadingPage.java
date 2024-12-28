package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends PageBase {

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 @FindBy(xpath="//*[@id=\"content\"]/div/a[2]")
 	static WebElement Examble2btn;


 public static void ClickExamble2() {
	 Examble2btn.click();
 }

}
