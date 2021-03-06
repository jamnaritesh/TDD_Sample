package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private int calledCount = 0;
    private static String NEW_LINE = "\n";
    private static String COMMA = ",";
    private static String DELIMITER_START = "//";

    public int add(String number) throws InvalidInputException {
        calledCount++;
        if (number.equals(""))
            return 0;

        String delimiter = COMMA; // Default assume , as delimiter

        if (number.startsWith(DELIMITER_START)) {
            if (number.contains("[")) {
                List<String> delimiters = getDelimiter(number);
                number = number.substring(number.indexOf(NEW_LINE) + 1);
                for (int i = 1; i < delimiters.size(); i++) {
                    number = number.replaceAll(delimiters.get(i), delimiters.get(0));
                }
                delimiter = delimiters.get(0);

            } else {
                delimiter = String.valueOf(number.charAt(2));
                number = number.substring(number.indexOf(NEW_LINE) + 1);
            }

        }

        String sanitized = replaceNewLine(number, delimiter);
        int[] numbers = Arrays
                .stream(sanitized.split(Pattern.quote(delimiter)))
                .mapToInt(Integer::parseInt)
                .filter(e -> e <= 1000)
                .toArray();

        if (Arrays
                .stream(numbers)
                .anyMatch(e -> e < 0)) {
            String negativeNumbers = Arrays
                    .stream(numbers)
                    .filter(e -> e < 0)
                    .mapToObj(Objects::toString)
                    .collect(Collectors.joining(COMMA));
            throw new InvalidInputException("negatives not allowed :" + negativeNumbers);
        }

        int sum = Arrays
                .stream(numbers)
                .sum();
        return sum;
    }

    private List<String> getDelimiter(String number) {
        String delimiterArr = number.split(Pattern.quote(NEW_LINE))[0].substring(2);
        List<String> result = Arrays
                .stream(delimiterArr.split("\\]"))
                .map(e -> e.replace("[", ""))
                .collect(Collectors.toList());
        return result;
    }

    public int getCalledCount() {
        return calledCount;
    }

    private String replaceNewLine(String str, String delimiter) {
        return str.replaceAll(Matcher.quoteReplacement(NEW_LINE), delimiter);
    }
}
