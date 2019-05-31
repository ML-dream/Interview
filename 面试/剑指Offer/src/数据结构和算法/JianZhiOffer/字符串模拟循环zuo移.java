package 数据结构和算法.JianZhiOffer;

/*
 * 方法一：使用字符串直接截取然后放在相应的位置，最简单粗暴，但是没有任何意义
 * 方法二：利用反转字符串的方法！但是分为两种
 * 			第一：自己写反转的方法
 * 			第二：利用已经有的方法进行反转
 * 
 */
public class 字符串模拟循环zuo移 {

	public static void main(String[] args) {
		System.out.println(LeftRotateString1("",6));
	}
//	方法一
	public static String LeftRotateString1(String str,int n) {
//	注意：牵扯到相应的%运算，一定是要被除数注意不能为0 ----java.lang.ArithmeticException: / by zero
		if(str.length() == 0) return "";
		return str.substring(n%str.length())+str.substring(0, n%str.length());
        
    }
//	方法一扩展：使用stringBuffer
	    public static String LeftRotateString(String str,int n) {
	        if(str.length() == 0){
	            return str;
	        }
	        StringBuffer buffer = new StringBuffer(str);
	        StringBuffer buffer1 = new StringBuffer(str);
	        StringBuffer buffer2 = new StringBuffer();
	        buffer.delete(0,n);
	        buffer1.delete(n,str.length());
	        buffer2.append(buffer.toString()).append(buffer1.toString());
	        return buffer2.toString();
	    }
	    
//	    方法二：使用自己反转的方法：
//	    abdce  --  badce  --  baecd ---  dceab           dceab
	   

	    	public String LeftRotateString2(String str,int n) {
	    	        char[] chars = str.toCharArray();        
	    	        if(chars.length < n) return "";
	    	        reverse(chars, 0, n-1);
	    	        reverse(chars, n, chars.length-1);
	    	        reverse(chars, 0, chars.length-1);
	    	        return new String(chars); 
	    	        /*  StringBuilder sb = new StringBuilder(chars.length);
	    	        for(char c:chars){
	    	            sb.append(c);
	    	        }
	    	        return sb.toString();*/
	    	    }
//	    	    如果自己不写这个方法，那么就使用StringBufer的自带的reverse的方法！
	    	    public void reverse(char[] chars,int low,int high){
	    	        char temp;
//	    	       技巧：使用while（low《high）或者在里面进行if的判断，是保证仅仅遍历一半的技巧！
	    	        while(low<high){
	    	            temp = chars[low];
	    	            chars[low] = chars[high];
	    	            chars[high] = temp;
	    	            low++;
	    	            high--;
	    	        }
	    	    }
	    
	    
	}


