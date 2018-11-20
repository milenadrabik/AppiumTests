package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;

public class PlayStoreHomePage {

    private AndroidDriver<AndroidElement> driver;
    private FluentWait<WebDriver> wait;

    private final By searchBox = By.id("search_box_idle_text");
    private final By searchBoxInput = By.id("search_box_text_input");
    private final By icon = By.id("icon");
    private final By procountorApp = By.xpath("//*[contains(@resource-id,'li_title')][@text='Procountor Key']");
    private final By searchResults = By.id("li_title");
    private final By procountorAppView = By.id("title_title");
    private final By downloadAppButton = By.xpath("//*[contains(@text,'ZAINSTALUJ')]");

    public PlayStoreHomePage(ITestContext context) {
        this.driver = (AndroidDriver<AndroidElement>)context.getAttribute("driver");
        this.wait = (FluentWait<WebDriver>)context.getAttribute("wait");
    }

    public void searchInStore(String apkToFind) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).click();
        driver.findElement(searchBoxInput).sendKeys(apkToFind);
        wait.until(ExpectedConditions.visibilityOfElementLocated(icon));
        driver.findElement(icon).click();
    }

    public void chooseProcountorApp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
        driver.findElement(procountorApp).click();
    }

    public void downloadProcountorApp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(procountorAppView));
        driver.findElement(downloadAppButton).click();
    }
}