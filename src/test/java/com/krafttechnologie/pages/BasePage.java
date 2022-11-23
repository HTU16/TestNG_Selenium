package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }


    public void navigateToModule(String tab, String module){

        String tabLocator= "//span[.='"+tab+"']";

        String moduleLocator="//span[.='"+module+"']";


        BrowserUtils.waitForClickablility(By.xpath(tabLocator),5);
        WebElement tabElement=Driver.get().findElement(By.xpath(tabLocator));
        tabElement.click();

        BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);
        Driver.get().findElement(By.xpath(moduleLocator)).click();


    }

    public String subTitle(String subTitle){

        String subTileLocator="//h1[.='"+subTitle+"']";

        BrowserUtils.waitForPresenceOfElement(By.xpath(subTileLocator),5);

        WebElement SubTile= Driver.get().findElement(By.xpath(subTileLocator));

        String actualSubTitle= SubTile.getText();
        return actualSubTitle;

    }






}
