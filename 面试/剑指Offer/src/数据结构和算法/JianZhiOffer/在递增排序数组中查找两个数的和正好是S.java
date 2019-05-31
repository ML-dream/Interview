package 数据结构和算法.JianZhiOffer;

import java.util.ArrayList;

public class 在递增排序数组中查找两个数的和正好是S {

	public static void main(String[] args) {
		int [] arr = {1,2,4,7,11,15};
		
		FindNumbersWithSum(arr,15);
	}
	
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int len=array.length-1;
		int start=0;
		//也可使用这个：：：while(true) {  if(start>len) break;}
		while(start<len) {
			if(array[start]+array[len]>sum) {
				len--;
			}
			if(array[start]+array[len]<sum) {
				start++;
				
			}
			if(array[start]+array[len]==sum) {
				list.add(array[start]);
				list.add(array[len]);
				break;
			}
		}
		return list;
        
    }
/*
 * ArrayList<Integer> list = new ArrayList<Integer>();
		int len=array.length-1;
		int start=0;
		while(true) {
			if(start>len) break;
			if(array[start]+array[len]>sum) {
				len--;
			}
			if(array[start]+array[len]<sum) {
				start++;
				
			}
			if(array[start]+array[len]==sum) {
				list.add(array[start]);
				list.add(array[len]);
				break;
			}
		}
		return list;
        
    }
 */
}
