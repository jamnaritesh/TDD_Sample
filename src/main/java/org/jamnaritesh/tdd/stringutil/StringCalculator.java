package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;
import java.util.regex.Matcher;

public class StringCalculator {
    public int add(String number) throws Exception {
        if(number.equals(""))
        return 0;
        String delimiter = ","; // Default assume , as delimiter

        if(number.startsWith("//"))
        {
         delimiter = String.valueOf(number.charAt(2));
         number = number.substring(5,number.length());
        }
        String sanitized = replaceNewLine(number, delimiter);
        int[] numbers = Arrays.stream(sanitized.split(delimiter)).mapToInt(Integer::parseInt).toArray();

        if(Arrays.stream(numbers).anyMatch(e -> e < 0)){
            Integer negativeNumber = Arrays.stream(numbers).filter(e -> e < 0).findFirst().orElse(0);
            throw new Exception("negatives not allowed :" + negativeNumber.toString());
        }

        int sum = Arrays.stream(numbers).sum();
        return sum;
    }

    private String replaceNewLine(String str, String delimiter){
        return str.replaceAll(Matcher.quoteReplacement("\n"),delimiter);
    }
}
