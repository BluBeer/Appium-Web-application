package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Avi Sahney
 *
 */
public class Calctest2 {

	static AppiumDriver<MobileElement> driver = null;

	
	public static void main(String[] args) {
		try {
			openWebapp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	public static void openWebapp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		;
		cap.setCapability("deviceName","Galaxy M20");
		cap.setCapability("udid", "32013bbf120d462b");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("noReset", true);       
		cap.setCapability("fullReset", false);
		cap.setCapability("applicationCacheEnabled", true);
		cap.setCapability("appPackage","com.android.chrome");
		cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
		cap.setCapability("setWebContentsDebuggingEnabled", true);

		URL url = new  URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		MobileElement chec;
		WebDriverWait wait = new WebDriverWait(driver,10);
		chec = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/menu_button")));
		chec.click();
		chec = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/menu_item_text")));
		chec.click();
		
		Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
        	System.out.println(context);
        }
        driver.context("WEBVIEW_chrome"); 
        System.out.println(driver.getContext());
		try {
			driver.get("http://google.com");
		  
		} finally {
			
        }
		
		
		System.out.println("Application Started...");
	}
	
 
}
