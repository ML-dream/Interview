package 数据结构和算法.JianZhiOffer;

public class 把字符串变成整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(StrToInt1("+2147483647"));
	}
		   
	
	public static int StrToInt1(String str) {
		if (str == null || str.trim().equals("")) {
            return 0;
        }
		int flag=1;
		int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            flag=-1;
        	start = 1;
        }
        int sum =0;
        for(int i=start;i<chars.length;i++) {
        	if(chars[i]<'0' || chars[i]>'9') return 0;
        	System.out.println(chars[i]);
        	sum=sum*10+(int)(chars[i]-'0');
        }
        return sum*flag;
	}
	
	
	
	
	public static boolean flag;
		    public static int StrToInt(String str) {
		        flag = false;
		        //判断输入是否合法
		        if (str == null || str.trim().equals("")) {
		            flag = true;
		            return 0;
		        }
		        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
		        int symbol = 0;
		        int start = 0;
		        char[] chars = str.trim().toCharArray();
		        if (chars[0] == '+') {
		            start = 1;
		        } else if (chars[0] == '-') {
		            start = 1;
		            symbol = 1;//存在的目的就是看是否是负数，和后面的逻辑没关系！
		        }
		        int result = 0;
		        for (int i = start; i < chars.length; i++) {
		            if (chars[i] > '9' || chars[i] < '0') {
		                flag = true;
		                return 0;
		            }
		            int sum= result * 10 + (int) (chars[i] - '0');
		             
		             
		            if((sum-(int) (chars[i] - '0'))/10!=result){
		                flag=true;
		                return 0;
		            }
		             
		            result=result * 10 + (int) (chars[i] - '0');
		            /*
		             * 本人认为java热门第一判断是否溢出是错误的，举个反例
		             * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
		             * 显然value>Integer.MAX_VALUE是不成立的
		            */
		        }
		        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
		        // 注意，当value=-2147483648时，value=-value
		        result = (int) Math.pow(-1, symbol) * result;
		        return result;
		    }
		

}
