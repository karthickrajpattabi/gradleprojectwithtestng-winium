package POM;

public class ReportPage {


    public String getMenu(String name){
        return String.format("//app-navigation//ul/li/a[normalize-space(text())='%s']",name);
    }

    public String getReportsTab(String name){
        return String.format("//div[@id='card_main']//ul[@role='tablist']/li/a[normalize-space(text())='%s']",name);
    }
}
