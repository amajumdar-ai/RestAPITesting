import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class generatereport {
	
	
	
		@BeforeTest()
		public void generateReport()
		{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/report.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest logger=reports.createTest("getcalltest");
		ExtentTest logger2=reports.createTest("POSTTest");
		ExtentTest logger3=reports.createTest("POSTCall1");
		ExtentTest logger4=reports.createTest("update");

		}
	}


