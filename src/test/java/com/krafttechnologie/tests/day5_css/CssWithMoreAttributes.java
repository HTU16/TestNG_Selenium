package com.krafttechnologie.tests.day5_css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithMoreAttributes {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        // WebElement componentText= driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']"));
        String componentText=driver.findElement(By.cssSelector("div[class='row']>div[class='col-md-4']")).getText();
        System.out.println("componentText = " + componentText);
        // System.out.println("componentText.getText() = " + componentText.getText());
    }

}



