package DAMS.Resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Failed implements IRetryAnalyzer{
int max=1,min=0;
	@Override
	public boolean retry(ITestResult result) {
		if(min<max) {
			min++;
			return true;
		}
		return false;
	}

}
