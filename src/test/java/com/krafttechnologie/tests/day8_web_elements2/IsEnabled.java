package com.krafttechnologie.tests.day8_web_elements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabled {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkbox= driver.findElement(By.cssSelector("#gridCheck3"));

        //isEnabled metodu elementin etkin/kullanilabilir olup olmadigini assert etmek icin kullaniriz..*************************

        System.out.println("checkbox.isEnabled() = " + checkbox.isEnabled());

        Assert.assertFalse(checkbox.isEnabled(),"FAIL");

        Thread.sleep(3000);

        WebElement checkbox2= driver.findElement(By.cssSelector("#gridCheck2"));
        System.out.println("checkbox2.isEnabled() = " + checkbox2.isEnabled());

        Assert.assertTrue(checkbox2.isEnabled(),"FAIL");
    }
}

