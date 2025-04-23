package com.anirbandhara;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest{

    @Test
    public void testWifiSettingsName() throws MalformedURLException, InterruptedException {

       // Starting App
        //configureAppium();
        System.out.println("API Demos app launched successfully!");

        // Optional: wait or perform actions
        Thread.sleep(5000);

        // Actual Automation Code
        //Xpath, id, classname ( Selenium 'By' class) || accessibilityId, androidUIAutomator ( 'AppiumBy' class)
        WebElement preference_element = driver.findElement(AppiumBy.accessibilityId("Preference"));
        preference_element.click();

        WebElement pref_depend = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        pref_depend.click();

        WebElement wifi_checkbox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        wifi_checkbox.click();

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
        WebElement wifi_textbox = driver.findElement(AppiumBy.className("android.widget.EditText"));
        wifi_textbox.sendKeys("Anirban Wifi");

        Thread.sleep(2000);

        //cancel button is clicked
        cancel_btn.click();

        System.out.println("cancel button clicked");

    }
}
