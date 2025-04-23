package com.anirbandhara;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SwipeDemo extends BaseTest{
    @Test
    public void testSwipeDemo() throws InterruptedException {
        WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
        views.click();

        WebElement gallery = driver.findElement(AppiumBy.accessibilityId("Gallery"));
        gallery.click();

        WebElement photos = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']"));
        photos.click();

        // Before Swipe, first image is in focus
        WebElement image_1 = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
       Assert.assertEquals(new String(image_1.getAttribute("focusable")),"true");
//
        WebElement image_2 = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[2]"));
        Assert.assertEquals(new String(image_2.getAttribute("focusable")),"false");

        WebElement image_3 = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[3]"));
        Assert.assertEquals(new String(image_3.getAttribute("focusable")),"false");

        // After Swipe, second image is in focus
       swipeAction(image_1, "left");
       //swipeAction(image_2,"left");

        Assert.assertEquals(new String(image_1.getAttribute("focusable")),"false");
//        Assert.assertEquals(new String(image_2.getAttribute("focusable")),"false");
//        Assert.assertEquals(new String(image_3.getAttribute("focusable")),"true");

    }
}
