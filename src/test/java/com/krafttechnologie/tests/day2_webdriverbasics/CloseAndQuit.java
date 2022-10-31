package com.krafttechnologie.tests.day2_webdriverbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        Thread.sleep(2000);

        driver.close(); //close current tab - gecerli sekmeyi kapatır.*************

        //go to chrome facebook

        driver=new ChromeDriver();    // yeni nesne oluşturmazsak ikinci acmak istediğimiz sayfa acılmaz..

        driver.get("https://www.facebook.com");

        Thread.sleep(2000);

        driver.quit();       //bütün sekmeleri kapatır..
    }
}
