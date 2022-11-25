package com.krafttechnologie.tests;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {              //before after metodlar burada bulunur. tekrar tekrar yazmamış oluyoruz
                                      //her test basında buralar calışır ona göre ilerler..
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setUP() {

        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(Driver.get(),15);
        driver.manage().window().maximize();
        actions=new Actions(driver);

    }

    @AfterTest      //aftermethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
