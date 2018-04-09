package com.appiumAndroid.classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class GmapTest {
    private AppiumDriver driver;
    private WebDriverWait webDriverWait;
    List<MobileElement> listOfResults;
    String resName;
    MobileElement element;
    String v, b, ipp, u,p,a;
   
    
    
   

    @Before
    public void setup(String v, String ipp, String u, String p, String a) throws MalformedURLException, IOException {
       this.v=v;
       this.ipp=ipp;
       this.u=u;
       this.p=p;
       this.a=a;
       
       
        final String commands[] = {"adb", "devices"};
        
        
        Process process = new ProcessBuilder(commands).start(); 
        
        InputStream is = process.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);

String line;
while ((line = br.readLine()) != null) {
  System.out.println(line);
}
       
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, v);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, u);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, p); //"com.google.android.apps.maps"
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, a);//"com.google.android.maps.MapsActivity"
        driver = new AndroidDriver(new URL("http://"+ipp+":4723/wd/hub"), desiredCapabilities);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testGmap( String b) throws IOException {
this.b=b;
        
        // How to click the first element in the search result
        
        driver.findElementById("com.google.android.apps.maps:id/search_omnibox_text_box").click(); //este es para dispositivos fisicos
        //driver.findElementById("com.google.android.apps.gmm:id/search_omnibox_text_box").click(); //este es para dispositvos virtuales
        driver.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text").sendKeys(b+ " \n"); //dispositivos fisicos
       // driver.findElementById("com.google.android.apps.gmm:id/search_omnibox_edit_text").sendKeys(b+ " \n");//vistuales
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.maps:id/recycler_view")));// fisico
       // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.apps.gmm:id/recycler_view"))); //virtual
       File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(scrFile, new File("/home/alopez/Descargas/archivo.png"));
        listOfResults = driver.findElementsById("com.google.android.apps.maps:id/title");// fisico
        //listOfResults = driver.findElementsById("com.google.android.apps.gmm:id/title"); //virtual
        for (MobileElement e : listOfResults) {
            System.out.println("Restaurant Name : " + e.getText().toString() + "\n");
        }
        resName = listOfResults.get(0).getText();
        listOfResults.get(0).click();
        element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + resName + "\");"));
        Assert.assertTrue(element.isDisplayed());
       

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
