package com.qa.testng.tests;

import com.qa.testng.utility.MathsPojo;
import com.qa.testng.utility.MultiTest;
import org.assertj.core.api.Condition;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class MathTest {

    @MultiTest
    @Test
    public void add(MathsPojo mathsPojo){
        assertThat(mathsPojo.getInput1() + mathsPojo.getInput2())
                .as("Adding two numbers")
                .isGreaterThanOrEqualTo(mathsPojo.getInput1());
    }

    @MultiTest
    @Test
    public void sub(MathsPojo mathsPojo){
        assertThat(mathsPojo.getInput1() - mathsPojo.getInput2())
                .as("Subtracting two numbers")
                .isLessThan(mathsPojo.getInput1());
    }
    @MultiTest
    @Test
    public void mul(MathsPojo mathsPojo){
        assertThat(mathsPojo.getInput1() * mathsPojo.getInput2())
                .as("Multiply two numbers")
                .isGreaterThanOrEqualTo(mathsPojo.getInput1() + mathsPojo.getInput2());
    }
    @MultiTest
    @Test
    public void div(MathsPojo mathsPojo){
        assertThat(mathsPojo.getInput1() / mathsPojo.getInput2())
                .as("Division two numbers")
                .isGreaterThan(0);

    }
}
