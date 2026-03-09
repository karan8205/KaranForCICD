package DAMS.Resources;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.google.common.collect.Multiset.Entry;

public class FailedAll implements IAnnotationTransformer{
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
	                      Constructor testConstructor, Method testMethod) {

	    Class<? extends IRetryAnalyzer> retryClass =
	            annotation.getRetryAnalyzerClass();

	    if (retryClass == null) {
	        annotation.setRetryAnalyzer(Failed.class);
	    }
	}
//	@Override
//	public void transform(ITestAnnotation annotation, Class testClass,
//	                      Constructor testConstructor, Method testMethod) {
//
//	    Class<? extends IRetryAnalyzer> retryClass = annotation.getRetryAnalyzerClass();
//
//	    if (retryClass == null) {
//	        annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Entry.class);
//	    }
//	}
}
