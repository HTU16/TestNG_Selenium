package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithId {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement text=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        text.sendKeys("CSS");

        WebElement searchButton=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();









    }
}
