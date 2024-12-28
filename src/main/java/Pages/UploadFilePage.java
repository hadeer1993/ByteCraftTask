package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends PageBase {
	
	public UploadFilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


		@FindBy(id="file-upload")
    	static WebElement UbloadFilebtn;
        
        @FindBy(id="file-submit")
    	static WebElement Sumbitbtn;


    public static void ClickUploadFile() {
        UbloadFilebtn.click();
    }
    
    public static void UploadFile(String FilePath) {
    	UbloadFilebtn.sendKeys(FilePath);
    	}
    
    public static void ClickSubmit() {
        Sumbitbtn.click();
    }

}
