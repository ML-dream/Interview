package 数据结构和算法.JianZhiOffer;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	public static void main(String[] args) {
		HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
//		hashMap.put(1, 2);
		hashMap.put(2, 2);
		hashMap.put(3, 2);
		hashMap.compute(1,(k, v) -> ++v);
		
		for(Integer a:hashMap.keySet())
			System.out.println(a+"    "+hashMap.get(a));
			
		
	}
	
}