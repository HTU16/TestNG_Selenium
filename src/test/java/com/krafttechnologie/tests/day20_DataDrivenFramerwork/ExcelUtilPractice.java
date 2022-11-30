package com.krafttechnologie.tests.day20_DataDrivenFramerwork;

import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {


    @Test
    public void readExcelFile(){
        /*
        ExcelUtil dan bir object olusturacagiz
        Object iki argument alacak Bunlar: Dosyanin
        pathi ile calisma yapacagimiz sayfanin adi olacak.
         */

        ExcelUtil qaTeam3 = new ExcelUtil("src/test/resources/LoginList.xlsx", "QaTeam3");
        //once satir (row) sayisini bulalim

        System.out.println("qaTeam3.rowCount() = " + qaTeam3.rowCount());

        //Sayfada column sayisini bulalim

        System.out.println("qaTeam3.columnCount() = " + qaTeam3.columnCount());

        System.out.println("qaTeam3.getColumnsNames() = " + qaTeam3.getColumnsNames());

        //Simdi de qaTeam3 object atanan datayı liste olarak cagiralim.
        List<Map<String,String>> dataList=qaTeam3.getDataList();

        System.out.println("dataList = " + dataList);

        for(Map<String,String> row:qaTeam3.getDataList()) {   //tüm verileri satır satır getirdi.
            System.out.println("row = " + row);
        }
        //2 satiri getirelim

        System.out.println("dataList.get(2) = " + dataList.get(2));

        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));


        //butun datayi 2 boyutlu array alalim

        String [][] dataArray= qaTeam3.getDataArray();

        System.out.println(Arrays.deepToString(dataArray));

    }


}