package Steps;

import PageObjects.PlayStoreHomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import javafx.print.PageLayout;
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

import java.net.MalformedURLException;
import java.net.URL;

public class AlaMaKota {


    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;
    private PlayStoreHomePage playStoreHomePage;

    @BeforeMethod
    public void setUp(ITestContext context) throws MalformedURLException {
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"), getCapabilities());
        wait = new WebDriverWait(driver, 30)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        playStoreHomePage = new PlayStoreHomePage(context);
    }


    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Procountor"},
                { "Kalambury"},
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

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "7.0");
        capabilities.setCapability("deviceName", "Huawei P9 lite");
        capabilities.setCapability("udid", "BUC4C16617002452");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);

        return capabilities;
    }
}
