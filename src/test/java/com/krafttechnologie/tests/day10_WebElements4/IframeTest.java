package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }


    @Test
    public void IframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        // how to switch the frame ?

        // first way using NAME or ID-----------------------------------------------------------------------
        driver.switchTo().frame("mce_0_ifr");

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();
        Thread.sleep(3000);
        textArea.sendKeys("BİZ KİMSENİN VARLIĞIYLA VAR OLMADIK YOKLUĞUYLA DA YOK OLMAYIZ");

        //second way switching INDEX----------------------------------------------------------------------
        driver.switchTo().parentFrame();// first we should go back to parent
        driver.switchTo().frame(0);
        textArea.clear();
        Thread.sleep(3000);
        textArea.sendKeys("BİZ KİMSENİN VARLIĞIYLA VAR OLMADIK YOKLUĞUYLA DA YOK OLMAYIZ 2");


        driver.switchTo().parentFrame();
        Thread.sleep(3000);

        // third way using WEB ELEMENT-------------------------------------------------------------------
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("BİZ KİMSENİN VARLIĞIYLA VAR OLMADIK YOKLUĞUYLA DA YOK OLMAYIZ  3");
    }

    @Test
    public void nestedIfFrame(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switch to middle frame and get MIDDLE text

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());


        // got to Right frame and get text

        // driver.switchTo().parentFrame(); // selenium switch to parent

        driver.switchTo().defaultContent(); // selenium switch the top
        driver.switchTo().frame("frame-top"); // if we use defaultContent(), we should start first step

        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"Body\")).getText() = " + driver.findElement(By.tagName("Body")).getText());

        // go to bottom frame and get text

        driver.switchTo().defaultContent();
        // driver.switchTo().parentFrame().switchTo().parentFrame(); // another way to go grandparent
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"Body\")).getText() = " + driver.findElement(By.tagName("Body")).getText());



    }
}
