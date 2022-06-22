package server;

/**
 * ʱ��ת����
 * ���ڼ�¼�û����һ��ǩ��ʱ��
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Time {
	
	//����ǰ�����ַ���ת��Ϊ�����ಢ����
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
	
	//����ǰ������ת��Ϊ�����ַ���������
	public String getTimeStr(Date date){    
		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
		String timeStr = format.format(date);   
		
		return timeStr;    
	}
}
