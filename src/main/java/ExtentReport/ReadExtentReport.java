package ExtentReport;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReadExtentReport {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest

	public void StartReport() {

		htmlReporter = new ExtentSparkReporter("Extent Reprt.html");

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add Environment details 2. all the environment details

		reports.setSystemInfo("machine", "TestPC1");
		reports.setSystemInfo("OS", "Window10");
		reports.setSystemInfo("Tester", "Ershad");
		reports.setSystemInfo("Browser", "Chrome");

		// Configure to change looks and feels 3. all the details of backgrounds

		htmlReporter.config().setDocumentTitle("Extent Report");

		htmlReporter.config().setReportName("Test Reports");

		htmlReporter.config().setTheme(Theme.DARK);

		htmlReporter.config().setTimeStampFormat("EEEE,MMMMM,dd,YYYY hh:mm a '('ZZZ')' ");

	}

	// 4. launch the browser

	@Test
	public void lauchBrowser() {

		test = reports.createTest("Lauch The Browser & URL");
		Assert.assertTrue(true); // Test Case Passed
	}

	@Test

	public void VerifyTitle() {

		test = reports.createTest("Verify Title");

		Assert.assertTrue(false); // TC Failed
	}

	@Test

	public void VerifyLogo() {

		test = reports.createTest("Verify Logo");

		Assert.assertTrue(true); // Tc passed

	}

	@AfterMethod // 5. after execution test Result passed or failed or skipped mention by their
					// colour

	public void getTestResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Failed", ExtentColor.RED));
			
			test.fail(result.getThrowable());
			
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Passed", ExtentColor.GREEN));
		}

	}

	@AfterTest

	public void TearDown() {

		reports.flush();

}
	}
