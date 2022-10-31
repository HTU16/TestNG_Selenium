package com.krafttechnologie.tests.day2_webdriverbasics;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
      //  driver.get("https://www.krafttechnologie.com/");

     //   Thread.sleep(2000);

     //   driver.close();

        /*
         * Task *
         *  go to http://www.krafttechexlab.com/ website *
         * expected title = Dashboard- Kraft Techex Lab - aFm *
         * get title and verify that expected title equal actual title */

     driver.get("http://www.krafttechexlab.com/");
        System.out.println("title = " + driver.getTitle());

        String exceptedTitle="Dashboard- Kraft Techex Lab - aFm";

        if ( driver.getTitle()==exceptedTitle){
            System.out.println("title beklenildigi gibi degildir");
        }else {
            System.out.println("title beklenildigi gibidir");
        }



    }
}
