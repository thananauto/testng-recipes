package com.qa.testng.data;

import com.creditdatamw.zerocell.Reader;
import com.qa.testng.utility.MathsPojo;
import com.qa.testng.utility.PupilPojo;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

public class TestDataGenerator {

    File file = new File(Objects.requireNonNull(TestDataGenerator.class.getClassLoader().getResource("Students.xlsx")).getFile());


    private Optional<String> getMultiStatus(Method method){
        return Arrays.stream(method.getDeclaredAnnotations())
                .map(e-> e.annotationType().getSimpleName())
                .filter(e-> e.equals("MultiTest"))
                .findFirst()
                .or(Optional::empty);
    }
    @DataProvider(name = "pupilSupplier")
    public Iterator<Object[]> pupilIterator(Method method){

        List<PupilPojo> lstPupil = Reader.of(PupilPojo.class)
                .from(file)
                .sheet("Pupils")
                .list();
        Optional<String> multiTest = getMultiStatus(method);

        if(multiTest.isPresent())
            return lstPupil
                    .stream()
                    .map(e-> new Object[]{e})
                    .iterator();
        else
            return Arrays.stream(new Object[][]{ new Object[]{lstPupil}}).iterator();


    }

    @DataProvider(name = "mathsTestData")
    public Iterator<Object[]>  getMathTestData(Method method){
        List<MathsPojo> lstMath = Reader.of(MathsPojo.class)
                .from(file)
                .sheet("Maths")
                .list();
        Optional<String> multiTest = getMultiStatus(method);

        if(multiTest.isPresent())
            return lstMath
                    .stream()
                    .map(e-> new Object[]{e})
                    .iterator();
        else
            return Arrays.stream(new Object[][]{ new Object[]{lstMath}}).iterator();
    }




}
