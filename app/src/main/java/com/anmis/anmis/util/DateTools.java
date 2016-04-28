package com.anmis.anmis.util;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yuanlei on 15/6/16.
 */
public class DateTools {
    /*
	 * 将时间戳转为字符串 ，格式：yyyy-MM-dd HH:mm
	 */
    public static String getStrTime_ymd_hm(String cc_time) {
        String re_StrTime = "";
        if(TextUtils.isEmpty(cc_time) || "null".equals(cc_time)){
            return re_StrTime;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;

    }

    /*
     * 将时间戳转为字符串 ，格式：yyyy-MM-dd HH:mm:ss
     */
    public static String getStrTime_ymd_hms(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;

    }

    public static String getStrFullTime(Long cc_time){
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        re_StrTime = sdf.format(new Date(cc_time));
        return re_StrTime;
    }
    /**
    /*
     * 将时间戳转为字符串 ，格式：yyyy.MM.dd
     */
    public static String getStrTime_ymd(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /*
     * 将时间戳转为字符串 ，格式：yyyy
     */
    public static String getStrTime_y(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }



    /*
     * 将时间戳转为字符串 ，格式：MM-dd
     */
    public static String getStrTime_md(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /*
     * 将时间戳转为字符串 ，格式：HH:mm
     */
    public static String getStrTime_hm(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /*
     * 将时间戳转为字符串 ，格式：HH:mm:ss
     */
    public static String getStrTime_hms(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /*
     * 将时间戳转为字符串 ，格式：MM-dd HH:mm:ss
     */
    public static String getNewsDetailsDate(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /*
     * 将字符串转为时间戳
     */
    public static String getTime() {
        String re_time = null;
        long currentTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date d;
        d = new Date(currentTime);
        long l = d.getTime();
        String str = String.valueOf(l);
        re_time = str.substring(0, 10);
        return re_time;
    }

    /*
     * 将时间戳转为字符串 ，格式：yyyy.MM.dd  星期几
     */
    public static String getSection(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  EEEE");
//		对于创建SimpleDateFormat传入的参数：EEEE代表星期，如“星期四”；MMMM代表中文月份，如“十一月”；MM代表月份，如“11”；
//		yyyy代表年份，如“2010”；dd代表天，如“25”
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    public static String getTimeLine(String time){
        String temp;
        String temp1;
        String temp2;
        if (time.contains("月")){
            temp = time.replace("年","-");
        }else {
            temp = time.replace("年","");
            return temp;
        }
        if (time.contains("日")){
            temp1 = temp.replace("月","-");
            temp2 = temp1.replace("日","");
            return temp2;
        }else{
            temp1 = temp.replace("月","");
            return temp1;
        }
    }

    public static int getDays(long dateBegin,long dateEnd){
        long day = dateEnd - dateBegin;
        int day1 = (int)(day/1000/60/60/24) + 1;
        return day1;
    }

    public static String getMonthStr(long dateBegin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String monthStr = sdf.format(new Date(dateBegin));
        return monthStr;
    }

    public static int getMonth(long dateBegin){
        Date d = new Date(dateBegin);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int month = c.get(Calendar.MONTH)+1;
        return month;
    }


}
