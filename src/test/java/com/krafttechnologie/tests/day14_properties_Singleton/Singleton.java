package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton {
    //singleton class will have private constructor
    // it means other classes can NOT create an object of this class

    Singleton(){

    }

    private  static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str is null, assigning a value to it");
            str="chrome";
        }else{
            System.out.println("it has value, just returning it");
        }

        return  str;

    }

    @Test
    public void test2(){

//        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
//        WebDriver driver2 = WebDriverFactory.getDriver("chrome");

        WebDriver driver1= Driver.get();  // driver1 run first and now driver not null
        WebDriver driver2= Driver.get();


        driver1.get("https://www.google.com.tr/?hl=tr");
        driver2.findElement(By.name("q")).sendKeys("laz  ziya");


    }


}
