package com.pCloudy.testNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pCloudy.Controller.Environment;
import com.pCloudy.Controller.Json;
import com.pCloudy.Utils.EnvironmentUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Driver {

	static AppiumDriver<WebElement> driver;

	// Method to load environment variables


	public static AppiumDriver<WebElement> createAndroidDriver(String deviceManufacturer, String baseUrl) throws MalformedURLException {

		Environment.loadEnvFromUtility();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		commonCapabilities(capabilities);
		capabilities.setCapability("pCloudy_ApplicationName", EnvironmentUtility.getAndroidApplication());
		capabilities.setCapability("pCloudy_DeviceManufacturer", deviceManufacturer);
		capabilities.setCapability("newCommandTimeout", 6000);
		capabilities.setCapability("launchTimeout", 900000);
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appPackage", EnvironmentUtility.getAndroidAppPackage());
		capabilities.setCapability("appActivity", EnvironmentUtility.getAndroidAppActivity());
		capabilities.setCapability("uiautomator2ServerLaunchTimeout", 300000); // 300 seconds
		capabilities.setCapability("uiautomator2ServerInstallTimeout", 300000); // 300 seconds
		capabilities.setCapability("adbExecTimeout", 300000); // 300 seconds
		System.out.println(baseUrl);
		Json.jsonFormatter(capabilities);
		driver = new AndroidDriver(new URL(baseUrl + "/appiumcloud/wd/hub"), capabilities);

		return driver;
	}

	public static AppiumDriver<WebElement> createIOSDriver(String deviceManufacturer, String baseUrl) throws MalformedURLException {
		Environment.loadEnvFromUtility();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		commonCapabilities(capabilities);
		capabilities.setCapability("pCloudy_ApplicationName", EnvironmentUtility.getIosApplication());
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("pCloudy_DeviceManufacturer", deviceManufacturer);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("bundleId", EnvironmentUtility.getIosBundleId());
		capabilities.setCapability("acceptAlerts", true);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("wdaLaunchTimeout", 300000); // 300 seconds
		capabilities.setCapability("wdaConnectionTimeout", 300000); // 300 seconds
		System.out.println(baseUrl);
		Json.jsonFormatter(capabilities);
		driver = new IOSDriver(new URL(baseUrl + "/appiumcloud/wd/hub"), capabilities);

		return driver;
	}

	public static void commonCapabilities(DesiredCapabilities capabilities ) {
		Environment.loadEnvFromUtility();
		
		capabilities.setCapability("pCloudy_Username", EnvironmentUtility.getUsername());
		capabilities.setCapability("pCloudy_ApiKey", EnvironmentUtility.getApiKey());
		capabilities.setCapability("pCloudy_DurationInMinutes", 30);
		capabilities.setCapability("appiumVersion", EnvironmentUtility.getAppiumVersion());
		capabilities.setCapability("project", EnvironmentUtility.getProjectName());
		capabilities.setCapability("build", EnvironmentUtility.getBuildName());
		capabilities.setCapability("name", EnvironmentUtility.getTestName());
		capabilities.setCapability("tag", EnvironmentUtility.getTagName());
		
	}

}
