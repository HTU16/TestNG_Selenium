package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithEnds {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        WebElement text= driver.findElement(By.cssSelector("input[id$='textbox'] "));
        text.sendKeys("API");

        Thread.sleep(2000);

        WebElement text1= driver.findElement(By.cssSelector("input[id$='-button'] "));
        text1.click();

        Thread.sleep(2000);
        driver.close();

    }
}
