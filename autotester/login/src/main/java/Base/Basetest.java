package Base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.time.DurationUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class Basetest {
    public static final Logger log = LoggerFactory.getLogger("testexec");
    public void  setupDriver(){
        Allure.addAttachment("initialize log","setting up browser");
        SelenideLogger.addListener("allure",new AllureSelenide().screenshots(true));
        Allure.parameter("browser","chrome");
        WebDriverManager.chromedriver().setup();
        WebDriver wd = new ChromeDriver();
        WebDriverRunner.setWebDriver(wd);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public void openurl(String url){
        Selenide.open(url);


    }
    public SelenideElement getElement(String path){
        try{
            return Selenide.$x(path).shouldBe(Condition.visible);
        }catch (NoSuchElementException | ElementNotFound e){

            return null;
        }
    }


}
