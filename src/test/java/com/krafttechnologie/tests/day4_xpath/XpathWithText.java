package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithText {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.krafttechexlab.com/");

       // String text=driver.findElement(By.xpath("//li[text()='All Users Profile'] ")).getText();     //normal locate etme
       // String text=driver.findElement(By.xpath("//li[.text()='All Users Profile'] ")).getText();    //.  locate etme
        String text=driver.findElement(By.xpath("//*[text()='All Users Profile'] ")).getText();  // * locate etme  hepsini taratır
        System.out.println("text = " + text);


    }
}
