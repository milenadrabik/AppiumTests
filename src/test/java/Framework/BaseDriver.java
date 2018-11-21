package Framework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseDriver {
    public void setDriverContext(ITestContext context) throws MalformedURLException, FileNotFoundException {
        context.setAttribute("driver", initialiseDriver(context));
        context.setAttribute("wait", initialiseWait((AndroidDriver<AndroidElement>) context.getAttribute("driver")));
    }

    private FluentWait<WebDriver> initialiseWait(AndroidDriver<AndroidElement> driver) {
        return new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);
    }

    private Object initialiseDriver(ITestContext context) throws MalformedURLException, FileNotFoundException {
        return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), setUpCapabilities(context));

    }

    public DesiredCapabilities setUpCapabilities(ITestContext context) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/capabilitiesData.json"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Capabilities capabilities = gson.fromJson(br,Capabilities.class);

        DesiredCapabilities capabilities1 = new DesiredCapabilities();
        capabilities1.setCapability("BROWSER_NAME", capabilities.getBROWSER_NAME());
        capabilities1.setCapability("VERSION", capabilities.getVERSION());
        capabilities1.setCapability("deviceName", capabilities.getDevicename());
        capabilities1.setCapability("udid", capabilities.getUdid());
        capabilities1.setCapability("platformName", capabilities.getPlatformName());
        capabilities1.setCapability("appPackage", capabilities.getAppPackage());
        capabilities1.setCapability("appActivity", capabilities.getAppActivity());
        capabilities1.setCapability("autoGrantPermissions",capabilities.getAutoGrantPermissions());
        return capabilities1;
    }
}