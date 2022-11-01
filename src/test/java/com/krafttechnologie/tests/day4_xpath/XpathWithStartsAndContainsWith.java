package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithStartsAndContainsWith {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchBox =driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));
        searchBox.sendKeys("selenium");  //arama yerini bulduk html de, sonra oraya selenium yazdırma talimatı yolladık..

        WebElement searchbtn= driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));
        searchbtn.click();  //tıklama yapar (login)

        Thread.sleep(5000);
     driver.close();

    }
}
