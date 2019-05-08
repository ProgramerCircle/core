package com.circle.core.util;

import java.util.*;

public class CalendarUtils {

    private static Calendar cal = Calendar.getInstance();

    public static Integer getYear(){
        return cal.get(Calendar.YEAR);
    }

    public static Integer getMonth(){
        return cal.get(Calendar.MONTH);
    }

    public static Integer getDate(){
        return cal.get(Calendar.DATE);
    }

    public static Integer getHour(){
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static Integer getMinute(){
        return cal.get(Calendar.MINUTE);
    }

    public static Integer getSecond(){
        return cal.get(Calendar.SECOND);
    }

    public static void main(String[] abc) {
        int y, m, d, h, mi, s;
        Calendar cal = Calendar.getInstance();
        y = cal.get(Calendar.YEAR);
        m = cal.get(Calendar.MONTH);
        d = cal.get(Calendar.DATE);
        h = cal.get(Calendar.HOUR_OF_DAY);
        mi = cal.get(Calendar.MINUTE);
        s = cal.get(Calendar.SECOND);
        System.out.println("现在时刻是" + y + "年" + m + "月" + d + "日" + h + "时" + mi + "分" + s + "秒");
    }
}
