package com.circle.core.util;

public class StringUtils {

    public static Boolean isEmptyOrBlank(String s){
        if(s == null){
            return true;
        }else{
            String s1 = s.trim();
            if(s1.equals("")){
                return true;
            }
            return false;
        }
    }
}
