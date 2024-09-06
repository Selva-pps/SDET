package Test.Gorest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    public void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("/Gorest/target");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
    }
	
}
