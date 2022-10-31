package com.krafttechnologie.tests.day1_automationintro_frameworksetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        /*
        1.pomxl e yüklediğimiz webDriver manager kütüphanesinden chrome u hazır hale getirmesini isteyeceğiz.
        2.webdriver classında driver i hazır hale getirmesini isteyeceğiz.
        3.driver a testini yapacağımız web sayfasına bizi götürmesini isteyeceğiz.
        */

        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver=new ChromeDriver();

        driver.get("https://www.youtube.com/watch?v=qolmz4FlnZ0");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());

        String expectedTitle="Lana Del Rey - Doin' Time (Official Music Video) - YouTube";

        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Başlık beklediği gibi geldi. Doğrulama GECTİ");
        }else{
            System.out.println("Baslik beklendigi gibi GELMEDI. Dogrulama GECMEDI");
        }


    }
}





