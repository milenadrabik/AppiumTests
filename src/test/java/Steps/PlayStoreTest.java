package Steps;

import Framework.Capabilities;
import PageObjects.PlayStoreHomePage;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayStoreTest {


    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;
    private PlayStoreHomePage playStoreHomePage;

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException, FileNotFoundException {
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), setUpCapabilities(context));
        wait = new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        playStoreHomePage = new PlayStoreHomePage(context);


    }

//    @BeforeMethod
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


    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Procountor"},
        };
    }

    @Test(dataProvider = "test1")

    public void testName(String appName) throws MalformedURLException {

        playStoreHomePage.searchInStore(appName);
        playStoreHomePage.chooseProcountorApp();
        playStoreHomePage.downloadProcountorApp();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
