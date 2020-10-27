package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class StringCalculator {
    private int calledCount = 0;

    public int add(String number) throws InvalidInputException {
        calledCount++;
        if (number.equals(""))
            return 0;
        String delimiter = ","; // Default assume , as delimiter

        if (number.startsWith("//")) {
            delimiter = String.valueOf(number.charAt(2));
            number = number.substring(5, number.length());
        }
        String sanitized = replaceNewLine(number, delimiter);
        int[] numbers = Arrays.stream(sanitized.split(delimiter)).mapToInt(Integer::parseInt).filter(e -> e <= 1000).toArray();

        if (Arrays.stream(numbers).anyMatch(e -> e < 0)) {
            String negativeNumbers = Arrays.stream(numbers).filter(e -> e < 0).mapToObj(Objects::toString).collect(Collectors.joining(","));
            throw new InvalidInputException("negatives not allowed :" + negativeNumbers);
        }

        int sum = Arrays.stream(numbers).sum();
        return sum;
    }

    public int getCalledCount() {
        return calledCount;
    }

    private String replaceNewLine(String str, String delimiter) {
        return str.replaceAll(Matcher.quoteReplacement("\n"), delimiter);
    }
}
