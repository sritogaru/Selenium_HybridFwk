package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportUtility implements ITestListener {
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports reports;
	public ExtentTest tests;
	String reportname;
	
	@Override
	public void onStart(ITestContext context) {
		
		String timestamp = new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date()) ;
		reportname= "Test-Report" +  timestamp  + ".html"; 
		sparkreporter = new ExtentSparkReporter(".\\Reports\\" + reportname); //location of report
		sparkreporter.config().setDocumentTitle("TricentisTesting application Report"); // Name of report
		sparkreporter.config().setReportName("Demo WebShop online shopping Testing"); // type of report
		sparkreporter.config().setTheme(Theme.STANDARD); // Theme of report
		
		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		
		reports.setSystemInfo("Operating System", System.getProperty("os.name"));
		reports.setSystemInfo("Username", System.getProperty("user.name"));
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Browser", System.getProperty("browser.name"));
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		tests = reports.createTest(result.getName()); //create new test entry in report
		tests.log(Status.PASS, "Test case is passed"  +result.getName()); //update test case status as Pass/Fail/skip
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		tests = reports.createTest(result.getName()); //create new test entry in report
		tests.log(Status.FAIL, "Test case is Failed"  +result.getName()); //update test case status as Pass/Fail/skip
		tests.log(Status.FAIL, "Test case is failed because of"+result.getThrowable().getMessage()); // this throwable methode will get the error message
		
		try {
			String imgpath = new BaseClass().CaptureScreenshot(result.getName()); // creating baseclass object for calling 
			//capturescreenshot class and storing in to string variable
			tests.addScreenCaptureFromPath(imgpath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		tests = reports.createTest(result.getName()); //create new test entry in report
		tests.log(Status.SKIP, "Test case is skipped"+result.getName()); //update test case status as Pass/Fail/skip
	}
	
	@Override
	public void onFinish(ITestContext context) {
	   reports.flush(); // This method will consolidate and organize all the entries in reports 

}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
}
