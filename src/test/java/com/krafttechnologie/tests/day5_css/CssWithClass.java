package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithClass {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement text= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        text.sendKeys("TestNg");

        Thread.sleep(2000);

        WebElement text1= driver.findElement(By.cssSelector(".nav-search-submit-text.nav-sprite.nav-progressive-attribute"));
        text1.click();

        Thread.sleep(2000);
        driver.close();

    }
}
