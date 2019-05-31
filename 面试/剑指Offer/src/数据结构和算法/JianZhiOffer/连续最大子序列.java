package 数据结构和算法.JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某
 * 个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个
 * 为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * 
 * 
 * 思路：
 * 		1、首先这个题的坑在于：如何不让初始值0占据最大值，如果全都是负值，初始值0就会是最大的；
 * 		方法如下：
 * 				第一：使用list.add();然后把collection.sort就行排序；因为它能保证排的值始终是里面的子系列的值的比较，
 * 			不存在一个flag的初始值！
 * 				第二：使用max始终记住最大值！但是存在如下情况：
 * 						1、如果长度为0，直接返回0；
 * 						2、如果长度不为0，保证初始值是数组的第一个字
 * 							【这样就能能保证是是始终是序列的最小值了】就好了；【可能也能使用double和float的最小值！】
 * 扩展：1、如果采用递归？如何？
 * 		2、如果是采用的保证最小的序列至少是2个：那么应该是：
 * 				1、首先j的开始序列是i+2开始的；
 * 				2、其次初始值应该是前两个值，
 * 				3、初始情况的判断应该是假如长度小于2的时候
 * 
 * 
 * 
 */	
public class 连续最大子序列 {

	static int maxNum=-9999;
	
	public static void main(String[] args) {
		int [] arr= {6,-3,-2,7,-15,1,2,2};
		System.out.println(FindGreatestSumOfSubArray6(arr));
	}
	public static int FindGreatestSumOfSubArray(int[] array) {
		
		int len=array.length;
		if(len<=0) return 0;
		if(len==1) return array[0];
		int sum ;
		
		for(int i=0;i<len;i++) {
			sum=0;
			for(int j=i;j<len;j++) {
				sum+=array[j];
				if(sum>=maxNum) {maxNum=sum;}
			}
     }
		return maxNum;
 }

	public static int FindGreatestSumOfSubArray2(int[] array) {
	        List<Integer> list = new ArrayList<Integer>();
	        int max=array[0];
	        for(int i=0;i<array.length;i++){
	            int sum = 0;
	            for(int j=i;j<array.length;j++){
	                sum += array[j];
	                list.add(sum);
	                if(max<sum) max=sum;
	            }
	        }
	        if(list.size() <=0) return 0;
	        Collections.sort(list);
	        return max;
	    }
	
	public int FindGreatestSumOfSubArray3(int[] array) {
        int max=array[0];
        for(int i=0;i<array.length;i++){
            int sum = 0;
            for(int j=i;j<array.length;j++){
                sum += array[j];
                if(max<sum) max=sum;
            }
        }
        return max;
    }
//		递归的写法！！！！！！！
		static int  max;
		public int FindGreatestSumOfSubArray4(int[] array) {
			if(array.length<=0) return 0;
			int start=0;
			max=array[0];
			return FindGreatestSumOfSubArray5(array,start);
		}
		public int FindGreatestSumOfSubArray5(int[] array,int start) {
			if(start>=array.length) return max;
			int sum=0;
			for(int i=start;i<array.length;i++){
					sum += array[i];
					if(max<sum) max=sum;
			}
			start++;
			return FindGreatestSumOfSubArray5(array,start);
			
		}
		
		
//		动态规划
//		{6,-3,-2,7,-15,1,2,2}
//		思路是：进行遍历循环，然后开始的默认值值都是一样的；
//		然后，进行比较两个值，一个值是用来设置为一直加的值，直到加的值小于0
//		另外设置一个sum，保存之前的值！
		
		
		static int FindGreatestSumOfSubArray6(int[] array) {
	        if(array.length==0) return 0;
	        int sum = array[0], tempsum = array[0]; //注意初始值 不能设为0 防止只有负数
	        for(int i = 1; i < array.length; i++)   //从1开始 因为0的情况在初始化时完成了
	        {
	            tempsum = (tempsum < 0) ? array[i] : tempsum + array[i];
	            sum = (tempsum > sum) ? tempsum : sum;
	        }
	        return sum;
	    }
}



	
	
	