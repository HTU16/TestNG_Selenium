package com.krafttechnologie.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }

    @Test
    public void Test1(){
        System.out.println("first test first assertion");
        Assert.assertEquals("title","title");

        System.out.println(" first test second  assertion");
        Assert.assertEquals("url","url");
    }


    @Test
    public  void Test2(){
        System.out.println("second test  assertion");
        Assert.assertEquals("test2","test2");
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("close browser");
    }
}
