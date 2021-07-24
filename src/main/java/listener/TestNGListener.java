package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import testUtil.TestReportsGeneration;
import testUtil.TestUtil;

public class TestNGListener  extends BaseClass implements ITestListener{

	ExtentReports extent=TestReportsGeneration.getExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTestThread= new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		//Initializing the Test
		test=extent.createTest(result.getMethod().getMethodName());
		extentTestThread.set(test); //For parallel test execution
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	test.log(Status.PASS, result.getMethod().getMethodName() + " is successfully Passed");
		extentTestThread.get().log(Status.PASS, result.getMethod().getMethodName() + " is successfully Passed");
		System.out.println(result.getMethod().getMethodName() + " is successfully Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		//test.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		extentTestThread.get().addScreenCaptureFromPath(TestUtil.getScreenshot(result.getMethod().getMethodName()));	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Test Case is skipped
		//test.log(Status.SKIP, result.getMethod().getMethodName() + " is Skipped");
		extentTestThread.get().log(Status.SKIP, result.getMethod().getMethodName() + " is is Skipped");
		System.out.println(result.getMethod().getMethodName() + " is Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//Finishing the test
		extent.flush();
	}

}
