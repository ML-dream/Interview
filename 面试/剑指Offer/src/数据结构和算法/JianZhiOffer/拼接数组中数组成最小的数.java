package 数据结构和算法.JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 
 */
public class 拼接数组中数组成最小的数 {

	public static void main(String[] args) {
		System.out.println("22245".compareTo("2322"));
		
		int [] numbers= {3,32,321};
		
		System.out.println(PrintMinNumber(numbers));
	}
	public static String PrintMinNumber(int [] numbers) {
		if(numbers.length<=0) return null;
		String[] numStr =new String[numbers.length];
		for(int i=0;i<numbers.length;i++) {
			numStr[i]=String.valueOf(numbers[i]);
		}
		
/*
 * 此处必须使用自定义的compartor的原因是：
 * 		首先String已经内部实现了comparable接口，我们无法自己二次实现；
 * 		所以必须使用自己实现comparator，然后设计比较规则！
 * 比较规则注意：
 * 		首先不能按照int 整数的比较大小，{4,32,111} 明显是错误的！
 * 		其次按照字符大小进行比较，但是还有{3,32,321}会排序成{3,32,321}这种问题，明显是错误的！
 * 		所以需要自定义其他规则：如下：更加严格保证不会由于字符长度不同造成的错误！
 * 注意：匿名内部类的使用！
 */
		Arrays.sort(numStr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);
			}
			
		});
		StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < numStr.length; i++)
        {
            stringBuilder.append(numStr[i]);
        }
        	String result = stringBuilder.toString();
		return result;

    }

}
