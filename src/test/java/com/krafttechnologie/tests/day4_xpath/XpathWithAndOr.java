package com.krafttechnologie.tests.day4_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithAndOr {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

//  AND      WebElement searchBox= driver.findElement(By.xpath("//input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
//  AND      searchBox.sendKeys("JAVA");

        WebElement searchBox= driver.findElement(By.xpath("//input[@type='text' or @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        searchBox.sendKeys("JAVA");            //OR

        WebElement searchbtn= driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));
        searchbtn.click();
    }
}


//SELENIUM DA EN COK VEREN HATA : NO SUCH ELEMENT    *******************