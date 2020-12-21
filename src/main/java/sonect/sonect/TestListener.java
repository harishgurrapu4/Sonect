package sonect.sonect;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import sonect.sonect.TestBase;

public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentReport4.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + 
												result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = result.getMethod().getMethodName() + " passed successfully";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.GREEN);
		extentTest.get().log(Status.PASS,m);
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Throwable exceptionMessage = result.getThrowable();
		extentTest.get().fail("<details><summary><b><font color=red>" +
						"Exception Occured, click to see details:"+ "</font></b></summary>"+ exceptionMessage + "</details> \n");
		
//		WebDriver driver = ((TestBase)result.getInstance()).driver;
//		String path = takeScreenshot(driver, result.getMethod().getMethodName());
//		try {
//			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b>",
//					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//		} catch (IOException e) {
//			extentTest.get().fail("Test Failed, cannot attach screenshot");
//		}
			
		String logText = methodName + " Failed";
		Markup m = MarkupHelper.createLabel(logText,ExtentColor.RED);
		extentTest.get().log(Status.FAIL,m);
		
	}

	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP,m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

}
