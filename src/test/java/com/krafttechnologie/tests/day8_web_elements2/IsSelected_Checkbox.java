package com.krafttechnologie.tests.day8_web_elements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsSelected_Checkbox {

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
        driver.get("https://www.krafttechexlab.com/forms/checkbox");

        WebElement checkbox1= driver.findElement(By.cssSelector("#gridCheck1"));
        WebElement checkbox2= driver.findElement(By.cssSelector("#gridCheck2"));

        //isSelected metodu  elementin secilip secilmedigini assert etmek icin kullaniriz.*********


        System.out.println("checkbox1 = " + checkbox1.isSelected());
        System.out.println("checkbox2 = " + checkbox2.isSelected());

        Assert.assertFalse(checkbox1.isSelected(),"FAIL");
        Assert.assertTrue(checkbox2.isSelected(),"FAIL");

        //checkbox turu elementler bize birden fazla secme imkani tanir.***********************

        Thread.sleep(2000);
        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"FAIL");
        Assert.assertTrue(checkbox2.isSelected(),"FAIL");

        Thread.sleep(2000);

    }
}
