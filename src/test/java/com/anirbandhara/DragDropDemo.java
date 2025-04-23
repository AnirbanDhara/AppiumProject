package com.anirbandhara;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DragDropDemo extends BaseTest{
    @Test
    public void testDragAndDropDemo() throws InterruptedException {
        WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
        views.click();

        WebElement dragAndDrop = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
        dragAndDrop.click();

        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 618,
                "endY", 554
        ));

        Thread.sleep(2000);

        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();

        Assert.assertEquals(result,"Dropped!");
    }
}
