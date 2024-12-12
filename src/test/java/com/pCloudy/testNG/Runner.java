package com.pCloudy.testNG;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import com.pCloudy.Controller.Allurelogging;
import com.pCloudy.Controller.Environment;
import com.pCloudy.TestCase.*;
import com.pCloudy.Utils.EnvironmentUtility;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Runner {

	AppiumDriverLocalService service;
	AppiumDriver<WebElement> driver;

	@BeforeTest
	public void setUpSuite() throws Exception {

	}

	@Parameters({"deviceManufaturer"})
	@BeforeMethod
	public void prepareTest(String deviceManufaturer) throws IOException, InterruptedException {
		Environment.loadEnvFromUtility();
		System.out.println(deviceManufaturer);
		String cloud = EnvironmentUtility.getCloud();
		String baseUrl = "https://"+cloud;

		if(deviceManufaturer.toLowerCase().contains("apple")) {
			driver =Driver.createIOSDriver(deviceManufaturer, baseUrl);
		}

		else {
			driver=Driver.createAndroidDriver(deviceManufaturer, baseUrl);
		}

	}

	@Parameters({"deviceManufaturer"})
	@Test
	public void demoTest(String deviceManufaturer) throws Exception {
		try {
			if(deviceManufaturer.toLowerCase().contains("apple")) {
				TestCases.iosTestDemo(driver);
			}
			else {TestCases.androidTestDemo(driver);}
		}catch(Exception testCaseException) {
			Allurelogging.logFaliureScreenCapture(driver);
			throw new Exception(testCaseException);
		}
	}


	@AfterMethod
	public void endTest(ITestResult result) throws  IOException, InterruptedException {
 
		String status = result.isSuccess() ? "pass" : "Fail";
		System.out.println("status of the test case"+ status);
		driver.executeScript("pCloudy_setResult", status);
 
		driver.quit();
 
 
	}


}
