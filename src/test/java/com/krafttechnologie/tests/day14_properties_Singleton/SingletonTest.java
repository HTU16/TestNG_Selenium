package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

//    @Test
//    public void test1(){
//       // Singleton singleton=new Singleton();
//
//        String driver1=Singleton.getInstance();
//        String driver2=Singleton.getInstance();
//
//        System.out.println(driver1);
//        System.out.println(driver2);
//
//    }
//
//    @Test
//    public void test2() {
//       // WebDriver driver = WebDriverFactory.getDriver("chrome");
//
//        WebDriver driver = Driver.get();
//
//        driver.get(ConfigurationReader.get("url"));
//    }

    @Test
    public void test3() throws InterruptedException {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void test4() {
        //WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.co.uk/");


    }
}