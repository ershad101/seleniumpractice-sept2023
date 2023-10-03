package retryAnylizer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryTc implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int retry = 3;
		int start = 0;
		if (start < retry) {

			start++;
			return true;
		}
		return false;
	}

}
