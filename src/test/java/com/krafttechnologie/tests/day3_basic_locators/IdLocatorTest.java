package com.krafttechnologie.tests.day3_basic_locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {           //alt gr + # ile bulunur..
    public static void main(String[] args) throws InterruptedException {

        Faker faker=new Faker();


        WebDriver driver=WebDriverFactory.getDriver("chrome");
    driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();   // sekmeyi otomatik  tam ekran yapar.*****************

       WebElement inputUserName=driver.findElement(By.id("userName"));        //atamak istediğimiz yeri seciyoruz .siteden incele kısmı # şeklinde
         // inputUserName.sendKeys("HTU");                                   //kendimiz atamak istersek bu sekilde yapıyoruz
        inputUserName.sendKeys(faker.name().firstName());                    //faker seklinde olursa otomatik sistem bize atama yapıyor.

          WebElement inputEmail= driver.findElement(By.id("userEmail"));    //atamak istediğimiz yeri seciyoruz .siteden incele kısmı # şeklinde
         // inputEmail.sendKeys("ittihatveterakki@osmanli.com");             //kendimiz atamak istersek bu sekilde yapıyoruz
        inputEmail.sendKeys(faker.internet().emailAddress());          //faker seklinde olursa otomatik sistem bize atama yapıyor.


        Thread.sleep(2000);


    }



}
