package cn.larry.demo.Utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author larryfu  all rights reserved
 */
public class TimeUtils {

    public static final String BASE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private TimeUtils() {
    }


    @SuppressWarnings("deprecation")
    public static Date getDate(String date) {
        if (date == null || date.equals("至今") || isBlank(date))
            return null;
        if (date.length() >= 18) {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int dat = Integer.parseInt(date.substring(8, 10));
            int hour = Integer.parseInt(date.substring(11, 13));
            int min = Integer.parseInt(date.substring(14, 16));
            int second = Integer.parseInt(date.substring(17, 19));
            return new Date(year - 1900, month - 1, dat, hour, min, second);
        } else {
            String year = RegexUtils.getFirstMatch("\\d{4}\\D?", date);
            if (year == null)
                return null;
            date = date.substring(year.length());
            year = year.substring(0, 4);
            List<String> timeNums = RegexUtils.getMatch("\\d{1,2}", date);
            int len = timeNums.size();
            String[] nums = {"1", "1", "0", "0", "0"};
            for (int i = 0; i < len && i < 5; i++) {
                String str = timeNums.get(i);
                //str = str.substring(1);
                nums[i] = str;
            }
            LocalDateTime ldt = LocalDateTime.of(parseInt(year), parseInt(nums[0]), parseInt(nums[1]), parseInt(nums[2]), parseInt(nums[3]), parseInt(nums[4]));
            return Date.from(ldt.toInstant(ZoneOffset.ofHours(8)));
        }
    }

    private static int parseInt(String num) {
        if (num == null)
            return 0;
        else
            return Integer.parseInt(num);
    }

    public static Date parseDate(String time) {
        return parseDate(time, BASE_PATTERN);
    }

    public static Date parseDate(String time, String pattern) throws IllegalArgumentException {
        try {
            if (time == null)
                return null;
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("时间格式不合法");
        }
    }



    public static String getWorkLength(Date start, Date end) {
        if (start == null)
            return null;
        if (end == null)
            end = new Date();
        int years = end.getYear() - start.getYear();
        int month = end.getMonth() - start.getMonth();
        if (month < 0) {
            years--;
            month += 12;
        }
        String yearStr = "";
        String monthStr = "";
        if (years != 0)
            yearStr = years + "年";
        if (month > 0)
            monthStr = month + "个月";
        return yearStr + monthStr;
    }

    public static String getTimeInDailyStyle(int time) {
        try {
            time = time / 1000;
            int second = time % 60;
            int mins = time / 60;
            int min = mins % 60;
            int hour = mins / 60;
            String hourStr = (hour == 0 ? "" : hour + "时");
            String minStr = (min == 0 ? "" : min + "分");
            return hourStr + minStr + second + "秒";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getTimeBySecond(int time) {
        try {
            time = time / 1000;
            return time + "秒";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formateDate(Date date) {
        return formateDate(date, BASE_PATTERN);
    }

    public static String formateDate(Date date, String pattern) {
        if (date == null)
            return null;

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }


    public static String dateCaculate(String date, int days) {
        String str = date;
        SimpleDateFormat formatter = new SimpleDateFormat(BASE_PATTERN);
        try {
            Date myDate = formatter.parse(str);
            return dateCaculate(myDate, days);
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }


    public static String dateCaculate(Date date, int days) {
        SimpleDateFormat formatter = new SimpleDateFormat(BASE_PATTERN);
        try {
            date = caculateDate(date, days);
            return formatter.format(date);
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static Date caculateDate(Date date, int days) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, days);
            return c.getTime();
        } catch (Exception e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static String getTimeOnlyWithNumber() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(new Date());

    }

    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat(BASE_PATTERN);
        return formatter.format(new Date());
    }

    public static String formateEndTimeString(String time) {
        return formateTimeString(time, "end");
    }

    public static String formateTimeString(String time, String type) {
        if (time == null || time.length() < 10) {
            return "";
        }
        if (time.length() < 14) {
            if (type.toLowerCase().equals("end")) {
                time += " 23:59:59";
            } else {
                time += " 00:00:00";
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat(BASE_PATTERN);
        Date myDate = null;
        try {
            myDate = formatter.parse(time);
            String timeStr = formatter.format(myDate);
            return timeStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formateTimeString(String time) {
        return formateTimeString(time, "start");
    }


    public static Date caculateDate(Date date, String type, int days) {
        if (date == null)
            date = new Date();
        date = caculateDate(date, days);
        if (type == null)
            return date;
        String dateStr = formateDate(date, "yyyy-MM-dd");
        if (type.equals("end"))
            dateStr += " 23:59:59";
        else if (type.equals("start"))
            dateStr += " 00:00:00";
        return parseDate(dateStr, BASE_PATTERN);
    }

    /**
     * 获取当前时间字符串，格式：20150226
     * @author 王亚南 347576073@qq.com
     * @date 2016/2/26 16:33
     */
    public static String getCurrentDate() {
        Date date = new Date();
        return formateDate(date, "yyyyMMdd");
    }

    /**
     * 将时间戳转化成标准的简历格式数据
     * @param time 时间戳
     * @return Date
     * @author WangYanan 347576073@qq.com
     * @date 2016年2月24日 上午10:05:17
     */
    public static Date toDateFromLong(Long time){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = formatter.format(time);
            Date date = formatter.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
