package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //20 saniye olarak yazdık ama yeteri kadar bekledi..
        //bunu kullanmamız cok daha mantıklı.. makul olan süre 10-15 sn arası..

    }

    @AfterMethod
    public void tearDown() {

        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();


        WebElement message =driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");
    }
}
