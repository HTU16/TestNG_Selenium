package com.krafttechnologie.tests.day8_web_elements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAttribute {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        WebElement yseBtn=driver.findElement(By.cssSelector("#yesRadio"));

        //Attribute ait degeri dondurmek icin kullaniriz.
        System.out.println("yseBtn.getAttribute(\"type\") = " + yseBtn.getAttribute("type"));
        System.out.println("yseBtn.getAttribute(\"name\") = " + yseBtn.getAttribute("name"));

        driver.findElement(By.xpath("//label[.='Yes']")).click();

        Thread.sleep(3000);
    }
}
