package com.krafttechnologie.tests.day3_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@gmail.com");

        //1.YOL
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("12345");

        //2. yol -LAZY WAY
        //  driver.findElement(By.name("password")).sendKeys("12345");



        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();     //login yaptırır.******

        Thread.sleep(2000);

        driver.close();






    }
}
