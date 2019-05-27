package test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar2 = Calendar.getInstance();
		  SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		  calendar2.add(Calendar.DATE, 3);
		  String three_days_after = sdf2.format(calendar2.getTime());
		  System.out.println(three_days_after);
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          System.out.println(df.format(calendar2.getTime()));// new Date()为获取当前系统时间
	}

}
