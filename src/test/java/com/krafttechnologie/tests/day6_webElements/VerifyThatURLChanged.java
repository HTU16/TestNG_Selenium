package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {


        /**  Class Task 2
         *         open chrome browser
         *          go to https://www.krafttechexlab.com/login
         *         enter email as mike@gmail.com
         *         enter password as 12345
         *         click login btn
         *         verify that Url has changed
         */

        String email="mike@gmail.com";
        String password="12345";


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");


        String expectedURL=driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);
        Thread.sleep(2000);


        WebElement emailInputBox=driver.findElement(By.id("email"));
        emailInputBox.sendKeys(email);

        //WebElement passwordInputBox=driver.findElement(By.id("yourPassword"));
        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);


        WebElement loginBtn=driver.findElement(By.cssSelector(".btn.btn-primary.w-100"));
        loginBtn.click();

        String actualURL=driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);
        Thread.sleep(2000);

        if(expectedURL.equals(actualURL)){
            System.out.println("NOT CHANGED");
        }else{
            System.out.println("CHANGED");
        }

        driver.close();

    }

}
