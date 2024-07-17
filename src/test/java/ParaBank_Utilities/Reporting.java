package ParaBank_Utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import ParaBank_Testcases.PB_BaseClass;


public class Reporting implements ITestListener {

	public ExtentSparkReporter reporter; //it is provide the basic information about the document 
	//document title,report name,theme of the report
	public ExtentReports extent; //it is provide the basic information about the user
	
	public ExtentTest test; //it is provide the basic infomation about testcases status
	//pass,fail,skip
	
	//pre-defined methods(onStart,onTestSuccess,onTestFailure,onTestSkipped,onFinish
	
	
	public void onStart(ITestContext context) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		String repname="test-report"+timestamp+".html";
		reporter=new ExtentSparkReporter("F:\\Eclipse work space\\Hybrid_Framework\\Reports\\"+"_"+repname);
		
		//provide the basic information about the document
		
		reporter.config().setDocumentTitle("ParaBank Project");
		reporter.config().setReportName("Register Functionlaity Report");
		reporter.config().setTheme(Theme.DARK);
		
		//provide the basic information about the user
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("user", "T Venkatarao");
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows,Macos,Linux");
		extent.setSystemInfo("Browser", "chrome,firefox,edge");
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
		try {
			String imgPath=new PB_BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgPath);//add screenshot into extent report
			} 
		catch (Exception e) 
				{
				e.printStackTrace();
				}
	
		}
	
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
}
