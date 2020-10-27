package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;
import java.util.regex.Matcher;

public class StringCalculator {
    public int add(String number){
        if(number.equals(""))
        return 0;
        String delimiter = ","; // Default assume , as delimiter

        if(number.startsWith("//"))
        {
         delimiter = String.valueOf(number.charAt(2));
         number = number.substring(5,number.length());
        }
        String sanitized = replaceNewLine(number, delimiter);
        System.out.println(sanitized);
        int sum = Arrays.stream(Arrays.stream(sanitized.split(delimiter)).mapToInt(Integer::parseInt).toArray()).sum();
        return sum;
    }

    private String replaceNewLine(String str, String delimiter){
        return str.replaceAll(Matcher.quoteReplacement("\n"),delimiter);
    }
}
