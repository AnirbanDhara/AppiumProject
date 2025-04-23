package com.anirbandhara;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    public AppiumDriverLocalService serviceBuilder;
    public static AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        // Code to start appium server automatically
         serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://usr//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        serviceBuilder.start();

        // Set capabilities for Android emulator and API Demos app
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554") // or your emulator name from `adb devices`
                .setApp("C://Users//Anirban//Documents//UIAutomation//AppiumProject//src//test//resources//ApiDemos-debug.apk")
                .setAutomationName("UIAutomator2");

        // Connect to Appium server
        URL appiumServerUrl = new URL("http://127.0.0.1:4723");

        // Launch the API Demos app
         driver = new AndroidDriver(appiumServerUrl, options);
    }

    public void longPressAction(WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId()),
                "duration",2000);
    }

    public void scrollToEndAction()
    {
        boolean canScrollMore;
         do{
             canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                     "left", 100, "top", 100, "width", 200, "height", 200,
                     "direction", "down",
                     "percent", 3.0
             ));
         }while(canScrollMore);
    }

    public void scrollToElementAndClickAction()
    {

        boolean canScrollMore;
        do{
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while(canScrollMore);

        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Switches")).isDisplayed());
       // System.out.println("Switches is present");
        WebElement switches = driver.findElement(AppiumBy.accessibilityId("Switches"));
        switches.click();
    }

    public void swipeAction(WebElement element, String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 0.25
        ));
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
        serviceBuilder.close();
    }
}
