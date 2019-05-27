package JianZhiOffer;
/*
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路：
 * 		1、使用异或和与运算进行配合！
 *
 *
 */

public class 加减法 {

	public static void main(String[] args) {
		
		System.out.println(Add(11,12));
			
	}
	
//	1、使用异或和与运算进行配合！
//	首先要知道，两个除了0\1以为没有相同位数的数进行相异或，就是相加!
//	分为了两个步骤：
	/*
	 * 1、然后就是两个数异或就是找出两个数相加，但是不进位的数！【异或运算，只有不同的时候发生的运算】
	 * 2、两个数进行与运算，找到进位的数，【就是只有为1的时候才发生的事，然后左移一位】
	 * 3、然后两个数进行异或，如果这两个数如果没有与运算没有进位了，也就是都是不同的或者都是0，那么就停止循环啊
	 */
	public static int Add(int num1,int num2) {
	    while( num2!=0 ){
	        int sum = num1 ^ num2;
	        int carray = (num1 & num2) << 1;
	        num1 = sum;
	        num2 = carray;
	    }
	    return num1;
	}
	
	/*
	 * 同样原理的递归版本！！！
			//看我的递归版本
			class Solution {
			public:
			    int Add(int num1, int num2)
			    {
			        if(num2==0)
			            return num1;
			        return Add(num1^num2, (num1&num2)<<1);
			    }
			};
	 * 
	 */
	
	
//	其他思路，使用自增
	

		public class Solution {
		    public int Add(int num1,int num2) {
		        if(num1>0){
		            while(num1--!=0)
		                num2++;
		        }
		        else if(num1<0){
		            while(num1++!=0)
		                num2--;
		        }
		        return num2;
		    }
		}
//		思路三：
		public int Add2(int num1, int num2) {
		    return Integer.sum(num1, num2);
		 }
}
