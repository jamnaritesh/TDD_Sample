package com.jamnaritesh.tdd.stringutil;
import org.jamnaritesh.tdd.stringutil.StringCalculator;
import org.junit.Assert;
import org.junit.Test;
public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void whenEmptyStringThenReturnZero() throws Exception {
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public  void whenSingleDigitThenReturnIdentity() throws Exception {
        Assert.assertEquals(1,calculator.add("1"));
    }

    @Test
    public  void whenDoubleDigitThenReturnAddition() throws Exception {
        Assert.assertEquals(3,calculator.add("1,2"));
    }

    @Test
    public void whenNewLineThenConsiderAsComma() throws Exception {
        Assert.assertEquals(6,calculator.add("1\n2,3"));
    }

    @Test
    public void AcceptDelimiter() throws Exception {
        Assert.assertEquals(3,calculator.add("//;\\n1;2"));
    }

    @Test(expected = Exception.class)
    public void throwExceptionWhenInputHasNegativeNumbers() throws Exception {
        calculator.add("-1,2,3");
    }
}
