package com.pCloudy.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class ScreenShot {
	static String folder_name;
	static DateFormat df;
	static String screenshotName;
	
	public static void captureScreenShots(AppiumDriver<WebElement> driver) throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Date format for screenshot file name
        df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //copy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }
	
	
	public static byte[] captureScreenShotsAllure(AppiumDriver<WebElement> driver) throws IOException {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		String formattedDateTime = currentDateTime.format(formatter);
		String randomName = RandomStringUtils.randomAlphanumeric(4);
		screenshotName = randomName + "_" + formattedDateTime;
		folder_name = "screenshot";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		new File(folder_name).mkdir();

		String filePath = folder_name + "/" + screenshotName + ".png";
		Files.copy(screenshotFile.toPath(), new File(filePath).toPath());

		// Return screenshot as byte array for direct attachment
		return Files.readAllBytes(screenshotFile.toPath());
	}
}
