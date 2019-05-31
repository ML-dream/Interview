package 数据结构和算法.JianZhiOffer;

/*
 * 题目：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 		 及条件判断语句（A?B:C）。
 * 思路：
 * 		1、使用递归
		 boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
		方法三，利用Math实现n(n+1)
  			public static int Sum_Solution1(int n) {
        		return (int) (Math.pow(n, 2) + n) >> 1;
    			}
 * 
 * 
 */
public class 叠加不能用乘除法for循环等等 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Sum_Solution2(100));
	}
	
	public static int Sum_Solution(int n) {
		if (n==1) return 1;
		return Sum_Solution(n-1)+n;
        
    }


		static int Sum_Solution1(int n) {
		        int sum = 0 ;
//		        我上面写的使用了IF！，利用短路求值原理，不使用If做到当n是小于=0的时候返回值，那么就得使用这个，短路求值做到了
//		        前面如果判断错误，那么后面的迭代就不执行了，也就是迭代就停止了
//		        JAVA写的时候注意：前面的条件需要加上括号！
		        Boolean flag =(n>=0) && (sum=Sum_Solution1(n - 1)+n)>0;
		        return sum;
		    }
	
		  public static int Sum_Solution2(int n) {
		        int ans = n;
		        boolean t=((ans>=0) && ((ans += Sum_Solution(n - 1))!=0));
		        return ans;
		    }
	

			  //用异常退出递归
			
			      public int Sum_Solution3(int n) {
			          return sum(n);
			      }
			      int sum(int n){
			          try{
			              int i = 1%n;
			              return n+sum(n-1);
			          }
			          catch(Exception e){
			              return 0;
			          }
			      }
			  
}
