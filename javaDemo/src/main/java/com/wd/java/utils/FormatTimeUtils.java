package com.wd.java.utils;

/**
 * @description: 
 * 如果只有50秒，就显示50秒
 * 如果有1分钟以上，就显示1分钟XX秒
 * 如果有1小时以上，就显示x小时y分钟z秒
 * @author: ZhuoJie
 * @create: 2021-03-23 19:43
 **/
public class FormatTimeUtils {
    
    public static void main(String[] args) {
        long num=Integer.MAX_VALUE;
//        long num=Integer.MAX_VALUE+1;
//        long num=60*60*24*10;
        System.out.println(Integer.toHexString(-Integer.MAX_VALUE));
        System.out.println(Long.toHexString(num));
        System.out.println(formatTime(num/500));
    }

    /**
     * 把秒数转天数
     * @param ms 秒
     * @return
     */
    public static String formatTime(Long ms) {
        Integer ss = 1;
        Integer mm = ss * 60;
        Integer hh = mm * 60;
        Integer dd = hh * 24;
        
        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mm;
        Long second = (ms - day * dd - hour * hh - minute * mm) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mm - second * ss;
        
        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分");
        }
        if (second > 0) {
            sb.append(second + "秒");
        }
        if (milliSecond > 0) {
            sb.append(milliSecond + "毫秒");
        }
        return String.valueOf(sb);
    }
}
