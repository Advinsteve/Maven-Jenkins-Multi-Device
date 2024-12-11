package com.pCloudy.TestNG;

import java.io.File;

import org.testng.IExecutionListener;
import org.testng.ITestContext;

public class TestNGConfig implements IExecutionListener {

    @Override
    public void onExecutionStart() {
    	 // Define the results directory
        String resultsDir = "custom-allure-results";
        // Create a unique subdirectory using timestamp
        String uniqueDir = System.getProperty("user.dir") + File.separator + resultsDir + File.separator + System.currentTimeMillis();
        
        // Ensure the directory exists
        File dir = new File(uniqueDir);
        if (!dir.exists()) {
            boolean isCreated = dir.mkdirs(); // Create directories if they don’t exist
            if (isCreated) {
                System.out.println("Directory created at: " + uniqueDir);
            } else {
                System.err.println("Failed to create directory at: " + uniqueDir);
            }
        }

        // Set the property for Allure
        System.setProperty("allure.results.directory", uniqueDir);
        System.out.println("Allure results directory set to: " + uniqueDir);
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test execution finished.");
    }
}
