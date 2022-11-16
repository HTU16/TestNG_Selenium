package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
    WebDriver driver;

    @BeforeClass
    public void setUP() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void uploadFile() throws InterruptedException {                        //DOSYA YÜKLEME OTOMASYONU İÇİN KULLANILIR..*****************************

        //choose file elementini locate ediyoruz
        //sonrasinda sendKeys(file path)
        //File Path:
        //Windows icin: shift tusu+ dosya uzerinde sag click yapip Copy asPath seciyoruz
        //Mac icin: sag click+ option key+ Copy.....as PAthName (yol Adi olarak kopyala)

        driver.get("https://demoqa.com/upload-download");

        WebElement chooseFile= driver.findElement(By.id("uploadFile"));
        Thread.sleep(2000);

        chooseFile.sendKeys("C:\\Users\\mathi\\OneDrive\\Masaüstü\\HM");

        WebElement testmsj= driver.findElement(By.cssSelector("#uploadedFilePath"));

        System.out.println("testmsj = " + testmsj.getText());

        String actual= testmsj.getText();
        String expected="HM";

        Assert.assertTrue(actual.contains(expected));

    }
}
