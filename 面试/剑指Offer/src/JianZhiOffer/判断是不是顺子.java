package JianZhiOffer;

import java.util.HashMap;
import java.util.Map.Entry;

/*背景：大小王可以替代任何牌！！！
 * 思路一：
 * 		找出除了0以为的max、min，然后max—min<5!
 * 		除了0以外，其他都不能重复！
 *注意：
 *		尽量一次遍历解决所有问题，善于用指针！
 *		compute(1,(k, v) -> ++v);和map.put(num, map.get(num)+1);的速度差别很大，前者非常慢！！！！
 * 我的做法：
 * 			先排序，利用hashMap然后判断是否有除了0以外的数的数量不是1 的！---排序使用自带的？排序的算法？然后
 * 			然后找到max、min值！----遍历一遍的时候使用两个指针！保存最大的值即可！然后同时放入hashMap中！
 */
public class 判断是不是顺子 {

	public static void main(String[] args) {
		int [] numbers= {};
		System.out.println(isContinuous(numbers));
	}
	
	public static boolean isContinuous(int [] numbers) {
		int len=numbers.length;
//	注意这个条件要加上进行筛选！！！！！！
		if (len==0) return false;
//		使用两个指针进行判断筛选！
		int max=0;
		int min=13;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++) {
			int num =numbers[i];
			if(num!=0) {
				if(num>max) max=num;
				if(num<min) min=num;
					if(map.containsKey(num)) {
//						使用第一个方法用了200ms，而使用普通的简单方法只用了17ms！！！！！
//						map.compute(1,(k, v) -> ++v);
						map.put(num, map.get(num)+1);

					}
					else {
						map.put(num,1);
					}
			}
		}
		
//		其实这个地方可以直接省略，可以直接在前面直接进行返回false,见下面你的步骤！
		for(Entry<Integer,Integer> entry : map.entrySet()) {
			if (entry.getValue()>1) return false;
		}
		if(max-min>=len) return false;
		return true;
		
		
    }
}

/*
 * 
import java.util.HashMap;
import java.util.Map.Entry;
public class Solution {
   public static boolean isContinuous(int [] numbers) {
		int len=numbers.length;
//	注意这个条件要加上进行筛选！！！！！！
		if (len==0) return false;
		int max=0;
		int min=13;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<len;i++) {
			int num =numbers[i];
			if(num!=0) {
				if(num>max) max=num;
				if(num<min) min=num;
				
				if(map.containsKey(num)) return false;
                map.put(num,1);
			}
		}

		if(max-min>=len) return false;
		return true;
		
		
    }
}
 */
