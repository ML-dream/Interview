package 数据结构和算法.JianZhiOffer;

import java.util.Arrays;

/*
 * 题目描述
 *		输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于
 *		数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数
 *		之间的相对位置不变。
 *思路：
 *		1、要想相对位置不变，应该借助于冒泡的思想；
 *		2、可以使用插入排序的思想！就是进行循环，然后到了奇数进行判断，前面是偶数就将偶数整体后移，然后奇数插入到直到奇数的后面位置！
 *		3、可以使用在创建一个数组，然后在合并，也可以提前遍历知道偶数和奇数的个数进行有目的的存储！
 *注意：
 *	i和j的边界取值，需要当i=0和i最大的时候进行考虑自己是否会超出边界及其后面的j的取值是否在这两方面超出边界！！！！非常重要！！！！
 * 注意i和j的增减或者增的顺序一致性是否的两种思路的选择！
 */
public class JiOuPaixu {

	public static void main(String[] args) {

		int [] array_temp1= {1,2,3,4,5,6,7,8,9,10};
		/*System.out.println(array_temp1[2]);*/
		reOrderArray(array_temp1);
	}
	
		
//	方法一：使用的是冒泡排序，从前向后遍历的！
//		这里总结下冒泡排序的三种演变：
//	      1、最普通的就是i和j的递增或者递减的顺序一致，就相当于第一个值和后面的所有进行比较，
//	            最小的冒到最前面，但是会造成前面第二小的被排到最后！不会对后面的排序有什么帮助
//		2、i和j的顺顺序不一致，然后每一次冒泡都是从方向进行比较冒泡。，然后较大的值放在了后面，较小的值都一直向上冒泡
//		3、加入一个flag的变量，表示如果又一次循环没有任何移动，就表示顺序已经固定了，没有必要进行遍历了
	public static void reOrderArray(int [] array) {
			int length=array.length;
		    boolean flag=true;
			for(int i=0;i<length-1&&flag;i++) {
				flag=false;
				for(int j=0;j<length-i-1;j++) {
					if(array[j]%2==0&&array[j+1]%2==1) {
						int temp=array[j+1];
						array[j+1]=array[j];
						array[j]=temp;
						flag=true;
					}
					System.out.println(Arrays.toString(array));
					
				}
				
				
			}
			
			
			}
/*	   
	时间复杂度为O（n），空间复杂度为O（n）的算法
	
	整体思路：
	首先统计奇数的个数
	然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
	
	public class Solution {
	    public void reOrderArray(int [] array) {
	        if(array.length==0||array.length==1) return;
	        int oddCount=0,oddBegin=0;
	        int[] newArray=new int[array.length];
	        for(int i=0;i<array.length;i++){
	            if((array[i]&1)==1) oddCount++;
	        }
	        for(int i=0;i<array.length;i++){
	            if((array[i]&1)==1) newArray[oddBegin++]=array[i];
	            else newArray[oddCount++]=array[i];
	        }
	        for(int i=0;i<array.length;i++){
	            array[i]=newArray[i];
	        }
	    }
	}*/

}
