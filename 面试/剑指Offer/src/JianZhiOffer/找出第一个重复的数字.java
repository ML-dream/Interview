package JianZhiOffer;
/*
 * 思路一：使用HashSet
 * 思路二：使用布尔 数组---占用的内存小点；
 * 思路三：直接在原数组进行更改，不额外占用数组!
 * 
 * 
 */
import java.util.HashMap;
import java.util.HashSet;

public class 找出第一个重复的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	改进：其实可以不使用hashSet，因为每次进行进行是否包含的判断的时候，这个步骤明显
//	不如数组进行查询，并别数组存放boolean，占 的字节比较小！但是速度貌似不如hash
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if (length==0) return false;
		HashSet<Integer> map = new HashSet<Integer>();
		for(int i=0;i<length;i++) {
			if(map.contains(numbers[i])) {
				duplication[0]=numbers[i];
				return true;
			}
			map.add(numbers[i]);
		}
		return false;
	    
    }

}
