package com.pCloudy.Utils;

public class EnvironmentUtility {
	private static String username;
	private static String apiKey;
	private static String appiumVersion;
	private static String androidApplication;
	private static String iosApplication;
	private static String androidAppPackage;
	private static String androidAppActivity;
	private static String iosBundleId;
	private static String cloud;
	private static String projectName;
	private static String buildName;
	private static String testName;
	private static String tagName;

	public static void initializeEnv() {
		username = System.getProperty("username", "");
		apiKey = System.getProperty("apiKey", "");
		appiumVersion = System.getProperty("appiumVersion", "");
		androidApplication = System.getProperty("androidApplication", "");
		iosApplication = System.getProperty("iosApplication", "");
		androidAppPackage = System.getProperty("androidAppPackage", "");
		androidAppActivity = System.getProperty("androidAppActivity", "");
		iosBundleId = System.getProperty("iosBundleId", "");
		cloud = System.getProperty("cloud", "");
		projectName = System.getProperty("projectName", "");
		buildName = System.getProperty("buildName", "");
		testName = System.getProperty("testName", "");
		tagName = System.getProperty("tagName", "");

	}




	public static String getUsername() {
		return username;
	}

	public static String getApiKey() {
		return apiKey;
	}

	public static String getAppiumVersion() {
		return appiumVersion;
	}

	public static String getAndroidApplication() {
		return androidApplication;
	}

	public static String getIosApplication() {
		return iosApplication;
	}

	public static String getAndroidAppPackage() {
		return androidAppPackage;
	}

	public static String getAndroidAppActivity() {
		return androidAppActivity;
	}

	public static String getIosBundleId() {
		return iosBundleId;
	}

	public static String getCloud() {
		return cloud;
	}
	
	public static String getProjectName() {
		return projectName;
	}
	
	public static String getBuildName() {
		return buildName;
	}
	
	public static String getTestName() {
		return testName;
	}
	
	public static String getTagName() {
		return tagName;
	}
}


