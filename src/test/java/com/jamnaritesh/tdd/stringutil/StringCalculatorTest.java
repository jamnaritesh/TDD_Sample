package com.jamnaritesh.tdd.stringutil;
import org.jamnaritesh.tdd.stringutil.StringCalculator;
import org.junit.Assert;
import org.junit.Test;
public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void whenEmptyStringThenReturnZero(){
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public  void whenSingleDigitThenReturnIdentity(){
        Assert.assertEquals(1,calculator.add("1"));
    }

    @Test
    public  void whenDoubleDigitThenReturnAddition(){
        Assert.assertEquals(3,calculator.add("1,2"));
    }

    @Test
    public void whenNewLineThenConsiderAsComma(){
        Assert.assertEquals(6,calculator.add("1\n2,3"));
    }

    @Test
    public void AcceptDelimiter(){
        Assert.assertEquals(3,calculator.add("//;\\n1;2"));
    }
}
