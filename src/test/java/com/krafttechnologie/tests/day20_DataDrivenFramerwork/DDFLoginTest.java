package com.krafttechnologie.tests.day20_DataDrivenFramerwork;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object [][] userData(){

        //ExcelUtil class icerisinden object olusturuyoruz
        //Iki paramatre giriyoru:Excel file path ve Sayfa(sheet) adi


        ExcelUtil qaTeam3= new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");


        String [][] dataArray= qaTeam3.getDataArrayWithoutFirstRow();

        return dataArray;

    }

    @Test(dataProvider = "userData")
    public void logintestWithDDF(String email, String password,String YourName){

        LoginPages loginPages=new LoginPages();
        DashboardPage dashboardPage=new DashboardPage();


        loginPages.loginWithParameters(email,password);
        String actualName= dashboardPage.getUserName();
        String expectedName= YourName;


        Assert.assertEquals(actualName,expectedName,"Verify Your Name");


    }
}