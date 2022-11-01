package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbsoluteXpath {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://www.krafttechexlab.com/");
        driver.manage().window().maximize();     //sekmeyi tam ekran yapar..
        
        String actualText=driver.findElement(By.xpath("html/body/main/div/h1")).getText();

        System.out.println("actualText = " + actualText);
    }
}
