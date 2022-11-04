package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLNotChanged {
    public static void main(String[] args) throws InterruptedException {


        /** Class Task
         * open the chrome browser
         * go to https://www.krafttechexlab.com/login
         * click on login button
         * verify that url did not changed
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        //String expectedURL="https://www.krafttechexlab.com/login";
        String expectedURL=driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);

        Thread.sleep(2000);

        //driver.findElement(By.xpath("//button[.='Login']")).click();
        WebElement loginBtn=driver.findElement(By.xpath("//button[.='Login']"));
        loginBtn.click();

        String actualURL=driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);
        Thread.sleep(2000);

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAILED");
        }

        driver.close();



    }
}
