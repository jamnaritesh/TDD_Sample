package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;
import java.util.regex.Matcher;

public class StringCalculator {
    public int add(String number){
        if(number.equals(""))
        return 0;
        String sanitized = replaceNewLine(number);
        System.out.println(sanitized);
        int sum = Arrays.stream(Arrays.stream(sanitized.split(",")).mapToInt(Integer::parseInt).toArray()).sum();
        return sum;
    }

    private String replaceNewLine(String str){
        return str.replaceAll(Matcher.quoteReplacement("\n"),",");
    }
}
