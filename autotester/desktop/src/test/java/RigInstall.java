import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RigInstall {


    @Test
    public void installrig(){
    WebElement activeWindow=null;
        WiniumDriver wd =null;
        //stop winium desktop driver before start another session

        DesktopOptions options = new DesktopOptions(); // Initiate Winium Desktop Options
        options.setApplicationPath("D:\\autotester\\scripts\\riginstaller.bat"); // Set notepad application path


        try {
            wd = new WiniumDriver(new URL("http://localhost:9999"), options); // Start a winium driver
            WebDriverRunner.setWebDriver(wd);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        boolean isdisplayed = false;
        long startTime = System.currentTimeMillis();
            while ( !isdisplayed || (System.currentTimeMillis() - startTime) < 200000) {
                try {
                    WebElement actwindow = wd.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Window') and contains(@Name,'RigAgent')]"));
                    WebElement name = actwindow.findElement(By.xpath("//*[@AutomationId='1201']"));
                    if(name.isDisplayed()){
                        break;
                    }
                }catch (Exception e){

                }

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        WebElement actwindow = wd.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Window') and contains(@Name,'RigAgent')]"));
        WebElement name = actwindow.findElement(By.xpath("//*[@AutomationId='1201']"));
        name.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        name.sendKeys("summa");
        WebElement nxt1 = actwindow.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Next >')]"));
        nxt1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement nxt2 = actwindow.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Next >')]"));
        nxt2.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement nxt3 = actwindow.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Next >')]"));
        nxt3.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement cancel = actwindow.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Cancel')]"));
        cancel.click();
        WebElement yes = actwindow.findElement(By.xpath("//*[contains(@ControlType,'ControlType.Button') and contains(@Name,'Yes')]"));
        yes.click();
    }



}
