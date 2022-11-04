package com.krafttechnologie.tests.day6_webElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {


            /** Class Task
             *  go to the amazon website : https://www.amazon.com.tr/
             *  write "selenium" to search box
             *  verify that the result of the search
             */

            String product="apple";


            WebDriver driver= WebDriverFactory.getDriver("chrome");
            driver.get("https://www.amazon.com.tr/");


            WebElement cookiesAccept=driver.findElement(By.id("sp-cc-accept"));
            cookiesAccept.click();

            driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product);

            Thread.sleep(2000);

            driver.findElement(By.cssSelector("[value='Git']")).click();

            Thread.sleep(1000);


            // xpath locator : if you want to pass child to parent you can can use  "/.." charakter
            String actualText=driver.findElement(By.xpath("//span[contains(text(),'Aranan ürün:')]/..")).getText();

            System.out.println("actualText = " + actualText);
            Thread.sleep(1000);

            if (actualText.contains(product)){
                System.out.println("PASS");
            }else{
                System.out.println("FAILED");
            }


            driver.close();



        }
    }

