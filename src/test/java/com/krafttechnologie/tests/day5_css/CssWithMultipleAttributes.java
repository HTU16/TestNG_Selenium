package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithMultipleAttributes {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement text= driver.findElement(By.cssSelector("input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b'][type='text']"));
        text.sendKeys("DataBase");

        Thread.sleep(2000);

        WebElement text1= driver.findElement(By.cssSelector("div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F'"));
        text1.click();

        Thread.sleep(2000);
        driver.close();

    }
}
