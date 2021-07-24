package testUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class TestUtil extends BaseClass {
	
	public static String getScreenshot(String name)
	{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyyyy_HHMMSS");
		String filePathName=System.getProperty("user.dir")+"/Reports/ScreenShots/"+name+"_"+sdf.format(cal.getTime())+".png";
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File (filePathName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filePathName;
	}
	
}
