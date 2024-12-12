package com.pCloudy.Controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import com.pCloudy.Utils.ScreenShot;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;

public class Allurelogging {


	public static void logScreenCapture(AppiumDriver<WebElement> driver,String screenshotName) throws IOException {

		byte[] screenshotBytes = ScreenShot.captureScreenShotsAllure(driver);
		Allure.addAttachment(screenshotName, "image/png", new ByteArrayInputStream(screenshotBytes), "png");
	}

	public static void logFaliureScreenCapture(AppiumDriver<WebElement> driver) throws IOException {

		byte[] screenshotBytes = ScreenShot.captureScreenShotsAllure(driver);
		Allure.addAttachment("Faliure", "image/png", new ByteArrayInputStream(screenshotBytes), "png");
	}

}