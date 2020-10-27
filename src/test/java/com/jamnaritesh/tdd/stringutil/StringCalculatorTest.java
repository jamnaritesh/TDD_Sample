package com.jamnaritesh.tdd.stringutil;

import org.jamnaritesh.tdd.stringutil.InvalidInputException;
import org.jamnaritesh.tdd.stringutil.StringCalculator;
import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void whenEmptyStringThenReturnZero() throws InvalidInputException {
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void whenSingleDigitThenReturnIdentity() throws InvalidInputException {
        Assert.assertEquals(1, calculator.add("1"));
    }

    @Test
    public void whenDoubleDigitThenReturnAddition() throws InvalidInputException {
        Assert.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void whenNewLineThenConsiderAsComma() throws InvalidInputException {
        Assert.assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void AcceptDelimiter() throws InvalidInputException {
        Assert.assertEquals(3, calculator.add("//;\\n1;2"));
    }

    @Test(expected = InvalidInputException.class)
    public void throwInvalidInputExceptionWhenInputHasNegativeNumbers() throws InvalidInputException {
        calculator.add("-1,2,3");
    }
}
