package com.krafttechnologie.tests.day20_DataDrivenFramerwork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    //once @dataProviderdan metodumuzu olusturuyoruz
    //Bu metod testimize data saglayacak

    @DataProvider(name = "AracSatisOranlari")
    public Object[][]testData(){

        String [][] data= {

                { "Audi", "100","80","65","55"},
                { "Bmw", "112","127","135","60"},
                { "Tesla", "20","30","25","15"},
                { "Volkswagen", "70","50","65","75"},
                { "Porche", "40","43","22","17"},
                { "Toyota", "100","180","165","155"},
                { "Volvo", "66","33","22","77"},
                { "Mercedes", "73","80","65","55"},
        };
        return data;
    }



    @Test(dataProvider = "AracSatisOranlari")
    public void test(String aracMarkasi, String Ocak,String Subat, String Mart,String Nisan){

        System.out.println("Arac Markasi :" +aracMarkasi+" : "+Ocak+","+Subat+" ,"+Mart+" ,"+Nisan+"");


    }
}
