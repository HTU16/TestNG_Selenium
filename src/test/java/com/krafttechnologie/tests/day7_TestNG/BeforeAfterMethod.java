package com.krafttechnologie.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @Test
    public void  test2(){
        System.out.println("second test method");
    }
                                                             //SIRALI BİR ŞEKİLDE YAZDIRIR. İLK BEFORE SONRA SIRALI SONRA AFTER HEP BU ŞEKİLDE...
    @Test                                                     //SÜREKLİ İÇ İÇE BİR DÖNGÜ GİBİ İLK BEFORE SONRA AFTER TARZINDA..
    public void def(){                                        //İLK HARF OLAN SINIFLARI CALIŞTIRIR. SONRA SAYILARA GECER...
        System.out.println("second def");                     //BEFORE VE AFTER SOL TARAFTA GÖZÜKMEZ..
    }



    @Test @Ignore                                               //IGNORE KULLANIRSAK O SINIFI YAZDIRMAZ.. AFTER-BEFORE DA CALISMAZ.
    public void abc(){
        System.out.println("first abc");
    }


    @Test
    public void test1(){
        System.out.println("my first test method");
    }
    @BeforeClass
    public void setUpClass(){
        System.out.println("-----before class-----");
    }

  //  @Test                                                   //IGNORE İLE YAPISI AYNIDIR. ' // ' YAPILIRSA O SINIFI YAZDIRMAZ.. AFTER-BEFORE DA CALIŞIR..
    public void  Alcatraz(){
        System.out.println("test case comment");
    }

    @BeforeMethod
    public  void  setUp(){
        System.out.println("before method");
    }

    @AfterClass                            // SOL TARAFTA YİNE GÖZÜKMEZ. AFTER CLASS-BEFORE CLASS BAŞINDA VE SONUNDA SADECE 1 KEZ CALIŞIR BASKA CALIŞMAZ..
    public void tearDownClass(){
        System.out.println("----------after class----");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
    }
}
