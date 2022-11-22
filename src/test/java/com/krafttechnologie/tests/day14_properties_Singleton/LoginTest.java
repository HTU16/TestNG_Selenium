package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {

//    WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver= Driver.get();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//
//
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    @Test
    public void openBrowserUsingConfigurationReader() {


        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);

        //  actions.
        // wait.until(ExpectedConditions.visibilityOf(locator))
    }
}
