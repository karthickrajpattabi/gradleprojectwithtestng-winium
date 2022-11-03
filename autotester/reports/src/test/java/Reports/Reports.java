package Reports;


import Base.Basetest;
import Listener.TestListener;
import POM.LoginPage;
import POM.ReportPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
@Listeners({TestListener.class})
public class Reports {
    Basetest bt = null;
    @BeforeSuite
    public void setup (){
        bt = new Basetest();
        bt.setupDriver();



    }
    @BeforeTest
    public void login (){
        bt.openurl("XXXXXXX");
        LoginPage lp = new LoginPage();
        lp.login("CCCCCC","DDDDDDD");
        Selenide.$x(lp.getTenantList("XXXXX")).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();


    }
    @Test
    public void navigateToReports(){
        ReportPage rp = new ReportPage();
        Selenide.$x(rp.getMenu("Reports")).shouldBe(Condition.visible,Duration.ofSeconds(5)).click();
        Selenide.switchTo().frame(Selenide.$x("//iframe[@title='Reports']").shouldBe(Condition.visible, Duration.ofSeconds(60)));
        Selenide.$x(rp.getReportsTab("My Reports")).shouldBe(Condition.visible,Duration.ofSeconds(5)).click();
        Assert.assertEquals("tested","tested");
        Selenide.switchTo().defaultContent();

    }
    @AfterTest
    public void quit(){
        WebDriverRunner.closeWebDriver();
    }



}
