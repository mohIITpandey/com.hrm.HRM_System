package GenericUtilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	public void onTestSuccess(ITestResult result) {	
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("le lo screenshot bhai-----------");
		TakesScreenshot t=(TakesScreenshot)BaseClass.sdriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		LocalDateTime time = LocalDateTime.now();
		String DateTime = time.toString().replace(" ", "_").replace(":","_");
		System.out.println(DateTime);
		File dst = new File("screenShot/"+testName+""+DateTime+".png");
		try {
			FileUtils.copyFile(src, dst);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
