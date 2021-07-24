package testUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReportsGeneration {

	static ExtentReports extent;

	public static ExtentReports getExtentReport() {
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyy_HHMMSS");
		
		// Giving the Report Path	
		String reportPath = System.getProperty("user.dir")+"/Reports/TestReports/"+"TestReport_"+sdf.format(cal.getTime())+".html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
		extentSparkReporter.config().setDocumentTitle("CRMPRO Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);

		// Setting Properties of Test
		extent.setSystemInfo("Tester", "Mohit Pardeshi");

		return extent;

	}
}
