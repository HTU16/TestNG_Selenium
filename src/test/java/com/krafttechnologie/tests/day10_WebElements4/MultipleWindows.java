package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
          driver.quit();
    }


    @Test
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);


        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

        //String titleAfterClick=driver.getTitle();
        //System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle();         // title The Internet and has ID --> CDwindow-86FF1E88C72D706A5C38610F849D5408
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {                   // go and check one by one           //iter foreach kısayolunu verir*************************
                                                                                                  // itar normal for kısayolunu verir.********************
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void Test2multi(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click= driver.findElement(By.linkText("Click Here"));
        click.click();

        Set<String> windowHandles = driver.getWindowHandles();      // driver.getWindowHandles(); yaz alt enter yap otomatik oluştursun..******************
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("New Window")){
                //stop on this now
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

}
