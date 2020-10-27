package com.jamnaritesh.tdd.stringutil;
import org.jamnaritesh.tdd.stringutil.StringCalculator;
import org.junit.Assert;
import org.junit.Test;
public class StringCalculatorTest {
    @Test
    public void whenEmptyStringThenReturnZero(){
        StringCalculator calculator = new StringCalculator();
        Assert.assertEquals(0, calculator.add(""));
    }
}
