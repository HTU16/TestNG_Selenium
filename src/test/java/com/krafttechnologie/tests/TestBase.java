package com.krafttechnologie.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {              //before after metodlar burada bulunur. tekrar tekrar yazmamış oluyoruz
                                      //her test basında buralar calışır ona göre ilerler..
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    //extent report
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        //initialize the class
        report =new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath + "/test-output/report.html";      //target altına ismini biz verdik


        //initialize the html report with the reportPath
        htmlReporter=new ExtentHtmlReporter(reportPath);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("KraftTechB2 Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","Production");  //pro: hangi sayfayı test ettiğimizi yazarız..
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));  //hangi sistemde calışacagını gösterecek.örn:windows8
        report.setSystemInfo("Test Engineer", "HTU");
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
    @BeforeMethod
    public void setUP() {

        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(Driver.get(),15);
        driver.manage().window().maximize();
        actions=new Actions(driver);

    }

    @AfterMethod      //aftertest
    public void tearDown(ITestResult result) throws InterruptedException, IOException {  //screenshot için taerdown içine yazdık..

        //If Test Fails
        if (result.getStatus() == ITestResult.FAILURE) {  //her birine screenshot vermemesi için if içersinde yaptık..

            //Record the name of failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());
        }

            Thread.sleep(2000);
        driver.close();
    }


}
