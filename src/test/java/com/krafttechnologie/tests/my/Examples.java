package com.krafttechnologie.tests.my;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

public class Examples {

    WebDriver driver;

    @BeforeClass
    public void before(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void after(){
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {


    }
}
