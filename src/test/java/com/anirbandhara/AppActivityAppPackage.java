package com.anirbandhara;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppActivityAppPackage extends BaseTest{

    @Test
    public void intentActionDemo() throws InterruptedException {

        // 1. open cmd, "adb devices"
        // 2. "adb shell"
        // 3. dumpsys window windows | grep -i "mCurrentFocus"
        //  mCurrentFocus=Window{ac8638 u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}
        // appPackage ---> io.appium.android.apis
        // appActivity ---> io.appium.android.apis.preference.PreferenceDependencies


        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        ((JavascriptExecutor)driver).executeScript("mobile: startActivity",
                ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        WebElement wifi_checkbox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        wifi_checkbox.click();

        WebElement wifi_settings = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='WiFi settings']"));
        Assert.assertTrue(wifi_settings.isEnabled());
        wifi_settings.click();


        Thread.sleep(2000);

        // widget title is 'Wifi settings'
        WebElement wifi_title = driver.findElement(AppiumBy.id("android:id/alertTitle"));
        String alert_title = wifi_title.getText();
        Assert.assertEquals(alert_title, "WiFi settings");

        //Copy to clipboard, paste from clipboard
        driver.setClipboardText("Anirban Wifi");
        WebElement wifi_textbox = driver.findElement(By.id("android:id/edit"));
        wifi_textbox.sendKeys(driver.getClipboardText());

        Thread.sleep(2000);

        // Performing KeyBoard Action "Back"
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        Thread.sleep(2000);

        // Performing KeyBoard Action "Home"
        driver.pressKey(new KeyEvent(AndroidKey.HOME));


    }
}
