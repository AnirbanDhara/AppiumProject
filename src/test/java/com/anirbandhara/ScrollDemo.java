package com.anirbandhara;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ScrollDemo extends BaseTest{
    @Test
    public void testScrollDemo() throws InterruptedException {
        WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
        views.click();

        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        //scrollToEndAction();
        scrollToElementAndClickAction();



        Thread.sleep(2000);
    }
}
