package 数据结构和算法.JianZhiOffer;

public class _9taijie {

	/*方法一：直接举例找规律！
	 * 方法二：主要关注思考方式！！！！！！！【同理，使用这思路考虑前面的那个也可以！】
	* 	因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
		跳1级，剩下n-1级，则剩下跳法是f(n-1)
			跳2级，剩下n-2级，则剩下跳法是f(n-2)
			所以f(n)=f(n-1)+f(n-2)+...+f(1)
			因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
			所以f(n)=2*f(n-1)
	 */


		public int JumpFloorII(int target) {
		    if(target==1){
		        return 1;
		    }
			
			return 2*JumpFloorII(target-1);
		}
	}
/*public int JumpFloorII(int target) {
	
	return JumpFloorII(target-1)+target-1;
	
	
}
}
*/