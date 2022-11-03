package Listener;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Base64;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getThrowable() != null){
            Allure.addAttachment("exception error",result.getThrowable().getMessage());
            Allure.addAttachment("screenshots", Screenshots.takeScreenShotAsFile().getPath());
            screenshot("test_1_2_3");
            Allure.addAttachment("Url", WebDriverRunner.url());

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
    @Attachment(value = "screenshot: {0}", type = "image/png")
    public byte[] screenshot(String name){
        String Screenshotas64 = Selenide.screenshot(OutputType.BASE64);
        return Base64.getDecoder().decode(Screenshotas64);
    }
}
