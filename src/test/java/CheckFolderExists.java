import java.io.File;

public class CheckFolderExists {
	public void checkOrCreateScreenshotFolder() {
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
