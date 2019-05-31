package 数据结构和算法.JianZhiOffer;

import java.util.HashMap;

/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *我的思路：首先是使用hashMap进行计数；
 */
public class 找出一个数组中出现一次的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {2,4,3,6,3,2,5,5};
//		FindNumsAppearOnce1(array,array,array);
		findFirst1(12);
	}
	
	
	
/*
 * 方法一：总体思路：将原来的数组分成两份，保证每一份都有一个不同的数！但是怎么分配呢？根据异或的规律；
 * 			相同的数异或肯定是0，不同的肯定是1；根据最后的结果，找到异或出1 的那一位数，但是通过判断
 * 			吧每个数进行一样位数的右移，然后进行和1进行与运算，
 * 			本质就是看这个数的二进制之后，这一位的数是0还是1，然后分成两份。这样分开之后，就能保证肯定把
 * 			两个不同的数分在两个组里，因位只有不同才会导致这一位异或是1，所以分成这样了！！！
 * 			相同的数相同位肯定是一样，所以他们会始终在相同的一组里，只有不同的数在不同的数组里。
 * 			最后只需要进行异或就可以了！
 * 
 */
		public static void FindNumsAppearOnce1(int[] array, int[] num1, int[] num2)    {
		        int length = array.length;
		        if(length == 2){
		            num1[0] = array[0];
		            num2[0] = array[1];
		            return;
		        }
		        int bitResult = 0;
		        for(int i = 0; i < length; ++i){
		            bitResult ^= array[i];
		        }
		        int index = findFirst1(bitResult);
		        for(int i = 0; i < length; ++i){
		            if(isBit1(array[i], index)){
		                num1[0] ^= array[i];
		                System.out.println("1"+array[i]);
		            }else{
		                num2[0] ^= array[i];
		            }
		        }
		    }
//		    根据最后的异或结果找到相应的第一个是1 的位 的index！
		    private static int findFirst1(int bitResult){
		        int index = 0;
		        while(((bitResult & 1) == 0) && index < 32){
		            bitResult >>= 1;
		            index++;
		        }
		        return index;
		    }
//		     这个是用来判断每个数是属于哪一组的，是根据上一步找到的index，然后位运算然后和1进行与运算，
//		    反正只要保证   根据该index位进行分组就ok了
		    private static boolean isBit1(int target, int index){
		        return ((target >> index) & 1) == 1;
		    }
	
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0;i<array.length;i++) {
        	if(map.containsKey(array[i])) map.remove(array[i]);
        	else map.put(array[i], 1);
        }
		
		int j=0;
		for(int key:map.keySet()) {
			if(j==0) {
				num1[0]=key;
				j++;
				continue;
			}
			if(j==1) {
				num1[0]=key;
				j++;
			}
			if(j>1) break;
		}
		//System.out.println(map.keySet().toString());
    }

}
