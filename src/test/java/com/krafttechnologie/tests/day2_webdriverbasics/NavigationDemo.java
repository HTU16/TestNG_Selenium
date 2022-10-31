package com.krafttechnologie.tests.day2_webdriverbasics;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // go to google
        // go to facebook
        // back to google

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();  //polly

        driver.get("https://www.google.com.tr");


        //selenium sekronizasyon sorunu yaratır(pc hızı,internet etkiler)

        Thread.sleep(3000);   // wait 3 second here then move on- 3 saniye bekleyip öyle hareket edecek


        //navigate to web sitelere erişim için kullanılır..*********************
        driver.navigate().to("https://www.facebook.com");

      Thread.sleep(3000);

        //goes back to previous page- önceki sayfaya dön
        driver.navigate().back();    // back: önceki sayfaya geri getirir.*******************************

        Thread.sleep(3000);

        driver.navigate().forward();    // forward: ileri demek sonraki sayfaya götürür.

        Thread.sleep(2000);

        //refresh to webpage- sayfayı yenile
        driver.navigate().refresh();




    }
}
