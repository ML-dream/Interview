package 数据结构和算法.JianZhiOffer;
/*
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 总结：
 * 	1、注意思考前向遍历和后向遍历的移动数量！
 *  2、理解字符串截取和StringBuffer的方法的底层，才知道哪个更有效率！
 *  3、比较字符的时候，可以直接和数字比较，注意如果和空格比较，需要‘  ’，单引号加空格才可以
 */
public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String replaceSpace(StringBuffer str) {
		StringBuffer str1 = new StringBuffer();
//		char[] strArr = str.toString().toCharArray();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				str1.append('%');
				str1.append('2');
				str1.append('0');
			}else {
				str1.append(str.charAt(i));
			}
			
		}
		return str1.toString();
    	
    }

}
