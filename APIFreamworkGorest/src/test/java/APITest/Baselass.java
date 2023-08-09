package APITest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baselass {
	
	public   ExtentSparkReporter spark;
	public   ExtentReports report;
	public  ExtentTest test;
	
	@BeforeSuite
	public void initialSetup() {
		// TODO Auto-generated method stub
		SimpleDateFormat d=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String d1=d.format(new Date());
		
		spark=new ExtentSparkReporter(new File("./Reports/GoRest"+d1+".html"));
		report=new ExtentReports();
		report.attachReporter(spark);
		spark.config().setDocumentTitle("GoRestAPITesting");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Gorest");
		report.setSystemInfo("Environment", "TestEnv");
		report.setSystemInfo("TesterName", "Aaysha");
	}

	@AfterSuite
	public void saveReport() {
		report.flush();
	}

}
