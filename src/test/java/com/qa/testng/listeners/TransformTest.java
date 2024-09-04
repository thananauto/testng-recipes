package com.qa.testng.listeners;

import com.qa.testng.data.TestDataGenerator;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TransformTest implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass,
                          Constructor constructor, Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        iTestAnnotation.setDataProviderClass(TestDataGenerator.class);
        iTestAnnotation.setTestName(method.toString());


        if(className.equals("MathTest")){
            //adding data provider name
            iTestAnnotation.setDataProvider("mathsTestData");
            iTestAnnotation.setRetryAnalyzer(Retry.class);

        }else if(className.contains("PupilTest")){
            iTestAnnotation.setDataProvider("pupilSupplier");

        }

    }
}
