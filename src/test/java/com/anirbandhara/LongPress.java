package com.anirbandhara;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LongPress extends BaseTest{
    @Test
    public void longPressGestureTest() throws InterruptedException {
        WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
        views.click();

        WebElement expandableLists = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Expandable Lists']"));
        expandableLists.click();

        WebElement customAdapter = driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter"));
        customAdapter.click();

        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        // Long Press on 'People Names'
        longPressAction(peopleNames);

        Thread.sleep(2000);

        WebElement sample_menu = driver.findElement(By.id("android:id/title"));
        Assert.assertEquals(sample_menu.getText(),"Sample menu");
        Assert.assertTrue(sample_menu.isDisplayed());
    }
}
