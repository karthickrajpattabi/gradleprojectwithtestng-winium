package Login;

import Base.Basetest;
import CustomError.CustomError;
import Listener.TestListener;
import POM.LoginPage;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class Login extends Basetest {

    @BeforeSuite
    public void setup() {
        setupDriver();

    }
    @Step("Launch browser")
    @BeforeTest
    public void launchbrowser() {
        openurl("XXXXXXX");
        log.info("browser launched");
    }
    @Step("Login User")
    @Description("verify user login")
    @Test
    public void logintest() throws CustomError {
        LoginPage lp = new LoginPage();
        lp.initialize();
        lp.login("XXXXXX","XXXXXXX");
        log.info("user logged on");

            if (getElement(lp.getTenantList("XXXXXX")) != null) {
                Assert.assertEquals(getElement(lp.getTenantList("XXXXX")).getText(), "XXXXX", "expected tenant not found");
            } else {
                throw new CustomError("unable to login");
            }

    }

    @AfterTest
    public void quit(){
        WebDriverRunner.closeWebDriver();
    }
}
