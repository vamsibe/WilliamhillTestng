package rough;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReportDemo {

    @Test
    public void generateReport() throws IOException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Orange HRM Report");
        spark.config().setReportName("Orange HRM Report Regression Test");

        ExtentTest test1 = extent.createTest("First Test");
        test1.info("Hello first test");

        ExtentTest test2 = extent.createTest("Second Test");
        test2.info("Hello second test");

        extent.flush();

        Desktop.getDesktop().browse(new File("index.html").toURI());

    }
}
