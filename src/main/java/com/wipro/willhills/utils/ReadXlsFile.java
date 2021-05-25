package com.wipro.willhills.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public class ReadXlsFile {
    private FileInputStream fileInput;
    private FileOutputStream fileOut;
    private String  filePath;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ReadXlsFile(String path){
        this.filePath = path;
        try{
            fileInput = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(fileInput);
            fileInput.close();
        }catch(Exception e){
            throw new RuntimeException("Please check the file path");
        }
    }

    public String getCellData(String sheetName, int colNum, int rowNum){
        if(rowNum <=0){
            throw new RuntimeException("Row number is less than 0");
        }
        int index  = workbook.getSheetIndex(sheetName);
        if( index == -1){
            throw new RuntimeException("Sheet name is not correct or not present in file");
        }
        sheet = workbook.getSheet(sheetName);
        row =  sheet.getRow(rowNum-1);
        if(Objects.isNull(row)){
            return "";
        }
        cell = row.getCell(colNum);
        if(Objects.isNull(cell)){
            return "";
        }
        if(cell.getCellType() == CellType.STRING){
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC){
            return String.valueOf(cell.getNumericCellValue()).replace(".0","");
        } else if (cell.getCellType() == CellType.BLANK) {
            return "";
        }else {
            return String.valueOf(cell.getBooleanCellValue());
        }
    }
    public boolean setCellData(String sheetName, int colNum, int rowNum, String data) {
        try {
            if (rowNum <= 0) {
                return false;
            }
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                return false;
            }
            sheet = workbook.getSheetAt(index);
            sheet.autoSizeColumn(colNum - 1);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum - 1);
            if (cell == null)
                cell = row.createCell(colNum - 1);

            // cell style
            CellStyle cs = workbook.createCellStyle();
            Font font = workbook.createFont();
            if(data.equals("Passed")) {
                font.setColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
            }else{
                font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
            }
            cs.setWrapText(true);
            cs.setFont(font);
            cell.setCellValue(data);
            cell.setCellStyle(cs);

            fileOut = new FileOutputStream(new File(this.filePath));

            workbook.write(fileOut);

            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
