package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入n个整数,找出其中最小的K个数.例如输入4,5,1,6,2,7,3,8这8个数字,
 * 则最小的4个数字是1,2,3,4,.
 * 
 * 
 * 思路：
 * 		1、我自己的最普通，全部都是掉包完成的！
 * 		2、最好的思路是使用堆排序！
 * 注意：
 * 		1、使用的forEach但是无法做到正确，不知道为什么？使用for循环就可以正确完成！？？【不知道为什么？】
 * 		
 */		
public class 找出四个最小的数 {

	public static void main(String[] args) {
		int [] a= {4,5,1,6,2,7,3,8,3,4,5,3,2,2,1,2,3,34,4,5};
		GetLeastNumbers_Solution(a, 15);
	}
	
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (input.length==0) return arrayList;
		if (input.length<k) return arrayList;
		
//		精简代码如下：
	/*	
	 * 此处的精简依赖于arrays。sort能够对数组进行排序，collections貌似只能对集合进行排序？自己总结一下！
	 * Arrays.sort(input);
		for(int i=0;i<k;i++) {
			arrayList.add(input[i]);
		}
		return arrayList;
		*/
		
		for(int i=0;i<input.length;i++) {
			arrayList.add(input[i]);
		}
		
		Collections.sort(arrayList);
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		
		for(int i=0;i<k;i++) {
			arrayList2.add(arrayList.get(i));
		}
		/*
		 * 此处无法通过！！！！不知道为什么foreach不能通过！
		 * int n=0;
		 * for(Integer a:arrayList) {
			arrayList2.add(a);
			n++;
			if(n>=k) return arrayList2;
			
		}*/
		System.out.println(arrayList2.toString());
		return arrayList2;
        
    }
	
}
