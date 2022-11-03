package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginPage {


    public  String  getTenantList(String name){
        return String.format("//ul/li/*[normalize-space(text())='%s']",name);
    }
    public void initialize(){
        Selenide.$x("//form//input[@formcontrolname='username']").shouldBe(Condition.visible, Duration.ofSeconds(30));
        Selenide.$x("//form//input[@formcontrolname='password']").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public void login(String username,String password){
        if(!username.isEmpty() && !password.isEmpty()){
            Selenide.$x("//form//input[@formcontrolname='username']").clear();
            Selenide.$x("//form//input[@formcontrolname='username']").setValue(username);
            Selenide.$x("//form//input[@formcontrolname='password']").click();
            Selenide.$x("//form//input[@formcontrolname='password']").clear();
            Selenide.$x("//form//input[@formcontrolname='password']").setValue(password);
            Selenide.$("form button[type ='submit']").click();
        }
    }
}
