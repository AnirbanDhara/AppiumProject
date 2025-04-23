package com.anirbandhara;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {

    @Test
    public void appiumBasicsTest() throws MalformedURLException, InterruptedException {

        // Code to start appium server automatically
        AppiumDriverLocalService serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://usr//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        serviceBuilder.start();

        // Set capabilities for Android emulator and API Demos app
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554") // or your emulator name from `adb devices`
                .setApp("C://Users//Anirban//Documents//UIAutomation//AppiumProject//src//test//resources//ApiDemos-debug.apk")
                .setAutomationName("UiAutomator2");

        // Connect to Appium server
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        // Launch the API Demos app
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, options);
        System.out.println("API Demos app launched successfully!");

        // Optional: wait or perform actions
        Thread.sleep(5000);

        // Actual Automation Code

        // To quit the session
        driver.quit();
        serviceBuilder.close();



    }
}
