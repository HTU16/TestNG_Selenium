package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        //two ways to get text from web elements
        //1. getText() --> it will work %99 work and it will return string
        //2. getAttribute("attribute name") --> second way of getting text especially input box


        String email="mike@gmail.com";



        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");



        Thread.sleep(1000);


        WebElement emailInputBox=driver.findElement(By.id("email"));
        //emailInputBox.sendKeys(email);

        Thread.sleep(2000);

        String value=emailInputBox.getAttribute("class");  // class represent attribute name of email input box

        System.out.println("value = " + value);

        Thread.sleep(2000);


        driver.close();



    }
}
