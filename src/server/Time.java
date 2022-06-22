package server;

/**
 * 时间转换类
 * 用于记录用户最近一次签到时间
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Time {
	
	//将当前日期字符串转换为日期类并返回
	public Date getDate(String timeStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	//将当前日期类转换为日期字符串并返回
	public String getTimeStr(Date date){    
		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		String timeStr = format.format(date);   
		
		return timeStr;    
	}
}
