package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        //  driver.close();
    }

    @Test
    public void PopUp() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");

        driver.findElement(By.xpath("//*[@id=\"j_idt343:j_idt344\"]/span[2]")).click();
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(2000);

        //verify that confirm is accepted
        String expectedMessage="You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(),expectedMessage);
    }

    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //click- Click For JS Alert Button
       driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

       //e.g.:1 switch to JS alert pop up
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK e basar
        alert.accept();


        //e.g.:2 switch to JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //click CANCEL  e basar
        alert.dismiss();


        //e.g.:3 switch to JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //click keys to JS Prompt
        alert.sendKeys("AZDAN AZ COKTAN COK GİDER");
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

    }
}
