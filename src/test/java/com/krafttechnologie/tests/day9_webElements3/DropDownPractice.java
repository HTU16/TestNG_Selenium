package com.krafttechnologie.tests.day9_webElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownPractice {

    /**
     * 1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
     * 2. DropDowns Menusunden SQL,TestNG ve CSS sec
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

       WebElement element1= driver.findElement(By.id("dropdowm-menu-1"));
       Select select=new Select(element1);
       select.selectByIndex(3);

       Thread.sleep(2000);

       WebElement element2= driver.findElement(By.id("dropdowm-menu-2"));
       Select select1=new Select(element2);
       select1.selectByIndex(2);

       Thread.sleep(1000);

       WebElement element3= driver.findElement(By.id("dropdowm-menu-3"));
       Select select2=new Select(element3);
        select2.selectByVisibleText("CSS");

    }
}
