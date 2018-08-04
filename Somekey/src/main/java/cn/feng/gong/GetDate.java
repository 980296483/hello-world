package cn.feng.gong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static Date getDate(String date) throws ParseException {
		
		if("yyyy-MM-dd HH:mm:ss".equals(date)) {
			SimpleDateFormat fs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date data=fs.parse(date);
		
		return data;
		
		}
		return null;
	}
}
