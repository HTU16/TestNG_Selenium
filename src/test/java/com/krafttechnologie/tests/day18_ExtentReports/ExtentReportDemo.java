package com.krafttechnologie.tests.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    //this class is used for starting and building reports
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this class define a test, enable adding logs , author and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        //initialize the class
        report =new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        String reportPath=projectPath + "/test-output/report.html";      //target altına ismini biz verdik.ismi istediğimiz gibi değiştirebiliriz.
         //istediğimiz kadar report oluşturabiliriz farklı testler için farklı reportlar..

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
        report.setSystemInfo("Test Engineer", "HTU");  // unvan ve adımızı burada yazarız.
    }

    @Test
    public void test1() {

        //give a name to the current test
        extentLogger=report.createTest("TC001 Login Test");

        //Test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify Logged in");
        extentLogger.info("TC001 Login Test is Passed");

    }

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created
        report.flush();   //cıkmak için flush kullanıyoruz..

    }
}
