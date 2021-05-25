package com.wipro.willhills.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DataUtils {
    public static List<Integer> testRowIndex = new ArrayList<>();
    public static Integer statusColumnIndex;
    public static Object[][] getData(String testName, ReadXlsFile xls){

        String sheetName  =  "TestCases";
        int testStartRowNum = 1;
        while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testName)){
            testStartRowNum++;
        }

        int columnRowNum = testStartRowNum +1;
        int totalCols = 0;
        while(!xls.getCellData(sheetName,totalCols, columnRowNum).equals("")){
            totalCols++;
        }
        statusColumnIndex = totalCols;
        int dataStartRowNum = columnRowNum+1;
        int totalRows = 0;
        while(!xls.getCellData(sheetName,0, dataStartRowNum+totalRows).equals("")){
            totalRows++;
        }
        Object testData[][] = new Object[totalRows][1];
        Hashtable<String, String> table = null;
        int i = 0;
        for(int rNum = dataStartRowNum; rNum<dataStartRowNum+totalRows; rNum++){
            testRowIndex.add(rNum);
            table = new Hashtable<>();
            for(int cNum=0;cNum< totalCols; cNum++){
                String data = xls.getCellData(sheetName,cNum, rNum);
                String key = xls.getCellData(sheetName,cNum, columnRowNum);
                table.put(key,data);
            }
            testData[i][0] = table;
            i++;
        }
        return testData;
    }
}
