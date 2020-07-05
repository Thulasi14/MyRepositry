package failureCaseWorking;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TransformerClass implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotation, Class AnalyzerClass, Constructor TransformerClass, Method retry) {
		
		annotation.setRetryAnalyzer(AnalyzerClass.class);
	
	}
}
