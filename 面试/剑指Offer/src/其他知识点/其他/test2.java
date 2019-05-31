package 其他知识点.其他;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar2 = Calendar.getInstance();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
		
		
		
        String time = sdf2.format(calendar2.getTime());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		

        	
        	calendar2.add(Calendar.DATE, 1);
        System.out.println(sdf2.format(calendar2.getTime()));
        ;
        	
        	System.out.println(calendar2.get(Calendar.DAY_OF_WEEK)-1);
   
        	calendar2.add(Calendar.DATE, 1);
    
	}

}
