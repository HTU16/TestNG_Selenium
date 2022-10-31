package com.krafttechnologie.tests.day2_webdriverbasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        //task open chrome and navigate to  https://www.krafttechnologie.com/
        //get page title

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        //gettting title with selenium- selenium ile başlık alma

        String title=driver.getTitle();
        System.out.println("title:" +title);

        //get the url with from browser - url alma
        String currenturl=driver.getCurrentUrl();

        System.out.println("currenturl = " + currenturl);

        //get the source off page- sayfadan kaynak alma
        String source= driver.getPageSource();

        System.out.println("source = " + source);

    }
}
