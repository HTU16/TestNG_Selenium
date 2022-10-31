package com.krafttechnologie.tests.day3_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1=driver.findElement(By.linkText("Example 1: Element on page that is hidden"));

        example1.click();   //linke yönlendirme yapar..

        String expectedText="Example 1: Element on page that is hidden";
        String actualText=driver.findElement(By.tagName("h4")).getText();
        System.out.println("actualText = " + actualText);

        if(actualText.contains(expectedText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAILED");
        }

        Thread.sleep(2000);

        driver.navigate().back();    //önceki sekmeye geri döner..

        driver.findElement(By.partialLinkText("Example 2")).click();

        String expectedText2="Example 2: Element rendered after the fact";
        String actualText2=driver.findElement(By.tagName("h4")).getText();
        System.out.println("actualText2 = " + actualText2);

        if(actualText2.contains(expectedText2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);


        driver.close();

    }


}
