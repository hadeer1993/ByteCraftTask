package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InternetPage extends PageBase {

    public InternetPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


    @FindBy(xpath="//*[@id=\"content\"]/ul/li[18]/a")
	static WebElement UbloadFilebtn;
    
    
    @FindBy(xpath="//*[@id=\"content\"]/ul/li[14]/a")
	static WebElement DynamicLoadingbtn;

    public static void SelectUploadFile() {
        UbloadFilebtn.click();
    }
    
    public static void SelectDynamicLoading() {
    	DynamicLoadingbtn.click();
    }
}
