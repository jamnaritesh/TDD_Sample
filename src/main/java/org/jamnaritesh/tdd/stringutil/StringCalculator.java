package org.jamnaritesh.tdd.stringutil;

import java.util.Arrays;

public class StringCalculator {
    public int add(String number){
        if(number.equals(""))
        return 0;
        int sum = Arrays.stream(Arrays.stream(number.split(",")).mapToInt(Integer::parseInt).toArray()).sum();
        return sum;
    }
}
