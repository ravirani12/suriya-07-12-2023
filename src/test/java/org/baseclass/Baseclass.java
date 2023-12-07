package org.baseclass;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Baseclass {

	public static AndroidDriver driver;

	public static void getInstallApp(String deviceName, String platformName, String appLocation) {

		try {

			DesiredCapabilities dc = new DesiredCapabilities();

			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", platformName);
			dc.setCapability("app", appLocation);

			URL u = new URL("http://0.0.0.0:4723/wd/hub");

			driver = new AndroidDriver(u, dc);
			
			

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} catch (Exception e) {

		}
	}

	public static void getLaunchApp(String deviceName, String platformName, String platformVersion, String appPackage,
			String appActivity) {

		try {

			DesiredCapabilities dc = new DesiredCapabilities();

			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", platformName);
			dc.setCapability("platformVersion", platformVersion);
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);

			URL u = new URL("http://0.0.0.0:4723/wd/hub");

			driver = new AndroidDriver(u, dc);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} catch (Exception e) {

		}
	}

	public static void gettextSend(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public static void buttonClick(WebElement element) {
		element.click();
	}

	public static void getScrollOperation(String scrollText) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"'+scrollText+'\"));"));
	}

	public static void longpress(WebElement element) {

		TouchAction tc = new TouchAction(driver);
		tc.longPress(ElementOption.element(element)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.release().perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {

		TouchAction tc = new TouchAction(driver);
		tc.longPress(ElementOption.element(source)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(ElementOption.element(target)).release().perform();
	}

	public static void quitDriver() {
		driver.quit();
	}

}
