package JianZhiOffer;

import java.util.ArrayList;

/*
 * 题目：孩子们的游戏(圆圈中最后剩下的数)
 * 		
 * 正确思路：
 * 			约瑟夫环问题详解：https://blog.csdn.net/tingyun_say/article/details/52343897
 * 			大致解释：需要由小开始递归到n的人的时候，找到递推公式！然后利用循环或者迭代就好了！
 * 			old = (new + q) % n【n是old 大的那个】  
 * 			注意如果返回来的n就不一样了，同时公式也不一样new =（old-q+1）%n【new的n，小的那个n】 
 * 我的思路：
 * 			首先的思路就是递归，就是每次都是减一个然后知道剩下最后一个！
 */
public class n个人挑选礼物 {

	public static void main(String[] args) {
	//LastRemaining_Solution(10,3);
		getResult(5,3);
	}

		    
//	递归思路：其实应该很容易想到的的，因为已经有了递推公式！！！递推公式的本质就是递归！
//	只需要知道n=1的时候值，就可以一直递归反推！！
	int yuesefu(int n,int m){
        if(n == 1){
           return 0; //这里返回下标,从0开始，只有一个元素就是剩余的元素0
        }
        else{
           return (yuesefu(n-1,m) + m) % n; //我们传入的n是总共多少个数
   		}
		}

	
	/*      遍历思路：
		     * 编号为(0~n-1)
		     */
		    public static int getResult(int n, int m) {
		        if (n < 0 || m < 0) {
		            return -1;
		        }
		        int last = 0;//相当于，i=1，也就是只有一个数的时候的结果，然候在后面从2开始遍历，一直递推！
		        for(int i=2;i<=n;++i){
		            last = (last+m)%i;
		        }
		        // 因为实际编号为(1~n)
		        return (last+1);
		    }
		
	
//	我的思路是正好反着来的，就是根据大的一步步减少到只是剩下一个值！不推荐的目前不知道为什么是83.3%的通过率
/*
 * 您的代码已保存
答案错误:您提交的程序没有通过所有的测试用例
case通过率为83.33%

用例:
4000,997

对应输出应该为:

1027

你的输出为:

903
 * 
 */
	public static int LastRemaining_Solution(int n, int m) {
		if(n==0||m==0) return -1;
		ArrayList<Integer> list = new ArrayList();
		
		for(int i=0;i<n;i++) {
			list.add(i);
			}
		int num1=n;
		int num2;
		for(int j=0;j<n-1;j++) {
			
			int num=m%num1;
			if (num!=0) num =num-1;
			else num =num1-1;
			num1--;   //保证每一次都删除一个数
			list.remove(num); //  对应着，维护的所有的index的list中也应该删除相应的的那个index；最终只剩下最后的那个原来的index
			m=3+num;  //保证继续之前的排序，从删除的地方从新开始！加上删除的那个节点
		}
		
		return list.get(0);
        
    }
//	使用递归进行，很明显每一删除之后的又是另一个的相同模式的问题！
	public static int Solution(int start,int n, int m) {
		
		return m;
		
	}
}
