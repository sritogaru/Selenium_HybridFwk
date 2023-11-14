package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import testBase.BaseClass;


public class TakeScreenshots extends BaseClass {
	
	 public static void screenshottake(WebDriver driver, String pic)  {
		
		TakesScreenshot ts = (TakesScreenshot)driver; 
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			File destfile = new File(".//screenshots/pic.png");
			
				try {
					FileUtils.copyFile(srcfile, destfile);
					System.out.println("Screenshot saved successfully");
				} catch (IOException e) {
					System.out.println("Exception while taking screenshot "+e.getMessage());
					
				}
			
			}

	
	 }

