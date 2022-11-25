package com.krafttechnologie.tests.day17_POM3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.pages.ProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {

    LoginPages loginPages = new LoginPages();
    DashboardPage dashboardPage = new DashboardPage();
    ProfilePage profilePage = new ProfilePage();

    @Test
    public void editProfile() {

        loginPages.loginUser();
        dashboardPage.myProfile.click();
        BrowserUtils.waitFor(3);
        profilePage.profileTabs("Edit Profile");

        profilePage.fullName.clear();
        profilePage.fullName.sendKeys("Rabinson");


        profilePage.about.clear();
        profilePage.about.sendKeys("Some words are here");

        profilePage.company.clear();
        profilePage.company.sendKeys("GHAN IT");


        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"), 5);
        BrowserUtils.dragAndDropBy(profilePage.slider, 150, 0);

        Select select = new Select(profilePage.job);
        select.selectByVisibleText("Developer");

        profilePage.website.clear();
        profilePage.website.sendKeys("https://Krafttechnologie.com");


        profilePage.location.clear();
        profilePage.location.sendKeys("Istanbul");

        profilePage.skills.clear();
        profilePage.skills.sendKeys("TestNG,Cucumber");


        //profilePage.save.click();
        //BrowserUtils.clickWithJS(profilePage.save);
    }

    @Test
    public void addExperience() {

        loginPages.loginUser();
        dashboardPage.myProfile.click();

        profilePage.profileTabs("Add Experience");

        profilePage.jobTitle.clear();
        profilePage.jobTitle.sendKeys("QA");

        profilePage.companyexperience.clear();
        profilePage.companyexperience.sendKeys("GHAN IT");

        profilePage.locationExperience.clear();
        profilePage.locationExperience.sendKeys("ANKARA");

        profilePage.startYear.clear();
        profilePage.startYear.sendKeys("02/02/2020");

        profilePage.endYear.clear();
        profilePage.endYear.sendKeys("02/02/2022");

        profilePage.jobDescription.clear();
        profilePage.jobDescription.sendKeys("Cool Workplace");

        profilePage.addExperienceBtn.click();


    }
}
