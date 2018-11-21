package Steps;

import Framework.TestHooks;
import PageObjects.PlayStoreHomePage;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PlayStoreTest extends TestHooks {

    private PlayStoreHomePage playStoreHomePage;

    @BeforeMethod(groups = "regression")
    public void setUp(ITestContext context) {
        playStoreHomePage = new PlayStoreHomePage(context);
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "Procountor"},
        };
    }

    @Test(dataProvider = "test1", groups = {"regression", "Appium"})
    public void testName(String appName) {
        playStoreHomePage.searchInStore(appName);
        playStoreHomePage.chooseProcountorApp();
        playStoreHomePage.downloadProcountorApp();
    }
}