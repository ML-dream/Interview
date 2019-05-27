package 总结API;

import java.util.HashMap;

/*背景：大小王可以替代任何牌！！！
 * 思路一：
 * 		找出除了0以为的max、min，然后max—min<5!
 * 		除了0以外，其他都不能重复！
 * 我的做法：
 * 			先排序，利用hashMap然后判断是否有除了0以外的数的数量不是1 的！---排序使用自带的？排序的算法？然后
 * 			然后找到max、min值！----遍历一遍的时候使用两个指针！保存最大的值即可！然后同时放入hashMap中！
 */
public class ds {

	public static void main(String[] args) {

	}
	
	public boolean isContinuous(int [] numbers) {
		int len=numbers.length;
		int max=0;
		int min=13;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++) {
			int num =numbers[i];
			if(num!=0) {
				if(num<max) max=num;
				if(num>min) min=num;
					if(map.containsKey(num)) {
						map.compute(1,(k, v) -> ++v);
					}
					else {
						map.put(num,1);
					}
			}
		}
		
		return false;
		
		
    }
}
