package DAMS.Resources;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtil {
	public static ThreadLocal<SoftAssert> softAssert=ThreadLocal.withInitial(SoftAssert::new);
	
	public static SoftAssert getSoftAssert() {
		return softAssert.get();
	}

	public static void assertEquals(Object actual, Object expected) {
		getSoftAssert().assertEquals(actual, expected);

	}
	
	public static void assertTrue(boolean condition) {
		getSoftAssert().assertTrue(condition);

	}
	
	public static void assertFalse(boolean condition) {
		getSoftAssert().assertFalse(condition);

	}
	public static void assertAll() {
		
		getSoftAssert().assertAll();
	}
}
