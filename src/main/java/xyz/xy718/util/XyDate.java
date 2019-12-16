package xyz.xy718.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class XyDate {
	
    private static final Logger logger = LoggerFactory.getLogger(XyDate.class);
	
	public static String APIDatetoWebDate(String APIDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd-HHmmss").parse(APIDate);
		} catch (Exception e) {
			logger.error("----"+APIDate);
			e.printStackTrace();
		} 
		String now = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
		return now;
	}
	public static String WebDatetoaAPIDate(String WebDate){
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").parse(WebDate);
		} catch (Exception e) {
			logger.error("----"+WebDate);
			e.printStackTrace();
		} 
		String now = new SimpleDateFormat("yyyyMMdd-HHmmss").format(date);
		return now;
	}
	
	 /**
	  * 获取现在时间
	  * 
	  * @return 返回时间类型 yyyyMMdd-HHmmss
	 * @throws ParseException 
	  */
	 public static String getNowAPIDateTime() {
		 String res;
		 SimpleDateFormat dFormat=new SimpleDateFormat("yyyyMMdd-HHmmss");
		 res=dFormat.format(new Date());
	     return res;
	 }

	 /**
	  * 获取现在时间
	  * 
	  * @return 返回时间类型yyyy-MM-dd HH:mm:ss
	 * @throws ParseException 
	  */
	 public static String getNowWEBDateTime() {
		 String res;
		 SimpleDateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 res=dFormat.format(new Date());
	     return res;
	 }

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     * @param timestampString 时间戳 如："1473048265";
     * @param formats 要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     *
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2WebDate(String timestampString) {
    	if(timestampString==null)
    	{
    		return "";
    	}
        Long timestamp = Long.parseLong(timestampString)*1000;
        String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date(timestamp));
        return date;
    }
    /**
     * 比较两个API格式的时间
     * 1>2就返回true
     * @param time1
     * @param time2
     * @return
     */
    public static boolean APITime1Than2(String time1,String time2) {
    	DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");//创建日期转换对象HH:mm:ss为时分秒，年月日为yyyy-MM-dd
		try {
			Date dt1 = df.parse(time1);//将字符串转换为date类型
			Date dt2 = df.parse(time2);
			if(dt1.getTime()>dt2.getTime())//比较时间大小,如果dt1大于dt2
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
    }
    public static String WechatPayTime2WebDate(String time) {
    	if(time==null)
    	{
    		return "";
    	}
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMddHHmmss").parse(time);
		} catch (Exception e) {
			logger.error("----"+time);
			e.printStackTrace();
		} 
		String now = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
		return now;
    }
    
	 public static Date webStringToDate(String time)
	 {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 Date date = null;
		 try { 
			 date = sdf.parse(time);
		 } catch (ParseException e) { 
			 e.printStackTrace(); 
		 }
		 return date;
	 }
	 
	 	 /**
		 * 10位int型的时间戳转换为API String(yyyy-MM-dd HH:mm:ss)
		 * @param time
		 * @return
		 */
		public static String timestampToAPITime(Integer time){
			//int转long时，先进行转型再进行计算，否则会是计算结束后在转型
			long temp = (long)time*1000;
			Timestamp ts = new Timestamp(temp);  
	        String tsStr = "";  
	        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");  
	        try {  
	            //方法一  
	            tsStr = dateFormat.format(ts);  
	            System.out.println(tsStr);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
			return tsStr;  
		}
		/**
		 * 10位int型的时间戳转换为 WEBString(yyyy-MM-dd HH:mm:ss)
		 * @param time
		 * @return
		 */
		public static String timestampToWEBTime(Integer time){
			//int转long时，先进行转型再进行计算，否则会是计算结束后在转型
			long temp = (long)time*1000;
			Timestamp ts = new Timestamp(temp);  
	        String tsStr = "";  
	        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");  
	        try {  
	            //方法一  
	            tsStr = dateFormat.format(ts);  
	            System.out.println(tsStr);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
			return tsStr;  
		}
		/**
		  * 获取现在时间
		  * 
		  * @return 返回时间类型 yyyyMMdd-HHmmss
		 * @throws ParseException 
		  */
		 public static String getNowDate() {
			 String res;
			 SimpleDateFormat dFormat=new SimpleDateFormat("yyyyMMdd-HHmmss");
			 res=dFormat.format(new Date());
		     return res;
		 }
		
		 /**
		  * 获取现在时间
		  * 
		  * @return返回短时间格式 yyyyMMdd
		  */
		 public static String getNowDateShort() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
		
		 /**
		  * 获取现在时间
		  * 
		  * @return返回字符串格式 yyyyMMdd-HHmmss
		  */
		 public static String getStringDate() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
		
		 /**
		  * 获取现在时间
		  * 
		  * @return 返回短时间字符串格式yyyyMMdd
		  */
		 public static String getStringDateShort() {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
		
		 /**
		  * 获取时间 小时:分;秒 HH:mm:ss
		  * 
		  * @return
		  */
		 public static String getTimeShort() {
		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		  Date currentTime = new Date();
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
		
		 /**
		  * 将长时间格式字符串转换为时间 yyyyMMdd-HHmmss
		  * 
		  * @param strDate
		  * @return
		  */
		 public static Date strToDateLong(String strDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(strDate, pos);
		  return strtodate;
		 }
		
		 /**
		  * 将长时间格式时间转换为字符串 yyyyMMdd-HHmmss
		  * 
		  * @param dateDate
		  * @return
		  */
		 public static String dateToStrLong(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  String dateString = formatter.format(dateDate);
		  return dateString;
		 }
		
		 /**
		  * 将短时间格式时间转换为字符串 yyyyMMdd
		  * 
		  * @param dateDate
		  * @param k
		  * @return
		  */
		 public static String dateToStr(java.util.Date dateDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  String dateString = formatter.format(dateDate);
		  return dateString;
		 }
		
		 /**
		  * 将短时间格式字符串转换为时间 yyyyMMdd 
		  * 
		  * @param strDate
		  * @return
		  */
		 public static Date strToDate(String strDate) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(strDate, pos);
		  return strtodate;
		 }
		
		 /**
		  * 得到现在时间
		  * 
		  * @return
		  */
		 public static Date getNow() {
		  Date currentTime = new Date();
		  return currentTime;
		 }
		
		 /**
		  * 提取一个月中的最后一天
		  * 
		  * @param day
		  * @return
		  */
		 public static Date getLastDate(long day) {
		  Date date = new Date();
		  long date_3_hm = date.getTime() - 3600000 * 34 * day;
		  Date date_3_hm_date = new Date(date_3_hm);
		  return date_3_hm_date;
		 }
		
		
		 /**
		  * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
		  * 
		  * @param sformat
		  *            yyyyMMddhhmmss
		  * @return
		  */
		 public static String getUserDate(String sformat) {
		  Date currentTime = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		  String dateString = formatter.format(currentTime);
		  return dateString;
		 }
		
		 /**
		  * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
		  */
		 public static String getTwoHour(String st1, String st2) {
		  String[] kk = null;
		  String[] jj = null;
		  kk = st1.split(":");
		  jj = st2.split(":");
		  if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
		   return "0";
		  else {
		   double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
		   double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
		   if ((y - u) > 0)
		   {
		    return y - u + "";
		   }else {
		    return "0";
		   }
		  }
		 }
		
		 /**
		  * 得到二个日期间的间隔天数
		  */
		 public static String getTwoDay(String sj1, String sj2) {
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
		  long day = 0;
		  try {
		   java.util.Date date = myFormatter.parse(sj1);
		   java.util.Date mydate = myFormatter.parse(sj2);
		   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		  } catch (Exception e) {
		   return "";
		  }
		  return day + "";
		 }
		
		 /**
		  * 时间前推或后推分钟,其中JJ表示分钟.
		  */
		 public static String getPreTime(String sj1, String jj) {
		  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  String mydate1 = "";
		  try {
		   Date date1 = format.parse(sj1);
		   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
		   date1.setTime(Time * 1000);
		   mydate1 = format.format(date1);
		  } catch (Exception e) {
		  }
		  return mydate1;
		 }
		
		 /**
		  * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
		  */
		 public static String getNextDay(String nowdate, String delay) {
		  try{
		  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		  String mdate = "";
		  Date d = strToDate(nowdate);
		  long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
		  d.setTime(myTime * 1000);
		  mdate = format.format(d);
		  return mdate;
		  }catch(Exception e){
		   return "";
		  }
		 }
		
		 /**
		  * 判断是否润年
		  * 
		  * @param ddate
		  * @return
		  */
		 public static boolean isLeapYear(String ddate) {
		
		  /**
		   * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		   * 3.能被4整除同时能被100整除则不是闰年
		   */
		  Date d = strToDate(ddate);
		  GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		  gc.setTime(d);
		  int year = gc.get(Calendar.YEAR);
		  if ((year % 400) == 0) {
		   return true;
		  }else if ((year % 4) == 0) {
		   if ((year % 100) == 0) {
		    return false;
		   }else {
		    return true;
		   }
		  } else {
		   return false;
		  }
		 }
		
		 /**
		  * 返回美国时间格式 26 Apr 2006
		  * 
		  * @param str
		  * @return
		  */
		 public static String getEDate(String str) {
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		  ParsePosition pos = new ParsePosition(0);
		  Date strtodate = formatter.parse(str, pos);
		  String j = strtodate.toString();
		  String[] k = j.split(" ");
		  return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
		 }
		
		 /**
		  * 获取一个月的最后一天
		  * 
		  * @param dat
		  * @return
		  */
		 public static String getEndDateOfMonth(String dat) {// yyyyMMdd
		  String str = dat.substring(0, 8);
		  String month = dat.substring(5, 7);
		  int mon = Integer.parseInt(month);
		  if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
		   str += "31";
		  } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
		   str += "30";
		  } else {
		   if (isLeapYear(dat)) {
		    str += "29";
		   } else {
		    str += "28";
		   }
		  }
		  return str;
		 }
		
		 /**
		  * 判断二个时间是否在同一个周
		  * 
		  * @param date1
		  * @param date2
		  * @return
		  */
		 public static boolean isSameWeekDates(Date date1, Date date2) {
		  Calendar cal1 = Calendar.getInstance();
		  Calendar cal2 = Calendar.getInstance();
		  cal1.setTime(date1);
		  cal2.setTime(date2);
		  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		  if (0 == subYear) {
		   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		    return true;
		   }
		  } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
		   // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
		   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		    return true;
		   }
		  } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
		   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)) {
		    return true;
		   }
		  }
		  return false;
		 }
		
		 /**
		  * 产生周序列,即得到当前时间所在的年度是第几周
		  * 
		  * @return
		  */
		 public static String getSeqWeek() {
		  Calendar c = Calendar.getInstance(Locale.CHINA);
		  String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		  if (week.length() == 1) {
		   week = "0" + week;
		  }
		  String year = Integer.toString(c.get(Calendar.YEAR));
		  return year + week;
		 }
		
		 /**
		  * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
		  * 
		  * @param sdate
		  * @param num
		  * @return
		  */
		 public static String getWeek(String sdate, String num) {
		  // 再转换为时间
		  Date dd = XyDate.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(dd);
		  if (num.equals("1")) { // 返回星期一所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		  }else if (num.equals("2")) { // 返回星期二所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		  }else if (num.equals("3")) { // 返回星期三所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		  }else if (num.equals("4")) { // 返回星期四所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		  }else if (num.equals("5")) {// 返回星期五所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		  }else if (num.equals("6")) {// 返回星期六所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		  }else if (num.equals("0")) {// 返回星期日所在的日期
		   c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		  }
		  return new SimpleDateFormat("yyyyMMdd").format(c.getTime());
		 }
		
		 /**
		  * 根据一个日期，返回是星期几的字符串
		  * 
		  * @param sdate
		  * @return
		  */
		 public static String getWeek(String sdate) {
		  // 再转换为时间
		  Date date = XyDate.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  // int hour=c.get(Calendar.DAY_OF_WEEK);
		  // hour中存的就是星期几了，其范围 1~7
		  // 1=星期日 7=星期六，其他类推
		  return new SimpleDateFormat("EEEE").format(c.getTime());
		 }
		 public static String getWeekStr(String sdate){
		  String str = "";
		  str = XyDate.getWeek(sdate);
		  if("1".equals(str)){
		   str = "星期日";
		  }else if("2".equals(str)){
		   str = "星期一";
		  }else if("3".equals(str)){
		   str = "星期二";
		  }else if("4".equals(str)){
		   str = "星期三";
		  }else if("5".equals(str)){
		   str = "星期四";
		  }else if("6".equals(str)){
		   str = "星期五";
		  }else if("7".equals(str)){
		   str = "星期六";
		  }
		  return str;
		 }
		
		 /**
		  * 两个时间之间的天数
		  * 
		  * @param date1
		  * @param date2
		  * @return
		  */
		 public static long getDays(String date1, String date2) {
		  if (date1 == null || date1.equals("")) {
		   return 0;
		  }
		  if (date2 == null || date2.equals("")) {
		   return 0;
		  }
		  // 转换为标准时间
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
		  java.util.Date date = null;
		  java.util.Date mydate = null;
		  try {
		   date = myFormatter.parse(date1);
		   mydate = myFormatter.parse(date2);
		  } catch (Exception e) {
		  }
		  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		  return day;
		 }
		
		 /**
		  * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
		  * 此函数返回该日历第一行星期日所在的日期
		  * 
		  * @param sdate
		  * @return
		  */
		 public static String getNowMonth(String sdate) {
		  // 取该时间所在月的一号
		  sdate = sdate.substring(0, 8) + "01";
		
		  // 得到这个月的1号是星期几
		  Date date = XyDate.strToDate(sdate);
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  int u = c.get(Calendar.DAY_OF_WEEK);
		  String newday = XyDate.getNextDay(sdate, (1 - u) + "");
		  return newday;
		 }
		
		 /**
		  * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
		  * 
		  * @param k
		  *            表示是取几位随机数，可以自己定
		  */
		
		 public static String getNo(int k) {
		
		  return getUserDate("yyyyMMddhhmmss") + getRandom(k);
		 }
		
		 /**
		  * 返回一个随机数
		  * 
		  * @param i
		  * @return
		  */
		 public static String getRandom(int i) {
		  Random jjj = new Random();
		  // int suiJiShu = jjj.nextInt(9);
		  if (i == 0) {
		   return "";
		  }
		  String jj = "";
		  for (int k = 0; k < i; k++) {
		   jj = jj + jjj.nextInt(9);
		  }
		  return jj;
		 }
		
		 /**
		  * 
		  * @param args
		  */
		 public static boolean RightDate(String date) {
		
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  ;
		  if (date == null) {
		   return false;
		  }
		  if (date.length() > 10) {
		   sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  } else {
		   sdf = new SimpleDateFormat("yyyyMMdd");
		  }
		  try {
		   sdf.parse(date);
		  } catch (ParseException pe) {
		   return false;
		  }
		  return true;
		 }
		 /**
		  * 获取几小时后的时间
		  * 
		  * @param int hour
		  * @return yyyyMMdd-HHmmss
		  */
		 public static String getTimeByHour(int hour) {
		
		     Calendar calendar = Calendar.getInstance();
		
		     calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hour);
		
		     return new SimpleDateFormat("yyyyMMdd-HHmmss").format(calendar.getTime());
		
		 }
		 /**
		  * 获取几小时前的时间
		  * 
		  * @param int hour
		  * @return yyyyMMdd-HHmmss
		  */
		 public static String getTimeBeforeHour(int hour) {
		
		     Calendar calendar = Calendar.getInstance();
		
		     calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
		
		     return new SimpleDateFormat("yyyyMMdd-HHmmss").format(calendar.getTime());
		
		 }
		 
		 /**
		  * 校验时间格式
		  * 
		  * @param String str
		  * @return boolean
		  */
		 public static boolean isValidDate(String str) {
		     boolean convertSuccess = true;
		     // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmss");
		     try {
		         // 设置lenient为false.
		         // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		         format.setLenient(false);
		         format.parse(str);
		     } catch (ParseException e) {
		         // e.printStackTrace();
		         // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		         convertSuccess = false;
		     }
		     return convertSuccess;
		 }
		 
		 public static long getMillis() {
			 return System.currentTimeMillis();
		}
		 
		 /**
		  * 计算时间差大小 yyyyMMdd-HHmmss
		  * 
		  * @param firstTime 早的时间
		  * @param secTime  晚的时间
		  * @return diff(ms)
		  */
	 	public static long mathTime(String firstTime,String secTime) throws ParseException {
			 DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		
			 Date d1 = df.parse(secTime);
			 Date d2 = df.parse(firstTime);
			 long diff = d1.getTime() - d2.getTime();
			 return diff;
		 }
}
