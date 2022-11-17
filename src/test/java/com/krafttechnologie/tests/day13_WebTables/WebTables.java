package com.krafttechnologie.tests.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {

    WebDriver driver;

    @BeforeClass
    public void setUP() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
         driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));

        System.out.println("table.getText() = " + table.getText());
    }


    @Test
    public void printAllheaders(){

        WebElement headers= driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] /thead"));
        System.out.println("headers.getText() = " + headers.getText());

    }

    @Test
    public void printTableSize(){

        //th tag indeki elementlerin size ni alalim
        List<WebElement> thSize= driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //th"));
        System.out.println("thSize= " + thSize.size());

        //rows (satirlarin) size ni bulalim
        List<WebElement> rwSize= driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tr"));
        System.out.println("rwSize.size() = " + rwSize.size());

        // Headers (Basliklar) haric rows (satirlarin) size ni bulalim
        List<WebElement>allRowsWitoutheaders= driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));
        System.out.println("allRowsWitoutheaders.size() = " + allRowsWitoutheaders.size());
    }
    @Test
    public void getRow(){
        WebElement row2= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]"));

        System.out.println("row2.getText() = " + row2.getText());
    }

    @Test
    public void getAllRows() throws InterruptedException {

        List<WebElement>allRows=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));

        Thread.sleep(2000);

        for(int i=1; i<= allRows.size();i++){

            WebElement row= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }

    }
    @Test
    public void getAllCellsOneRow(){
        //List<WebElement>allcells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]//td"));
        WebElement jacop= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]//td[1]"));

        System.out.println("jacop.getText() = " + jacop.getText());
//        for(WebElement element: allcells){
//            System.out.println("element.getText() = " + element.getText());
//        }


    }

    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/components/iframe");
        WebElement iframe= driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        WebElement box=driver.findElement(By.xpath("(//button[@class='btn-close btn-close-white'])[1]"));
        box.click();

        driver.switchTo().defaultContent();

        WebElement title= driver.findElement(By.xpath("//h1[.='Iframe']"));

        System.out.println("title.getText() = " + title.getText());



    }
}
