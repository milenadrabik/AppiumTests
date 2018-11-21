package Steps;

import Framework.TestHooks;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("All framework testing test")
@Feature("Szkolenie Appium")

public class FakeTests extends TestHooks {

    @Test(groups = {"smoke","regression"})
    @Story("This is fake test")
    @Description("This test will never fail")
    public void fakeSmokeTest() {
    }

    @Test(groups = {"regression"})
    public void fakeRegressionTest() {
    }
}
