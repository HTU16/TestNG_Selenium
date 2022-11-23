package com.krafttechnologie.tests.day16_POM2;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {


    LoginPages loginPages=new LoginPages();

    DashboardPage dashboardPage=new DashboardPage();


    @Test

    public void navigateToTabAndModule() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.navigateToModule("Components","Charts");

        String actualsubTitle= dashboardPage.subTitle("Charts");

        Assert.assertEquals(actualsubTitle,"Charts");

        Thread.sleep(3000);

    }

    @Test
    public  void getUser() throws InterruptedException {

        loginPages.loginUser();
        String actualUser= dashboardPage.UsersNames("Ghan");

        String expectedUser="Ghan";
        Assert.assertEquals(actualUser,expectedUser);

        System.out.println("actualUser = " + actualUser);
        Thread.sleep(2000);

    }

    @Test
    public void myProfile() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.myProfile.click();

        BrowserUtils.waitFor(3);

    }

    @Test
    public void aFmTitle(){

      loginPages.loginUser();

        System.out.println("Title = " + dashboardPage.aFmTitle.getText());
    }

    @Test
    public void copyRight(){

        loginPages.loginUser();
        System.out.println("dashboardPage.copyRight.getText() = " + dashboardPage.copyRight.getText());
    }

}