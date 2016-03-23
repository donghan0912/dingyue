package hpu.dingyue.commonUtils;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/17.
 */
public class TimeUtils {

    /*
    时间间隔计算规则：
    例如：起始时间：2016:03:17 23 : 00：00
    结束时间：2016:03:17 23 : 59 : 59，间隔天数为0
    起始时间：2016:03:17 23 : 00：00
    结束时间：2016:03:18 00 : 00 : 00，间隔天数为1
    */

    /**
     * 获取相差天数
     * @param beginTime
     * @param endTime
     * @return
     */
    public static int getDiscrepantDays(long beginTime, long endTime) {
        Date registerDay = new Date(beginTime);
        Date currentDay = new Date(endTime);
        return (int) ((currentDay.getTime() - registerDay.getTime()) / 1000 / 60 / 60 / 24);
    }

    /**
     * 获取相隔天数
     * @param time
     * @param registerTime
     * @return
     */
    public static int getApartDay(long time, long registerTime) {
        Date registerDay = new Date(registerTime);
        Date currentDay = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDate = sdf.parse(sdf.format(registerDay));
            Date endDate = sdf.parse(sdf.format(currentDay));
            return (int) ((endDate.getTime() - beginDate.getTime()) / 1000 / 60 / 60 / 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 判断是否在同一天
     * @param time
     * @param registerTime
     * @return
     */
    public static boolean isSameDay(long time, long registerTime) {
        Date registerDay = new Date(registerTime);
        Date currentDay = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ds1 = sdf.format(registerDay);
        String ds2 = sdf.format(currentDay);
        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }
    }
}
