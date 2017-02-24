package utility;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="C:\\Users\\Freak\\Desktop\\newWorkspace\\maven\\ScreenShots+screenshotName+System.currentTimeMillis()+.png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
		
			System.out.println("Failed to capture screen shot");
		}
		return destination;
	}

}
