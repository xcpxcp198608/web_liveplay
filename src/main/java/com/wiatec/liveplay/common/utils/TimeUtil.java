package com.wiatec.liveplay.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author patrick
 */
public class TimeUtil {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    public static final long DEFAULT_TIME = 1483200000000L;

    public static void main (String [] args){
        long unixFromStr = getUnixFromStr("2018-02-06 00:00:00");
        System.out.println(unixFromStr);

        boolean outExpires = isOutExpires("2018-02-08 00:00:00");
        System.out.println(outExpires);

        String strTime = getStrTime(DEFAULT_TIME);
        System.out.println(strTime);

//        Date date = new Date(1519200000000L);
        Date date = new Date(1519200000000L);
        boolean b = date.after(new Date());
        System.out.println(b);

        Date d = new Date("2018-02-28 00:00:00");
        System.out.println(d);
    }


    public static long getUnixFromStr(String time){
        if(TextUtil.isEmpty(time)){
            return 0;
        }
        Date date;
        try {
            date = FORMATTER.parse(time);
        } catch (ParseException e) {
            return 0;
        }
        return date.getTime();
    }

    public static String getStrTime(){
        return getStrTime(System.currentTimeMillis());
    }

    public static String getStrTime(long time){
        try {
            return FORMATTER.format(new Date(time));
        } catch (Exception e) {
            return "";
        }
    }

    public static String getStrDate(){
        return getStrDate(System.currentTimeMillis());
    }

    public static String getStrDate(long time){
        try {
            return DATE_FORMATTER.format(new Date(time));
        } catch (Exception e) {
            return "";
        }
    }

    public static String getExpiresTimeByDay(String activateTime, int days){
        Date date = new Date(TimeUtil.getUnixFromStr(activateTime));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        return getStrTime(date.getTime());
    }

    public static String getExpiresTime(String activateTime, int expires){
        Date date = new Date(TimeUtil.getUnixFromStr(activateTime));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, expires);
        date = calendar.getTime();
        return getStrTime(date.getTime());
    }

    public static String getExpiresDate(String activateTime, int expires){
        Date date = new Date(TimeUtil.getUnixFromStr(activateTime));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, expires);
        date = calendar.getTime();
        return getStrDate(date.getTime());
    }

    public static Date getExpiresDate(int expires){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, expires);
        return calendar.getTime();
    }

    public static boolean isOutExpires(String activateTime, int expires){
        Date date = new Date(TimeUtil.getUnixFromStr(activateTime));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, expires);
        date = calendar.getTime();
        return System.currentTimeMillis() > date.getTime();
    }

    public static boolean isOutExpires(String expiresTime) {
        System.out.println(expiresTime);
        long uTime = TimeUtil.getUnixFromStr(expiresTime);
        long sys = System.currentTimeMillis();
        System.out.println("ex: " + uTime);
        System.out.println("sys: " + sys);
        return uTime > 0 && sys > uTime;
    }


    public static String getCurrentStringTime(){
        long time = System.currentTimeMillis();
        return FORMATTER.format(new Date(time));
    }

    public static long getUnixTimeFromString(String strTime){
        try {
            Date date = FORMATTER.parse(strTime);
            return date.getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    public static String formatDuration(long duration){
        int dx ;
        int dm ;
        int x = (int) (duration /1000);
        if(x > 60){
            dx = x % 60;
        }else{
            dx = x;
        }
        int minute = x / 60;
        if(minute > 60){
            dm = minute % 60;
        }else{
            dm = minute;
        }
        int hour = minute / 60;
        return ""+ hour + ":"+ dm +":"+ dx;
    }
}
