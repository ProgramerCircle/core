package com.circle.core.util;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

public class RandomUtils {

    private static Random random = new Random(System.currentTimeMillis());


    public static int getNextInt(int min,int max){
        int num = random.nextInt(max-min+1) + min;
        return num;
    }

}
