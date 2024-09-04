package com.qa.testng.tests;

import com.qa.testng.data.TestDataGenerator;
import com.qa.testng.utility.MultiTest;
import com.qa.testng.utility.PupilPojo;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderPupilTest {


    @Test(dataProvider = "pupilSupplier", dataProviderClass = TestDataGenerator.class)
    public void checkStudentAsList(List<PupilPojo> pupilPojos){
        System.out.println(pupilPojos);

    }

    @MultiTest
    @Test( dataProvider = "pupilSupplier", dataProviderClass = TestDataGenerator.class )
    public void checkStudentIterator(PupilPojo index){
        System.out.println(index);

    }
}
