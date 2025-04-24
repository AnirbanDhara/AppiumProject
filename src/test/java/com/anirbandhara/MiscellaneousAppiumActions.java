package com.anirbandhara;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class MiscellaneousAppiumActions extends BaseTest{

    @Test
    public void Miscellaneous() throws MalformedURLException, InterruptedException {

       // Starting App
        //configureAppium();
        System.out.println("API Demos app launched successfully!");

        // Optional: wait or perform actions
        Thread.sleep(2000);

        // Actual Automation Code
        //Xpath, id, classname ( Selenium 'By' class) || accessibilityId, androidUIAutomator ( 'AppiumBy' class)
        WebElement preference_element = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference_element.click();

        WebElement pref_depend = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        pref_depend.click();


        // Landscape Mode
        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        WebElement wifi_settings = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout"));
        Assert.assertTrue(wifi_settings.isEnabled());

        wifi_settings.click();

        Thread.sleep(2000);

        // Widget is visible, cancel button is present, widget title is 'Wifi settings'
        WebElement wifi_settings_widget = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout"));
        Assert.assertTrue(wifi_settings_widget.isDisplayed());

        WebElement wifi_title = driver.findElement(By.id("android:id/alertTitle"));
        String alert_title = wifi_title.getText();
        Assert.assertEquals(alert_title, "WiFi settings");

        WebElement cancel_btn = driver.findElement(By.id("android:id/button2"));
        Assert.assertTrue(cancel_btn.isDisplayed());

        // wifi name is set
//        WebElement wifi_textbox = driver.findElement(AppiumBy.className("android.widget.EditText"));
//        wifi_textbox.sendKeys("Anirban Wifi");

        //Copy to clipboard, paste from clipboard
        driver.setClipboardText("Anirban Wifi");
        WebElement wifi_textbox = driver.findElement(By.id("android:id/edit"));
        wifi_textbox.sendKeys(driver.getClipboardText());
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER)); // Performing action on Android native key

//        Thread.sleep(2000);
//
        //cancel button is clicked
        cancel_btn.click();

        Thread.sleep(2000);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(2000);

        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}
