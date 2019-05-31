package 数据结构和算法.JianZhiOffer;
/*
 * 
 * 思路：需要判断的如下：
 * 			如果是正负号，后面一定是数字、或者e
 * 			如果是e，那么后面一定不能空；如果不是空，那么不能有小数点；不能有字母;也不能在有一个e；
 * 			不能包含其他字母
 * 			如果是有了小数点，后面不能再有了
 * 实在是做不出来了，不过大致的思路就是：一些限制条件，比如说，上面的，然后逐个进行判断，直到不满足返回fasle；
 * 
 * 看人家的代码需要的技巧：
 * 		1、使用flag，进行标识，可以不用每次进行return；
 * 
 * 
 */
public class 判断字符串是否表示数值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str={'1','0','0'};
		String a="-1E-16";
		//char[] str={'1','0','0'};
		System.out.println(('a'-'0'<9&&'a'-'0'>=0));
		System.out.println(isNumeric(a.toCharArray()));
	}
	
	public static boolean isNumeric(char[] str) {
		for(int i=0;i<str.length;i++) {
			if(str[i]=='+'||str[i]=='-') {
					if((i+1)>(str.length-1)) return false;
					if(!((str[i+1]-'0'<9||str[i+1]-'0'>=0)||str[i+1]=='e')) return false;
				
			}else if(str[i]=='e'||str[i]=='E') {
				if(i==str.length-1) return false;//如果是最后一个e；
				if(str[i+1]==' ') return false; //判断是不是后面为空
				for(int j=i+1;j<str.length;j++) {   //判断是不是后面还有一个e,及其小数点
					if(str[i+1]=='e'|str[i+1]=='.'|str[i+1]=='E') return false;
				} 
				
		}else if(!(str[i]=='e'||str[i]=='+'||str[i]=='-'||str[i]=='.'||str[i]=='E')) {
			if(!(str[i]-'0'<9&&str[i]-'0'>=0)) return false;
			
			
			}else if(str[i]=='.') {
				if(i==str.length-1) return false;//如果是最后一个e；
				for(int j=i+1;j<str.length;j++) {   //判断是不是后面还有一个e,及其小数点
					if(str[i+1]=='.') return false;
				}
				
			}
		}
		return true;
        
    }
	

}
