package com.ccsoft.yunqudao.utils;

import java.math.BigDecimal;

/**
 * Created by lixinke on 2018/5/29.
 */

public class DataUtils {

    public static String getTime(int finishTime){
        String day;
        String hour;
        String min;
        String sec;
        BigDecimal bigDecimal = new BigDecimal(System.currentTimeMillis());
        bigDecimal = bigDecimal.divide(new BigDecimal(1000)).setScale(0,BigDecimal.ROUND_HALF_UP);

        int timeDifference = finishTime-bigDecimal.intValue();

        if(timeDifference>0){
            day = String.valueOf((int)timeDifference /86400);
            hour = String.valueOf((int)timeDifference%86400/3600);
            min = String.valueOf((int)timeDifference%86400%3600/60);
            sec = String.valueOf((int)timeDifference%86400%3600%60);
        }else{
            day = "0";
            hour = "0";
            min = "0";
            sec = "0";
        }

        return day+"-"+hour+"-"+min+"-"+sec;

    }
}
