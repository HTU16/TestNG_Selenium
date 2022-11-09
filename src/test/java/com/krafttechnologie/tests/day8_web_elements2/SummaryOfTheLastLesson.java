package com.krafttechnologie.tests.day8_web_elements2;

import org.testng.Assert;
import org.testng.annotations.*;

public class SummaryOfTheLastLesson {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite runs");
    }

    @BeforeTest
    public void  beforeTest(){
        System.out.println("before test runs");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class runs");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method runs");
    }

    @Test
    public void test1(){
        Assert.assertTrue(4>2);
    }

    @Test
    public void test2(){
        Assert.assertFalse(1>2);
    }

    @Test
    public void test3(){
        Assert.assertEquals(1,1);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method runs");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class runs");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test runs");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite runs");
    }
}
