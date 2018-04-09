
package com.appiumAndroid.classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



public class GmailTest {
    private AppiumDriver driver;
    private WebDriverWait webDriverWait;
    List<MobileElement> listOfResults;
    String resName;
    MobileElement element;
     String v;
     String para;
     String asun;
     String mensa;
     String ipp;
     String u,p,a;

    @Before
    public void setup(String v, String ipp, String u, String p, String a) throws MalformedURLException {
        this.ipp=ipp;
        this.v=v;
        this.u=u;
        this.p=p;
        this.a=a;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");                
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, v);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy s8+");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, u);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, p);//"com.google.android.gm"
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, a);//"com.google.android.gm.ConversationListActivityGmail"
        driver = new AndroidDriver(new URL("http://"+ipp+":4723/wd/hub"), desiredCapabilities);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    @Test
    public void testGmail(String para, String asun, String mensa) {
        this.asun=asun;
        this.mensa=mensa;
        this.para=para;
        // How to click the first element in the search result
        driver.findElementById("com.google.android.gm:id/compose_button").click();
        driver.findElementById("com.google.android.gm:id/to").sendKeys(para + " \n");
        driver.findElementById("com.google.android.gm:id/subject").sendKeys(asun +"\n");
        driver.findElementById("com.google.android.gm:id/composearea_tap_trap_bottom").sendKeys(mensa +"\n");
        driver.findElementById("com.google.android.gm:id/send").click();
        System.out.println("Se envio tu mensaje");
        
 }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
