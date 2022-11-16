package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeClass
    public void setUP() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
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


    }
}
