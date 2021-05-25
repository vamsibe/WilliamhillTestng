package com.wipro.willhills.testcripts;

import com.google.common.util.concurrent.Uninterruptibles;
import com.wipro.willhills.driver.DriverManager;
import com.wipro.willhills.pages.AllSportsInPlayPage;
import com.wipro.willhills.pages.BettingPage;
import com.wipro.willhills.pages.LandingPage;
import com.wipro.willhills.utils.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PrintTest extends BaseTest {
    private LandingPage landingPage;
    private BettingPage bettingPage;
    private AllSportsInPlayPage allSportsInPlayPage;
    private String sportsName;

    @BeforeMethod
    public void inItBettingPageTest() {
        System.out.println(DriverManager.getDriver());
        this.landingPage = new LandingPage();
        this.bettingPage = new BettingPage();
        this.allSportsInPlayPage = new AllSportsInPlayPage(DriverManager.getDriver());

    }

    @Test
    public void printAllSportGamesBetsAvailable() throws IOException {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        Map<String, List<String>> gameListMap = new HashMap<>();
        this.landingPage.bettingLink.click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.bettingPage.acceptAndCloseButton.click();
        for (int i = 0; i < this.bettingPage.allSports.size(); i++) {
            this.bettingPage.allSports.get(i).click();
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            List<String> gameList = new ArrayList<>();
            for (int j = 0; j < this.bettingPage.allGamesToBet.size(); j++) {
                gameList.add(this.bettingPage.allGamesToBet.get(j).getText());
            }
            gameListMap.put(this.bettingPage.allSports.get(i).getText(), gameList);
        }
        System.out.println(gameListMap);
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook();

        for (Map.Entry<String, List<String>> entry : gameListMap.entrySet()){
            int rowCount = 0;
            XSSFSheet sheet = null;
            if(entry.getKey().contains("/")){
                 sheet = workbook.createSheet(entry.getKey().replace("/","_"));
            }else {
                 sheet = workbook.createSheet(entry.getKey());
            }
            for(int i = 0; i<entry.getValue().size(); i++){
                XSSFRow row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                cell.setCellValue(entry.getValue().get(i));
            }
        }
        FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx"));
        workbook.write(out);
        out.close();
    }


    @Test
    public void printAllGamesToBet() throws IOException {
        waitUtils.waitForElementToBeClickable(this.landingPage.bettingLink);
        this.landingPage.bettingLink.click();
        File f = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("JavaBooks");
        int rowCount = 0;
        int columnCount = 0;
        for (int i = 0; i < this.bettingPage.allGamesToBet.size(); i++) {
            if (!this.bettingPage.allGamesToBet.get(i).getText().equals("")) {
                XSSFRow row = sheet.createRow(rowCount++);
                Cell cell = row.createCell(0);
                System.out.println(this.bettingPage.allGamesToBet.get(i).getText());
                cell.setCellValue(this.bettingPage.allGamesToBet.get(i).getText());
            }
        }
        FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\JavaBooks.xlsx"));
        workbook.write(out);
        out.close();
    }


}

