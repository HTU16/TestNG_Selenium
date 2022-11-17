package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeClass
    public void setUP() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }

    @Test

    /*
        Selenium ile cozemedigimiz bazi sorunlarda javascript executor kullanarak
        cozebiliriz. Bu sorunlar neler olabilir ? : clicking, sendkeys, scroll down or
         scroll up
        JavascriptExecutor bir interface oldugu icin new kullanarak yeni bir obje
        olusturamiyoruz.bu nedenle driver i casting yaparak kullaniyoruz
     */

    public void clickWithJS() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement button= driver.findElement(By.linkText("Elemental Selenium"));


        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                +"arguments[0].click()",button);
        Thread.sleep(7000);

        System.out.println("Title :" + js.executeScript("return document.title;").toString());
        System.out.println("Url :" + js.executeScript("return document.URL;").toString());

        String CurrentWindowHandle= driver.getWindowHandle();
        Set<String> windowhandles=driver.getWindowHandles();

        for(String handle: windowhandles){

            if(!handle.equals(CurrentWindowHandle)){
                driver.switchTo().window(handle);


            }

        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String expectedUrl="http://elementalselenium.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


    }

    @Test
    public void typeWithJS(){

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement firstname= driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
        WebElement lastname=driver.findElement(By.xpath("//input[@placeholder='Enter Last name']"));


        JavascriptExecutor js= (JavascriptExecutor) driver;

        String name="Ali";
        String surname="Veli";

        js.executeScript("arguments[0].setAttribute('value', '" + name + "')", firstname);
        js.executeScript("arguments[0].setAttribute('value', '" + surname + "')", lastname);

    }

    @Test
    public  void  scrollDownAndUp() throws InterruptedException {

        driver.get("https://www.krafttechnologie.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,1200)");                     //sekmeyi aşağı yukarı getirip götürür..
        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,-1200)");
    }

    }

